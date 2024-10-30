package programmer.zaman.now.thread;

public class DaemonApp {
    public static void main(String[] args) {
        var thread = new Thread(() -> {
            try {
            Thread.sleep(3_000L);
            System.out.println("Run Thread");
            } catch(InterruptedException exception) {

            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
