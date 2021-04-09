import java.util.*;

public class Main {
    // Given two numbers x and n, find a number of ways x can be expressed as
    // sum of n-th power of unique natural numbers.

    // Input  : x = 10, n = 2
    // Output : 1
    // Explanation: 10 = 12 + 32, Hence total 1 possibility

    // Input  : x = 100, n = 2
    // Output : 3
    // Explanation: 
    // 100 = 102 OR 62 + 82 OR 12 + 32 + 42 + 52 + 72 Hence total 3 possibilities

    public static void main(String[] args) {
        int x = 100, n = 2;
        System.out.println(checkRecursive(x, n, 1, 0));
    }

    // Function to check power representations recursively
    static int checkRecursive(int x, int n, int curr_num,
                              int curr_sum)
    {
        // Initialize number of ways to express
        // x as n-th powers of different natural
        // numbers
        int results = 0;
 
        // Calling power of 'i' raised to 'n'
        int p = (int)Math.pow(curr_num, n);
        while (p + curr_sum < x) {
            // Recursively check all greater values of i
            results += checkRecursive(x, n, curr_num + 1,
                                      p + curr_sum);
            curr_num++;
            p = (int)Math.pow(curr_num, n);
        }
 
        // If sum of powers is equal to x
        // then increase the value of result.
        if (p + curr_sum == x)
            results++;
 
        // Return the final result
        return results;
    }
}