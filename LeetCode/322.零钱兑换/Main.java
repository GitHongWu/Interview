import java.lang.*;
import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-yin-ru-pian-zhu-bu-tan-suo-zhao-l/
        // ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ�
        // �ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����?-1��
        // ����������
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
        Arrays.fill(dp, amount+ 1);    // ��ʼ������¼,��amount+1��������¼,amount+1 ��ʾ��ֵ��������Ӳ�Ҵճ���


        dp[0] = 0;   // ��ʼ��0
        for(int i = 1; i <= amount; i++){
            for(int pennys : pennys){
                if (i - pennys >= 0){
                    dp[i] = Math.min(dp[i], dp[i-pennys]+1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount]; //��==amount+1��û���ң�return-1
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
    // ��Ǯ�Ҳ���ʱ������!!!
    // ȱ�㣺����Ǯ�Ҳ�����������޷���ȷ�õ��������Ϊÿ�ζ�����return�Ļ�����+1�����Լ�ʹ����������
    // û�б�for����handleס���return min��ΪMAX_VALUE�� Ȼ��return֮���ǻ�+1
    // ���������Tail-recursion
    public static int countWays3(int[] pennys, int amount) {
        if(amount <= 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int i : pennys){
            min = Math.min(min, countWays3(pennys, amount-i) + 1);  // ����������return -1�����ﻹ�ǻ�+1
        }
        return min;
    }
    
    // Tail-recursion
    // ��ʼ��global min����֤ÿ���ݹ����Сֵ����count����¼ÿһ�εݹ�
    // ���޷�������ʱ��ֱ��return�������Ա�����ʱ������minֵ
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