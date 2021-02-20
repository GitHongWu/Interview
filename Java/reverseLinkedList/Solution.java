import java.io.*;
import java.util.*;

public class Solution {

    // 首位互换，换到中间停止
    static int[] reverseArray(int[] a) {
        int n = a.length;
        int start = 0;
        int end = n-1;
        while(start < n/2){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int arr[] = new int[]{1,4,3,2};
        System.out.println("Original: " + Arrays.toString(arr));

        int[] res = reverseArray(arr);
        System.out.print("Reverse: " + Arrays.toString(res));
    }
}
