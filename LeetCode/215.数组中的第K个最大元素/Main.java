import java.util.*;

public class Main {

    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
        // 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
        int arr[] = new int[]{1,3,5,2,2};
        int k = 3;
        System.out.println(findKthLargest(arr, k));
    }

    // O(n^2): Array.sort是冒泡排序
    public static int findKthLargest(int[] nums, int k){
        int n = nums.length;
        Arrays.sort(nums);
        return(nums[n-k]);
    }
}