import java.util.*;

public class Main {

    // ����һ���Ǹ��������� A������һ�����飬�ڸ������У� A ������ż��Ԫ��֮�������������Ԫ�ء�
    // ���룺[3,1,2,4]
    // �����[2,4,3,1]
    // ��� [4,2,3,1]��[2,4,1,3] �� [4,2,1,3] Ҳ�ᱻ���ܡ�

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(unstableSort(new int[] {1,2,3,4})));
        // System.out.println(Arrays.toString(stableSort(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(sortArray(new int[]{1,2,5,6,7,3,4})));
    }

    // unstable
    // time complexity: O(n)
    // space complexity: O(1)
    // ˫ָ���ǰ�����м����
    public static int[] unstableSort(int[] array){
        int n = array.length;
        if (n <= 1) return array;

        int head = 0, tail = n-1;
        while(head < tail){
            if(array[head]%2!=0 && array[tail]%2!=0) tail--;
            else if(array[head]%2==0 && array[tail]%2==0) head++;
            else if(array[head]%2!=0 && array[tail]%2==0){
                int temp = array[head];
                array[head] = array[tail];
                array[tail] = temp;
                head++;
                tail--;
            }
            else{
                head++;
                tail--;
            }
            // System.out.println(head + " " + tail);
        }
        return array;
    }

    // stable
    // time complexity: O(n^2)
    // space complexity: O(1)
    // �������飬�ҵ�ż����swap��swap���Ѿ�sortż�������һλ��k��ż�����һλ��λ��
    public static int[] stableSort(int[] array){
        int n = array.length;
        if (n <= 1) return array;

        int k = 0;  // if even number found, swap to this target index
        for (int i = 0; i < n; i++){
            if(array[i]%2==0){  //even
                int j = i;
                while(k < j){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;
                }
                k++;
            }
        }
        return array;
    }

    // sort an integer array in the order of all event numbers in the first half + odd second part. And each part sordid in ascending order.
    // in place sort
    // input: int[] a = {1,2,5,6,7,3,4};
    // output: a={2,4,6,1,3,5,7}
    public static int[] sortArray(int[] arr){
        int n = arr.length;
        if(n<=1) return arr;

        int k = 0;
        for(int i = 0; i< n; i++){
            if(arr[i]%2==0){
                int j = i;
                while(k<j){ //swap even number to the front
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
                }
                k++;
            }   //end if %2==0
        }
        Arrays.sort(arr, 0, k);
        Arrays.sort(arr, k, n);
        return arr;
    }

}