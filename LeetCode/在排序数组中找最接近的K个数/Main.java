import java.util.*;

public class Main {

    public static void main(String[] args) {
        // ��һ��Ŀ���� target, һ���Ǹ����� k, һ�������������е����� A��
        // ��A������target��ӽ���k��������������k������������target�Ľӽ��̶ȴ�С������������ӽ��̶��൱����ôС��������ǰ�档
        // ��� A = [1, 2, 3], target = 2 and k = 3, ��ô���� [2, 1, 3].
        // ��� A = [1, 4, 6, 8], target = 3 and k = 3, ��ô���� [4, 1, 6].
        // O(logn + k) ��ʱ�临�Ӷ�
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

    // ��ӽ�tar��left��Ϊindex
    public static int binarySearch(int arr[], int tar){
        int left = 0;
        int right = arr.length-1;
        while (left+1 <= right){    // �������ߵ�������targetһ��Զʱ(����25 35��target��30)��������Ҫ���������������λ����Ҫwhile(left+1 < right)����ǰһ����ֹѭ����ʹleft����25��ͬʱleft = mid������=mid+1��ֹleft���mid����
            int mid = left + (right - left) / 2;
            if (arr[mid] == tar) return mid;
            else if (arr[mid] < tar) left = mid;
            else right = mid;
            System.out.println(mid + " " + left + " " + right);
        }
        return left;
    }
}