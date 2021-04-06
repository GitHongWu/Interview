import java.lang.*;
import java.io.*;

import java.util.*;

public class Main {

    // 给定数组pennys及它的大小(小于等于50)，同时给定一个整数amount
    // 请返回有多少种方法可以凑成amount。
    // input: [], 0
    // ouput: 1
    // input: [], 7
    // ouput: 0

    public static void main(String[] args) {
        int pennys[] = new int[]{1,2,3};
        int amount = 6;
        System.out.println(countWays(pennys, amount));
    }

    public static int countWays(int[] pennys, int amount) {
        if(amount == 0) return 1;
        if(pennys.length == 0 || pennys == null) return 0;

        int n = pennys.length;
        int[][]dp = new int[n][amount+1];
        // init first row
        // 如果此时的amount可以被coin整除，则可以有1种方式找零
        for(int i = 0; i < amount+1; i++){
            if(i % pennys[0] == 0){
                dp[0][i] = 1;
            }
        }
        // init first column
        // 当amount是0的时候，则有一种方式找零，也就是找0个硬币
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;     
        }
        for(int i = 1; i < n; i++){     // 从第二个硬币的位置开始loop，因为dp判断需要上一行的值
            for(int j = 1; j < amount+1; j++){  // 已经提前初始化过第一列，所以从1开始
                if(j < pennys[i]){  // 当amount小于coin的值时，则不考虑当前coin
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - pennys[i]];
                }
            }  
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n-1][amount];  
    }
}