package entity;

public class ToDoList {
    private String toDo;

    public ToDoList(String toDo) {
      this.toDo = toDo;
    };

    public ToDoList() {};

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
}
