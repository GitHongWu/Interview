import java.util.*;

public class Main {
    // 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组
    // 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
    // 解集中不能包含重复的三元组。
    // input: {-10 0 10 20 -10 -40}
    // output: (-10, 0, 10) (-10, -10, 20)

    public static void main(String[] args) {
        int[] array = new int[]{-10, 0, 10, 20, -10, -40};
        sum2tar(array, 0);
    }

    public static void sum2tar(int[] arr, int tar){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int left = 0, right = arr.length-1; // declare two pointer, approch to the target number
        while(left < right){
            int sum = arr[right] + arr[left];
            if(sum == tar) 
        }
    }
}