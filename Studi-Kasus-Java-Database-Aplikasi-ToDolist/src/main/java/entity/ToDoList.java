package entity;

public class ToDoList {

    private Integer id;

    private String toDo;

    public ToDoList(String toDo) {
      this.toDo = toDo;
    };

    public ToDoList() {};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
}
