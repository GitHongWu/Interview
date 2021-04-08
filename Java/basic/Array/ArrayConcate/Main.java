import java.util.*;

public class Main {

    

    public static void main(String[] args) {
        int arr1[] = { 0, 1, 2, 3, 4, 5 };
        int arr2[] = { 5, 10, 20, 30, 40, 50 };

        // Parameters: arraycopy
        // src ? This is the source array.
        // srcPos ? This is the starting position in the source array.
        // dest ? This is the destination array.
        // destPos ? This is the starting position in the destination data.
        // length ? This is the number of array elements to be copied.
        System.arraycopy(arr1, 0, arr2, 0, 1);
        System.out.print("array2 = " + Arrays.toString(arr2));

        System.arraycopy(arr1, 1, arr2, 0, 2);
        System.out.print("array2 = " + Arrays.toString(arr2));
    }
}