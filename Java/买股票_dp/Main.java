import java.util.Scanner;
import java.util.Arrays;

public class Main {

    // ��������һ�����飬���е�\ i i ��Ԫ���ǹ�Ʊ�ڵ�\ i i ��ļ۸�
    // ����һ������������Ļ��ᡣ��ֻ�������˹�Ʊ�Ժ�������������������һ���㷨��������Ի�õ�������档
    // input: [1,4,2]
    // output: 3
    // input: [2,4,1]
    // output: 2

    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 2};
        int[] array2 = new int[] {2, 4, 1};
        buyStock(array2);
    }

    // slow O(n^2), ÿ��i����i����������
    public static int buyStock(int[] arr){
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        if(n <= 1) return 0;

        int min = arr[0];
        int max_profit = 0;
        for(int i = 0; i < n;i++){
            for(int j = i; j < n; j++){
                if(arr[j] > arr[i]){
                    int profit = arr[j]-arr[i];
                    max_profit = Math.max(max_profit, profit);
                }
            }
        }
        System.out.println(max_profit);
        return max_profit;
    }

    //fast dp
    public static int maxProfit (int[] prices) {
        
    }
}