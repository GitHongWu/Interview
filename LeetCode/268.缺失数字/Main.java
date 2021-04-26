import java.util.*;

public class Main {

    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/missing-number/
        // ����һ������ [0, n] �� n ���������� nums ���ҳ� [0, n] �����Χ��û�г����������е��Ǹ�����

        // int nums[] = new int[]{9,6,4,2,3,5,7,0,1};
        // System.out.println(missingNumber(nums));
        int nums2[] = new int[]{9,6,4,3,5,7};
        System.out.println(missingNumber2(nums2));
    }

    // ֻ�����ڴ�0��ʼ
    public static int missingNumber(int[] nums) {
        int count=((nums.length+1)*nums.length)/2;
        System.out.println("count: " + count);
        for(int i:nums){
            count-=i;
        }
        return count;
    }

    // �ʺϴ��κ�����ʼ��arry�������ֽⷨҪ������sorted������ϵȲ�����: (����+ĩ��)*����/2
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