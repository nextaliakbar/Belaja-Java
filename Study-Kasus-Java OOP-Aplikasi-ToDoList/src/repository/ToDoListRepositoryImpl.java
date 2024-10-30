package repository;

import entity.ToDoList;

public class ToDoListRepositoryImpl implements ToDoListRepository {

    private ToDoList[] data = new ToDoList[10];

    @Override
    public ToDoList[] getAll() {
        return data;
    }

    private boolean isFull() {
      boolean isFull = true;
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null) {
            // Model masi ada yang kosong
                isFull = false;
                break;
            }
        }
        return isFull;
    };

    private void resizeIfFull() {
        //Jika penuh kita resize ukuran array/data
        if(isFull()) {
            var temporary = data;
            data = new ToDoList[data.length * 2];
            for (int i = 0; i < temporary.length; i++) {
                data[i] = temporary[i];
            }
        }
    }

    @Override
    public void add(ToDoList toDoList) {
        resizeIfFull();
//      Menambah data ke array kosong
        for(int i = 0; i < data.length; i++) {
            if(data[i] == null) {
                data[i] = toDoList;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if((number - 1) >= data.length) {
            return false;
        } else if(data[number - 1] == null) {
            return false;
        } else {
            for(int i = (number - 1); i < data.length; i++) {
                if(i == data.length - 1) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
