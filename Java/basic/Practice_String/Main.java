import java.util.*;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        // char array to string
        char c[] = new char[]{'h','e','l','l','o'};
        System.out.println(c);

        // String to char array
        String s = "world";
        char[] charArray = s.toCharArray();
        System.out.println(charArray);
        
        // full fill string with spaces to the certain size
        String text = "Hello";
        int width = 12;
        fullFillString(text, width);
    }

    public static void fullFillString(String text, int width){
        int n = text.length();
        char[] fill = new char[width-n];
        Arrays.fill(fill, ' '); // fill the rest size of space
        System.out.println(String.valueOf(fill) + text);
    }
}