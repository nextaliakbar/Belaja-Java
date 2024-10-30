package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.ToDoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;
    private ToDoListRepository toDoListRepository;

    @BeforeEach
    public void setUp(){
        dataSource = DatabaseUtil.getDataSource();
        toDoListRepository = new ToDoListRepositoryImpl(dataSource);
    }

    @Test
    public void testAdd() {
        ToDoList todoList = new ToDoList();
        todoList.setToDo("Budi");

        toDoListRepository.add(todoList);

    }

    @Test
    public void testRemove() {
        System.out.println(toDoListRepository.remove(1));
        System.out.println(toDoListRepository.remove(2));
        System.out.println(toDoListRepository.remove(3));
        System.out.println(toDoListRepository.remove(4));

    }

    @Test
    public void testGetAll() {
        toDoListRepository.add(new ToDoList("Ali"));
        toDoListRepository.add(new ToDoList("Akbar"));
        toDoListRepository.add(new ToDoList("Rafsanjani"));

        ToDoList[] todoLists = toDoListRepository.getAll();
        for(var todoList : todoLists){
            System.out.println(todoList.getId()+ " "+ todoList.getToDo());
        }
    }

    @AfterEach
    public void tearDown(){
        dataSource.close();
    }
}
