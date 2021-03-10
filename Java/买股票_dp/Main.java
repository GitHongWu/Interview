import java.util.Scanner;
import java.util.Arrays;

public class Main {

    // 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
    // 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
    // input: [1,4,2]
    // output: 3
    // input: [2,4,1]
    // output: 2

    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 2};
        int[] array2 = new int[] {2, 4, 1};
        buyStock(array2);
    }

    // slow O(n^2), 每次i遍历i后面所有数
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