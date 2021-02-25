import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] array = {{1, 2}, {3, 4}, {}};
        System.out.println(Arrays.deepToString(array));
        
        // int[][] arr = new int[10][20];
        print2dArray(array);
        
    }

    public static void print2dArray(int[][] array){
        for (int i = 0; i < array.length; i++) 
            for (int j = 0; j < array[i].length; j++) 
                System.out.println("arr[" + i + "][" + j + "] = "
                                   + array[i][j]); 
    }
}