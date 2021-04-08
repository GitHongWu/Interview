import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[10];
        
        // input intger with space: 2 4 5 1 6 23
        int counter = 0;
        while (in.hasNextInt()) {
            array[counter] = in.nextInt();
            counter++;
        }
        System.out.println(Arrays.toString(array));
    }
}