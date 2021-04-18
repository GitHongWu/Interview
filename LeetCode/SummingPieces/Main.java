import java.util.*;

public class Main {

    // https://www.hackerrank.com/challenges/summing-pieces/problem

    // input: 1 3 6
    // output: 73

    // input: 4 2 9 10 1
    // output: 971

    // input: 477 392 161 421 245 50 530 889 750 16 545 303 898 785 162 279 677 664 126 149 814 360 334 681 473 293 267 120 825 21 267 301 413 779 73 657 181 602 897 930 969 441 232 218 577 745 848 253
    // output: 868784194

    // (a - b) % m == (a%m - b%m + m) % m

    static int MOD = 1000000007;

    public static void main(String[] args) {
        // int arrays[] = new int[]{1, 3, 6};
        // int arrays[] = new int[]{477, 392, 161, 421, 245, 50, 530, 889, 750, 16, 545, 303, 898, 785, 162, 279, 677, 664, 126, 149,
        //                          814, 360, 334, 681, 473, 293, 267, 120, 825, 21, 267, 301, 413, 779, 73, 657, 181, 602, 897, 930,
        //                          969, 441, 232, 218, 577, 745, 848, 253};
        
        // n = 28, array = 477 392 161 421 245 50 530 889 750 16 545 303 898 785 162 279 677 664 126 149 814 360 334 681 473 293 267 120
        int arrays[] = new int[]{477, 392, 161, 421, 245, 50, 530, 889, 750, 16, 545, 303, 898, 785, 162, 279, 677, 664, 126, 149,
                                 814, 360, 334, 681, 473, 293, 267, 120};
        
        System.out.println(summingPieces2(arrays));
        
    }

    // did not pass time 16 - 28, Time limit exceeded
    static int summingPieces2(int[] arr) {
        // write the square function
        Long powerSquare[] = new Long[1000003];
        powerSquare[0] = Long.valueOf(1); // 2^0 = 1
        for (int i = 1; i<1000003; i++)
        {
            powerSquare[i] = (2 * powerSquare[i - 1]) % MOD;
        }

        int n = arr.length;
        Long dp[] = new Long[n];    // have to declare as Long, otherwise result be neginative

        int result = 0;
        for(int i = 0; i < n; i++){
            dp[i] = ((powerSquare[i + 1] + powerSquare[i] - 1) * powerSquare[n - 1 - i] - powerSquare[i] + MOD) % MOD;
            // System.out.print((powerSquare[i + 1] + powerSquare[i] - 1)*powerSquare[n - 1 - i] - powerSquare[i] + MOD + " ");
            result += (int)(arr[i] * dp[i] % MOD);
            // System.out.print(result + " ");
            result = result % MOD;
        }
        // System.out.print(Arrays.toString(dp));
        
        return result;
    }

    // test case size too large not working
    static int summingPieces(int[] arr) {
        int n = arr.length;
        double dp[] = new double[n];
        
        dp[0] = Math.pow(2, n) - 1;

        int y = n - 2;
        for(int i = 1; i < n; i++){
            // (a - b) % m == (a%m - b%m + m) % m
            int temp = (Math.pow(2, y)%MOD - Math.pow(2, i-1)%MOD + MOD) % MOD;
            // dp[i] = dp[i-1] + Math.pow(2, y) - Math.pow(2, i-1);
            dp[i] = dp[i-1] + temp;
            y--;
        }
        
        int result = 0;
        for(int j = 0; j < n; j++){
            result += arr[j] * dp[j];
        }
        
        System.out.print(Arrays.toString(dp));
        
        return result;
    }
}