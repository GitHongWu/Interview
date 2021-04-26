import java.util.*;

public class Main {

    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
        // ����һ����������a,ͬʱ�������Ĵ�Сn��Ҫ�ҵ�K(K��1��n֮��)���뷵�ص�K���������֤�𰸴��ڡ�
        int arr[] = new int[]{1,3,5,2,2};
        int k = 3;
        System.out.println(findKthLargest(arr, k));
    }

    // O(n^2): Array.sort��ð������
    public static int findKthLargest(int[] nums, int k){
        int n = nums.length;
        Arrays.sort(nums);
        return(nums[n-k]);
    }
}