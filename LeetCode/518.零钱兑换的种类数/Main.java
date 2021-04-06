import java.lang.*;
import java.io.*;

import java.util.*;

public class Main {

    // ��������pennys�����Ĵ�С(С�ڵ���50)��ͬʱ����һ������amount
    // �뷵���ж����ַ������Դճ�amount��
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
        // �����ʱ��amount���Ա�coin�������������1�ַ�ʽ����
        for(int i = 0; i < amount+1; i++){
            if(i % pennys[0] == 0){
                dp[0][i] = 1;
            }
        }
        // init first column
        // ��amount��0��ʱ������һ�ַ�ʽ���㣬Ҳ������0��Ӳ��
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;     
        }
        for(int i = 1; i < n; i++){     // �ӵڶ���Ӳ�ҵ�λ�ÿ�ʼloop����Ϊdp�ж���Ҫ��һ�е�ֵ
            for(int j = 1; j < amount+1; j++){  // �Ѿ���ǰ��ʼ������һ�У����Դ�1��ʼ
                if(j < pennys[i]){  // ��amountС��coin��ֵʱ���򲻿��ǵ�ǰcoin
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