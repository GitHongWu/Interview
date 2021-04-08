import java.util.Scanner;
import java.util.Arrays; 

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //input: 12,as,123 2,e 3, 4
        String input = in.nextLine();
        String[] s = input.split(",");
        
        System.out.println(Arrays.toString(s));
    }
}