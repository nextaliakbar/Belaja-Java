package classes;

import java.util.Objects;

public class ObjectsApp {
    public static class Data {

        public Data(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data1 = (Data) o;
            return Objects.equals(data, data1.data);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(data);
        }

        @Override
        public String toString() {
            return "Data{" +
                    "data='" + data + '\'' +
                    '}';
        }

        private String data;
    }
    public static void main(String[] args) {
        execute(new Data("Akbar"));
    }

    private static void execute(Data data) {
        System.out.println(Objects.hashCode(data));
        System.out.println(Objects.toString(data));
    }
}
