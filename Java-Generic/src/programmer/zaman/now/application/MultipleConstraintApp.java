package programmer.zaman.now.application;

public class MultipleConstraintApp {
    public static void main(String[] args) {
        //Data<Manager> data1 = new Data<>(new Manager()); // Error karena Manager tidak implement CanSayHello
        Data<VicePrecident> data2 = new Data<>(new VicePrecident());
    }

    private static interface CanSayHello {
        void sayHello(String name);
    }

    private static abstract class Employee {

    }

    public static class Manager extends Employee {

    }

    private static class VicePrecident extends Employee implements CanSayHello{

        @Override
        public void sayHello(String name) {
            System.out.println("Hello " + name);
        }
    }

    private static class Data<T extends Employee & CanSayHello> {
        private T data;
        public Data(T data) {
            this.data = data;
        }
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
    }
}
