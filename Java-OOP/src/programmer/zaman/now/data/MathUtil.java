package programmer.zaman.now.data;

public class MathUtil {

    public static int sum(int... values) {
        int sum = 0;
        for(int value : values) {
            sum += value;
        }
        return sum;
    }
}
