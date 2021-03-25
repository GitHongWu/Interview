import java.lang.*;
import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // ��������penny�����Ĵ�С(С�ڵ���50)��ͬʱ����һ������aim���뷵���ж����ַ������Դճ�aim��
        // ����������
        // input: [1,2,4],3,3
        // output: 2

        // ��������dp[n][m]Ϊʹ��ǰn�л��Ҵճɵ�m����������ô�ͻ������������
        // ʹ�õ�n�ֻ��ң�dp[n-1][m]+dp[n-1][m-penny[n]]
        // ���õ�n�ֻ��ң�dp[n-1][m]��Ϊʲô��ʹ�õ�n�ֻ����أ���Ϊpenny[n]>m��
        // �����Ϳ��������m>=penny[n]ʱ dp[n][m] = dp[n-1][m]+dp[n-1][m-penny[n]]������dp[n][m] = dp[n-1][m]

        // int penny[] = new int[]{1,2,4};
        // int aim = 3;    // output: 2
        int penny[] = new int[]{1,2,5};
        int aim = 11;   // output: 3
        // int penny[] = new int[]{5};
        // int aim = 6;
        // System.out.println("DP: " + countWays(penny, aim));
        System.out.println("recursion: " + countWays2(penny, aim));
    }

    // recursion
    // ȱ�㣺����Ǯ�Ҳ�����������޷���ȷ�õ��������Ϊÿ�ζ�����return�Ļ�����+1�����Լ�ʹ����������
    // �Ѿ�return -1�� ��return֮���ǻ�+1
    // ���������Tail-recursion
    public static int countWays3(int[] penny, int aim) {
        if(aim == 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int i : penny){
            if(aim >= i){
                min = Math.min(min, countWays3(penny, aim-i) + 1);  // ����������return -1�����ﻹ�ǻ�+1
            }
            else{
                min = -1;
            }
        }
        return min;
    }
    
    // Tail-recursion
    // ��ʼ��global min����֤ÿ���ݹ����Сֵ����count����¼ÿһ�εݹ�
    // ���޷�������ʱ��ֱ��return�������Ա�����ʱ������minֵ
    static int min = Integer.MAX_VALUE; // declare global variable
    public static int countWays2(int[] penny, int aim) {
        _countWays2(penny, aim, 0);
        // System.out.println(result + " " + Integer.MAX_VALUE);
        // if (result == 0) return -1;
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public static void _countWays2(int[] penny, int aim, Integer count) {
        if(aim < 0) return;
        if(aim == 0) min = Math.min(min, count);
        
        for(int i : penny){
            _countWays2(penny, aim-i, count+1);
        }
    }

    // DP
    public static int countWays(int[] penny, int aim) {
        int n = penny.length;
        if(n==0||penny==null||aim<0){  
         return 0;     
        }  
        int[][] pd = new int[n][aim+1];  
        for(int i=0;i<n;i++){  
         pd[i][0] = 1;     
        }  
        for(int i=1;penny[0]*i<=aim;i++){  
         pd[0][penny[0]*i] = 1;     
        }  
        for(int i=1;i<n;i++){  
            for(int j=0;j<=aim;j++){  
                if(j>=penny[i]){  
                    pd[i][j] = pd[i-1][j]+pd[i][j-penny[i]];  
                }else{  
                    pd[i][j] = pd[i-1][j];  
                }  
            }  
        }  
        return pd[n-1][aim];  
    }
}