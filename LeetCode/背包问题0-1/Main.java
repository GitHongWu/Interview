import java.util.*;

public class Main {

    public static void main(String[] args) {
        // int items[] = new int[]{2,4};
        // int target = 7;
        int items[] = new int[]{3,4,4,4,8};
        int target = 9;

        System.out.println(unboundedKnapsack(target, items));
    }

    static int unboundedKnapsack(int target, int[] items) {
        int n = items.length;
        int[][]dp = new int[n + 1][target + 1];
        // init first row 
        for (int i = 0; i < target + 1; i++){
            dp[0][i] = 0;
        }
        // dp
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= target; j++){
                if(items[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-items[i-1]] + items[i-1]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][target];
    }
}