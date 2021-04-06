import java.lang.*;
import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-yin-ru-pian-zhu-bu-tan-suo-zhao-l/
        // 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成
        // 总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回?-1。
        // 测试样例：
        // input: [1,2,4],3,3
        // output: 2

        // int pennys[] = new int[]{1,2,4};
        // int amount = 3;    // output: 2
        // int pennys[] = new int[]{1,2,5};
        // int amount = 11;   // output: 3
        int pennys[] = new int[]{5};
        int amount = 6; // -1
        // int pennys[] = new int[]{1,2147483647};
        // int amount = 2;   // output: 2

        // System.out.println("recursion: " + countWays3(pennys, amount));
        // System.out.println("Memo: " + countWays_memo(pennys, amount));
        System.out.println("DP: " + countWays_dp(pennys, amount));
    }

    // DP
    public static int countWays_dp(int[] pennys, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+ 1);    // 初始化备忘录,用amount+1填满备忘录,amount+1 表示该值不可以用硬币凑出来


        dp[0] = 0;   // 初始化0
        for(int i = 1; i <= amount; i++){
            for(int pennys : pennys){
                if (i - pennys >= 0){
                    dp[i] = Math.min(dp[i], dp[i-pennys]+1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount]; //若==amount+1则没法找，return-1
    }

    // memo + recursion
    // recursion with memo
    public static int countWays_memo(int[] pennys, int amount){
        int memo[] = new int[amount+1];
        memo[0] = 0;    // init memo
        return _countWays_memo(pennys, amount, memo);
    }
    public static int _countWays_memo(int[] pennys, int amount, int[] memo) {
        if(amount <= 0) return 0;
        // check if already computed in memo
        if(memo[amount] != 0) return memo[amount];

        int min = Integer.MAX_VALUE;
        for(int i : pennys){
            min = Math.min(min, _countWays_memo(pennys, amount-i, memo) + 1);
        }
        memo[amount] = min;    // update memo
        return min;
    }

    // recursion
    // 零钱找不开时不可用!!!
    // 缺点：在零钱找不开的情况下无法正确得到结果，因为每次都会在return的基础上+1，所以即使最后的子问题
    // 没有被for里面handle住便会return min既为MAX_VALUE， 然后return之后还是会+1
    // 解决方案：Tail-recursion
    public static int countWays3(int[] pennys, int amount) {
        if(amount <= 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int i : pennys){
            min = Math.min(min, countWays3(pennys, amount-i) + 1);  // 若是子问题return -1，这里还是会+1
        }
        return min;
    }
    
    // Tail-recursion
    // 初始化global min来保证每个递归的最小值，用count来记录每一次递归
    // 当无法被找零时，直接return。当可以被找零时，更新min值
    static int min = Integer.MAX_VALUE; // declare global variable
    public static int countWays2(int[] pennys, int amount) {
        _countWays2(pennys, amount, 0);
        // System.out.println(result + " " + Integer.MAX_VALUE);
        // if (result == 0) return -1;
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public static void _countWays2(int[] pennys, int amount, Integer count) {
        if(amount < 0) return;
        if(amount == 0) min = Math.min(min, count);
        
        for(int i : pennys){
            _countWays2(pennys, amount-i, count+1);
        }
    }
}