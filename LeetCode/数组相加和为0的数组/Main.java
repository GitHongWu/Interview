import java.util.*;

public class Main {
    // ����һ����n��Ԫ�ص�����S��S���Ƿ���Ԫ��a,b,c����a+b+c=0���ҳ�����S������������������Ԫ��
    // ��Ԫ�飨a��b��c���е�Ԫ�ر��밴�ǽ������С�����a��b��c��
    // �⼯�в��ܰ����ظ�����Ԫ�顣
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