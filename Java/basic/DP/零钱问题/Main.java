import java.lang.*;
import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
        // 测试样例：
        // input: [1,2,4],3,3
        // output: 2

        // 解析：设dp[n][m]为使用前n中货币凑成的m的种数，那么就会有两种情况：
        // 使用第n种货币：dp[n-1][m]+dp[n-1][m-peney[n]]
        // 不用第n种货币：dp[n-1][m]，为什么不使用第n种货币呢，因为penney[n]>m。
        // 这样就可以求出当m>=penney[n]时 dp[n][m] = dp[n-1][m]+dp[n-1][m-peney[n]]，否则，dp[n][m] = dp[n-1][m]
    }
}