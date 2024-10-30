package classes;

import java.util.StringTokenizer;

public class StringTokenizerApp {
    public static void main(String[] args) {
        String value = "Ali Akbar Rafsanjani";
        StringTokenizer tokenizer = new StringTokenizer(value, " ");
        while(tokenizer.hasMoreTokens()) {
            String result = tokenizer.nextToken();
            System.out.println(result);
        }

        String[] split = value.split(" ");
        for(String val : split) {
            System.out.println(val);
        }
    }
}
