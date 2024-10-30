package programmer.zaman.now.lambda.util;

public class StringUtil {

    public static boolean isLowerCare(String value) {
        char[] chars = value.toCharArray();
        for(char c : chars) {
            if(!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
