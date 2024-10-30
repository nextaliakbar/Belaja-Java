import com.zaxxer.hikari.HikariDataSource;
import repository.ToDoListRepositoryImpl;
import service.ToDoListService;
import service.ToDoListServiceImpl;
import util.DatabaseUtil;
import view.ToDoListView;

public class Application {
    public static void main(String[] args) {
        HikariDataSource dataSource = DatabaseUtil.getDataSource();
        ToDoListRepositoryImpl toDoListRepository = new ToDoListRepositoryImpl(dataSource);
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);
        toDoListView.showToDoList();
    }
}
