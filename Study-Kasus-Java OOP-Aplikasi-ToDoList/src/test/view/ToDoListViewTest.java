package test.view;

import repository.ToDoListRepositoryImpl;
import service.ToDoListService;
import service.ToDoListServiceImpl;
import view.ToDoListView;

public class ToDoListViewTest {
    public static void main(String[] args) {
//        testShowToDoList();
//        testAddToDoList();
//        testRemoveToDoList();
    }

    private static void testShowToDoList() {
        ToDoListRepositoryImpl toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);
        toDoListService.addToDoList("Belajar Java Dasar");
        toDoListService.addToDoList("Belajar Java OOP");
        toDoListService.addToDoList("Belajar Java Standart Class");
        toDoListView.showToDoList();
    }

    private static void testAddToDoList() {
        ToDoListRepositoryImpl toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);
        toDoListView.addToDoList();
        toDoListView.showToDoList();
    }

    private static void testRemoveToDoList() {
        ToDoListRepositoryImpl toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);
        toDoListService.addToDoList("Belajar Java Dasar");
        toDoListService.addToDoList("Belajar Java OOP");
        toDoListService.addToDoList("Belajar Java Standart Class");
        toDoListView.showToDoList();
        toDoListView.removeToDoList();
    }
}
