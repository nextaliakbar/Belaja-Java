package test.service;
import entity.ToDoList;
import repository.ToDoListRepositoryImpl;
import service.ToDoListService;
import service.ToDoListServiceImpl;

public class ToDoListServiceTest {
    public static void main(String[] args) {
    }

    private static void testShowToDoList() {
        ToDoListRepositoryImpl toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService todoListService = new ToDoListServiceImpl(toDoListRepository);
        todoListService.showToDoList();
    }

    private static void testAddToDoList() {
        ToDoListRepositoryImpl toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService todoListService = new ToDoListServiceImpl(toDoListRepository);
        todoListService.addToDoList("Belajar Java Dasar");
        todoListService.addToDoList("Belajar Java OOP");
        todoListService.addToDoList("Belajar Java Standart Classes");
        todoListService.showToDoList();
    }

    private static void testRemoveToDoList() {
        ToDoListRepositoryImpl toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService todoListService = new ToDoListServiceImpl(toDoListRepository);
        todoListService.addToDoList("Belajar Java Dasar");
        todoListService.addToDoList("Belajar Java OOP");
        todoListService.addToDoList("Belajar Java Standart Classes");
        todoListService.showToDoList();
        todoListService.removeToDoList(3);
        todoListService.showToDoList();
    }
}
