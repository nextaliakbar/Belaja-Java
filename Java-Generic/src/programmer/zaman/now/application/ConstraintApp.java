package programmer.zaman.now.application;

public class ConstraintApp {
    public static void main(String[] args) {
        NumberData<Integer> integerNumberData = new NumberData<>(1000);
        NumberData<Long> longNumberData = new NumberData<>(1000L);
        //NumberData<String> stringNumberData = new NumberData<String>("ABCDE"); // Error
    }

    private static class NumberData<T extends Number> {
        private T numberData;
        public NumberData(T numberData) {
            this.numberData = numberData;
        }

        public T getNumberData() {
            return numberData;
        }

        public void setNumberData(T numberData) {
            this.numberData = numberData;

        }
    }
}
