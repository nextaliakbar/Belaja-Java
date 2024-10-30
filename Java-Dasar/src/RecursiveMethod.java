public class RecursiveMethod {
    public static void main(String[] args) {
        System.out.println(factorialLoop(5));
        System.out.println(factorialRecursive(5));
        loop(10000);
    }

//  Tanpa Recursive
    static int factorialLoop(int value) {
        int result = 1;
        for(int counter = 1; counter <= value; counter++) {
            result*=counter;
        }

        return result;
    }

//  Dengan Recursive
    static int factorialRecursive(int value) {
        if(value == 1) {
            return 1;
        } else {
            return value * factorialRecursive(value - 1);
        }
    }

    static void loop(int value) {
        if(value == 0) {
            System.out.println("Selesai");
        } else {
            System.out.println("Loop ke " + value);
            loop(value - 1);
        }
    };

}
