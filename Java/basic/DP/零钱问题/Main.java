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
        // ʹ�õ�n�ֻ��ң�dp[n-1][m]+dp[n-1][m-peney[n]]
        // ���õ�n�ֻ��ң�dp[n-1][m]��Ϊʲô��ʹ�õ�n�ֻ����أ���Ϊpenney[n]>m��
        // �����Ϳ��������m>=penney[n]ʱ dp[n][m] = dp[n-1][m]+dp[n-1][m-peney[n]]������dp[n][m] = dp[n-1][m]
    }
}