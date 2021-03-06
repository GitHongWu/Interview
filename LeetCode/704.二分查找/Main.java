import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 给定一个?n?个元素有序的（升序）整型数组?nums 和一个目标值?target ?，写一个函数搜索?nums?中的 target，如果目标值存在返回下标，否则返回 -1。
        
        // 输入: nums = [-1,0,3,5,9,12], target = 9
        // 输出: 4
        // 解释: 9 出现在 nums 中并且下标为 4

        // 输入: nums = [-1,0,3,5,9,12], target = 2
        // 输出: -1
        // 解释: 2 不存在 nums 中因此返回 -1
        
        int array[] = new int[]{1, 4, 6, 8};
        int target = 2;
        System.out.println(binarySearch2(array, target));
    }

    // 找到准确tar的index
    public static int binarySearch(int arr[], int tar){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == tar) return mid;
            else if (arr[mid] < tar) left = mid+1;
            else right = mid - 1;
        }
        return -1;
    }

    // 最接近tar的left作为index
    public static int binarySearch2(int arr[], int tar){
        int left = 0;
        int right = arr.length-1;
        while (left+1 < right){    // 左右两边的数距离target一样远时(例如25 35，target是30)，我们需要二分搜索出左边那位，就要while(left+1 < right)来提前一次终止循环，使left落在25，同时left = mid，不能=mid+1防止left错过mid数。
            int mid = left + (right - left) / 2;
            if (arr[mid] == tar) return mid;
            else if (arr[mid] < tar) left = mid;
            else right = mid;
        }
        return left;
    }
}