package service;

import entity.ToDoList;
import repository.ToDoListRepository;
import repository.ToDoListRepositoryImpl;

public class ToDoListServiceImpl implements ToDoListService {

    private ToDoListRepository toDoListRepository;

    public ToDoListServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    };

    @Override
    public void showToDoList() {
        System.out.println("To Do List");
        ToDoList[] dataModels = toDoListRepository.getAll();
        for (int i = 0; i < dataModels.length; i++) {
            var dataModel = dataModels[i];
            var number = i+1;
            if(dataModel != null) {
                System.out.println(number+ "." + dataModel.getToDo());
            }
        }
    }

    @Override
    public void addToDoList(String toDo) {
        ToDoList toDoList = new ToDoList(toDo);
        toDoListRepository.add(toDoList);
        System.out.println("Successfully added To Do List " + toDoList.getToDo());
    }

    @Override
    public void removeToDoList(Integer number) {
        boolean success = toDoListRepository.remove(number);
        if(success) {
            System.out.println("Successfully removed To Do List " + number);
        } else {
            System.err.println("Failed to remove To Do List " + number);
        }
    }
}
