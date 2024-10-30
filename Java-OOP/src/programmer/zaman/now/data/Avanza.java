package programmer.zaman.now.data;

public class Avanza implements Car , IsMaintenance  {

    public String getBrand() {
        return "Avanza";
    }

    public void drive() {
        System.out.println("Avanza Drive");
    }


    public int getTire() {
        return 4;
    }


    public boolean isMaintenance() {
        return false;
    }
}
