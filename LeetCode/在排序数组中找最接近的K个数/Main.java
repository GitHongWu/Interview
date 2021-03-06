import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 给一个目标数 target, 一个非负整数 k, 一个按照升序排列的数组 A。
        // 在A中找与target最接近的k个整数。返回这k个数并按照与target的接近程度从小到大排序，如果接近程度相当，那么小的数排在前面。
        // 如果 A = [1, 2, 3], target = 2 and k = 3, 那么返回 [2, 1, 3].
        // 如果 A = [1, 4, 6, 8], target = 3 and k = 3, 那么返回 [4, 1, 6].
        // O(logn + k) 的时间复杂度
        int array[] = new int[]{1, 2, 3};
        int array2[] = new int[]{1, 4, 6, 8};
        int target = 2;
        int k = 3;  // how many result need to return

        // findClosest(array2, target, k);
        System.out.println(binarySearch(array2, target));
    }

    public static void findClosest(int arr[], int tar, int k){
        int n = arr.length;
        if(arr == null || n == 0) return;

        int[] result = new int[k];
        int left = binarySearch(arr, tar); //find the most closest number or its left index
        int right = left + 1;
        
        for(int i = 0; i < k; i++){
            if(left < 0){
                result[i] = arr[right];
                right++;
            }
            else if(right >= n){
                result[i] = arr[left];
                left--;
            }
            else if(Math.abs(arr[left] - tar) <= Math.abs(arr[right] - tar) && left >= 0){    //left is smaller or equal to right, keep the left
                result[i] = arr[left];
                left--;
            }
            else{
                result[i] = arr[right];
                right++;
            }
        }
        System.out.println(Arrays.toString(result));
        // return result;
    }

    // 最接近tar的left作为index
    public static int binarySearch(int arr[], int tar){
        int left = 0;
        int right = arr.length-1;
        while (left+1 <= right){    // 左右两边的数距离target一样远时(例如25 35，target是30)，我们需要二分搜索出左边那位，就要while(left+1 < right)来提前一次终止循环，使left落在25，同时left = mid，不能=mid+1防止left错过mid数。
            int mid = left + (right - left) / 2;
            if (arr[mid] == tar) return mid;
            else if (arr[mid] < tar) left = mid;
            else right = mid;
            System.out.println(mid + " " + left + " " + right);
        }
        return left;
    }
}