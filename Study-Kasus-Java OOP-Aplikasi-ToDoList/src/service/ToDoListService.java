package service;

import entity.ToDoList;

public interface ToDoListService {
    void showToDoList();
    void addToDoList(String toDo);
    void removeToDoList(Integer number);
}
