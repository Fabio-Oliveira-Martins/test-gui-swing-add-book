package Utils;

public class Formatter {

    public static String capitalize(String string) {
        char[] chars = string.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(i == 0) { continue; }
            if(Character.isWhitespace(chars[i - 1])) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        return String.valueOf(chars);
    }
}
