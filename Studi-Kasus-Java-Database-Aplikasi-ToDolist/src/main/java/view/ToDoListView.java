package view;

import service.ToDoListService;
import util.InputUtil;

public class ToDoListView {

    private ToDoListService toDoListService;
    public ToDoListView(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    public void showToDoList() {
        while (true) {
            toDoListService.showToDoList();
            System.out.println("Menu");
            System.out.println("1.Tambah");
            System.out.println("2.Hapus");
            System.out.println("x.Keluar");
            String input = InputUtil.inputData("Pilih Menu");
            if(input.equalsIgnoreCase("1")) {
                addToDoList();
            } else if(input.equalsIgnoreCase("2")) {
                removeToDoList();
            } else if(input.equalsIgnoreCase("x")) {
                break;
            } else {
                System.err.println("Invalid Menu");
            }
        }
    }

    public void addToDoList() {
        System.out.println("Menambah ToDo List");
        var todo = InputUtil.inputData("ToDo (x jika batal)");
        if(todo.equals("x")) {
//           batal
        } else {
            toDoListService.addToDoList(todo);
        }
    }

    public void removeToDoList() {
        System.out.println("Menghapus ToDo List");
        var number = InputUtil.inputData("Nomor ToDo (x jika batal)");
        if(number.equals("x")) {
            // Batal
        } else {
            toDoListService.removeToDoList(Integer.valueOf(number));
        }
    }
}
