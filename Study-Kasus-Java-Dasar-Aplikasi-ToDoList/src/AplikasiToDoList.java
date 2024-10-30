import java.util.Scanner;

public class AplikasiToDoList {
    private static String[] dataModels = new String[10];
    private static java.util.Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        unitTestShowToDoList();
//        unitTestAddToDoList();
//        unitTestRemoveToDoList();
//        unitTestViewShowToDoList();
//        unitTesViewAddToDoList();
//        unitTestViewRemoveToDoList();
        viewShowToDoList();
    }

    /**
     * Menampilkan to do list
     */
    private static void showToDoList() {
        System.out.println("ToDo List");
        for (int i = 0; i < dataModels.length; i++) {
            var dataModel = dataModels[i];
            var number = i+1;
            if(dataModel != null) {
                System.out.println(number+ "." + dataModel);
            }
        }
    }

    /**
     * Unit test
     */
    private static void unitTestShowToDoList() {
        dataModels[0] = "Belajar Java Dasar";
        dataModels[1] = "Belajar Membuat Aplikasi To Do List";
        showToDoList();
    }

    private static void unitTestAddToDoList() {
        for (int i = 0; i < 25; i++) {
            addToDoList("Belajar Java "+(++i));
        }
        showToDoList();
    }

    private static void unitTestRemoveToDoList() {
        addToDoList("Belajar Java Dasar 1");
        addToDoList("Belajar Java Dasar 2");
        addToDoList("Belajar Java Dasar 3");
        addToDoList("Belajar Java Dasar 4");
        addToDoList("Belajar Java Dasar 5");

        boolean result = removeToDoList(3);
        System.out.println(result);
        showToDoList();
    }

    private static void unitTestViewShowToDoList() {
        viewShowToDoList();
    }

    private static void unitTestViewAddToDoList() {
        viewAddToDoList();
        showToDoList();
    }

    private static void unitTestViewRemoveToDoList() {
        addToDoList("Belajar Java Dasar 1");
        addToDoList("Belajar Java Dasar 2");
        addToDoList("Belajar Java Dasar 3");
        addToDoList("Belajar Java Dasar 4");
        addToDoList("Belajar Java Dasar 5");
        showToDoList();
        viewRemoveToDoList();
        showToDoList();
    }

    private static String inputData(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

    /**
     * Menambah to do list
     */
    private static void addToDoList(String data) {
//   Cek apakah data penuh
        boolean isFull = true;
        for (int i = 0; i < dataModels.length; i++) {
            if(dataModels[i] == null) {
//              Model masi ada yang kosong
                isFull = false;
                break;
            }
        }

//      Jika penuh kita resize ukuran array/data
        if(isFull) {
            var temporary = dataModels;
            dataModels = new String[dataModels.length * 2];
            for (int i = 0; i < temporary.length; i++) {
                dataModels[i] = temporary[i];
            }
        }

//      Menambah data ke array kosong
        for(int i = 0; i < dataModels.length; i++) {
            if(dataModels[i] == null) {
                dataModels[i] = data;
                break;
            }
        }
    }

    /**
     * Menghapus to do list
     */
    private static boolean removeToDoList(Integer number) {
        if((number - 1) >= dataModels.length) {
            return false;
        } else if(dataModels[number - 1] == null) {
            return false;
        } else {
            for(int i = (number - 1); i < dataModels.length; i++) {
                if(i == dataModels.length - 1) {
                    dataModels[i] = null;
                } else {
                    dataModels[i] = dataModels[i + 1];
                }
            }
            return true;
        }
    }

    /**
     * Menampilkan view to do list
     */
    private static void viewShowToDoList() {
        while (true) {
            showToDoList();
            System.out.println("Menu");
            System.out.println("1.Tambah");
            System.out.println("2.Hapus");
            System.out.println("x.Keluar");
            String input = inputData("Pilih Menu");
            if(input.equalsIgnoreCase("1")) {
                viewAddToDoList();
            } else if(input.equalsIgnoreCase("2")) {
                viewRemoveToDoList();
            } else if(input.equalsIgnoreCase("x")) {
                break;
            } else {
                System.err.println("Invalid Menu");
            }
        }
    }

    /**
     * Menampilkan view menambah to do list
     */
    private static void viewAddToDoList() {
        System.out.println("Menambah ToDo List");
        var todo = inputData("ToDo (x jika batal)");
        if(todo.equals("x")) {
//           batal
        } else {
            addToDoList(todo);
        }
    }

    /**
     * Menampilkan view menghapus to do list
     */
    private static void viewRemoveToDoList() {
        System.out.println("Menghapus ToDo List");
        var number = inputData("Nomor ToDo (x jika batal)");
        if(number.equals("x")) {
//            Batal
        } else {
            boolean succes = removeToDoList(Integer.valueOf(number));
            if(!succes) {
                System.err.println("Gagal menghapus ToDo List ke :" + number);
            }
        }
    }
}
