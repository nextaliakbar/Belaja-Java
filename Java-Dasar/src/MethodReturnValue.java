public class MethodReturnValue {
    public static void main(String[] args) {
        System.out.println(sum(200, 200));
        System.out.println(result(200, "+", 100));
        System.out.println(result(200, "-", 100));
        System.out.println(result(200, "", 100));
    }

    static int sum(int value1, int value2) {
        return value1 + value2;
    }

    static int result(int value1, String operasi, int value2) {
        switch (operasi) {
            case "+" : return value1 + value2;
            case "-" : return value1 - value2;
            default: return 0;
        }
    }
}
