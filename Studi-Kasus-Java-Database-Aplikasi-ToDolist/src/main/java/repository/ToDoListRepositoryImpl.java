package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.ToDoList;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoListRepositoryImpl implements ToDoListRepository {

    private HikariDataSource dataSource;

    public ToDoListRepositoryImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ToDoList[] getAll() {
        String sql = "SELECT id, todo FROM todolist";
        try(Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            List<ToDoList> list = new ArrayList<>();
            while (rs.next()) {
                ToDoList todoList = new ToDoList();
                todoList.setId(rs.getInt("id"));
                todoList.setToDo(rs.getString("todo"));
                list.add(todoList);
            }

            return list.toArray(new ToDoList[]{});

        } catch(SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void add(ToDoList toDoList) {
        String sql = """
                INSERT INTO todolist (todo) VALUES (?)
                """;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, toDoList.getToDo());
            preparedStatement.executeUpdate();
        } catch(SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    private boolean isExist(Integer number) {
        String sql = "SELECT id FROM todolist WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number){
        if(isExist(number)) {
            String sql = "DELETE FROM todolist WHERE id=?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1, number);
                preparedStatement.executeUpdate();
                return true;
            } catch(SQLException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            return false;
        }
    }
}
