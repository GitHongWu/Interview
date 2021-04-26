import java.util.*;

public class Main {

    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/missing-number/
        // 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

        // int nums[] = new int[]{9,6,4,2,3,5,7,0,1};
        // System.out.println(missingNumber(nums));
        int nums2[] = new int[]{9,6,4,3,5,7};
        System.out.println(missingNumber2(nums2));
    }

    // 只适用于从0开始
    public static int missingNumber(int[] nums) {
        int count=((nums.length+1)*nums.length)/2;
        System.out.println("count: " + count);
        for(int i:nums){
            count-=i;
        }
        return count;
    }

    // 适合从任何数开始的arry，但这种解法要求数组sorted，并结合等差数列: (首项+末项)*项数/2
    public static int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        int count=(nums[0] + nums[nums.length-1]) * (nums.length+1) /2;
        System.out.println("count: " + count);
        for(int i:nums){
            count-=i;
        }
        return count;
    }
}