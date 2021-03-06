import java.util.*;

public class Main {

    public static void main(String[] args) {
        // ����һ��?n?��Ԫ������ģ�������������?nums ��һ��Ŀ��ֵ?target ?��дһ����������?nums?�е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��
        
        // ����: nums = [-1,0,3,5,9,12], target = 9
        // ���: 4
        // ����: 9 ������ nums �в����±�Ϊ 4

        // ����: nums = [-1,0,3,5,9,12], target = 2
        // ���: -1
        // ����: 2 ������ nums ����˷��� -1
        
        int array[] = new int[]{1, 4, 6, 8};
        int target = 2;
        System.out.println(binarySearch2(array, target));
    }

    // �ҵ�׼ȷtar��index
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

    // ��ӽ�tar��left��Ϊindex
    public static int binarySearch2(int arr[], int tar){
        int left = 0;
        int right = arr.length-1;
        while (left+1 < right){    // �������ߵ�������targetһ��Զʱ(����25 35��target��30)��������Ҫ���������������λ����Ҫwhile(left+1 < right)����ǰһ����ֹѭ����ʹleft����25��ͬʱleft = mid������=mid+1��ֹleft���mid����
            int mid = left + (right - left) / 2;
            if (arr[mid] == tar) return mid;
            else if (arr[mid] < tar) left = mid;
            else right = mid;
        }
        return left;
    }
}