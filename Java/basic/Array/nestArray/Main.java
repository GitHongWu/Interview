import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] array = {{1, 2}, {3, 4}, {}};
        System.out.println(Arrays.deepToString(array));

        // int[][] array2 = [[1, 2], [3, 4], []];  //illegal
        // int[][] array2 = {[1, 2], [3, 4], []};  //illegal
        // System.out.println(Arrays.deepToString(array2));
        
        // int[][] arr = new int[10][20];
        for (int i = 0; i < 2; i++) 
            for (int j = 0; j < 2; j++) 
                System.out.println("arr[" + i + "][" + j + "] = "
                                   + array[i][j]); 
    }
}