package programmer.zaman.now.thread;

public class SynchronizedCounter {

    private Long value = 0L;

    // Seluruh logic dalam method di synchronize
    public synchronized void increment1() {
        value++;
    }

    public void increment2() {
        // Baris ini dapat di akses oleh banyak thread secara bersamaan

        synchronized (this) { // Baris ini bisa di akses banyak thread secara berurutan
            value++;
        }

        // Baris ini dapat di akses oleh banyak thread secara bersamaan
    }

    public Long getValue() {

        return value;
    }
}
