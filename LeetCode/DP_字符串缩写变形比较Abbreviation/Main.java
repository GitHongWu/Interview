import java.util.*;

public class Main {

    // https://www.hackerrank.com/challenges/abbr/problem
    // https://www.geeksforgeeks.org/check-possible-transform-one-string-another/
    public static void main(String[] args) {
        // Input : s1 = daBcd s2 = ABC 
        // Output : yes
        // Explanation : daBcd -> dABCd -> ABC  
        // Convert a and b at index 1 and 3 to 
        // upper case, delete the rest those are 
        // lowercase. We get the string s2.

        String s1 = "daBcd";
        String s2 = "ABC";
        if (abbreviation(s1, s2))
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    public static boolean abbreviation(String s1, String s2){
        // calculates length
        int n = s1.length();
        int m = s2.length();
      
        boolean dp[][]=new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) 
        {
            for (int j = 0; j <= m; j++)
            {
                dp[i][j] = false;
            }
        }
        // mark 1st position as true
        dp[0][0] = true;
      
        // traverese for all DPi, j
        for (int i = 0; i < s1.length(); i++)
        {
            for (int j = 0; j <= s2.length(); j++)
            {
      
                // if possible for to convert i 
                // characters of s1 to j characters
                // of s2
                if (dp[i][j]) {
      
                    // if upper_case(s1[i])==s2[j]
                    // is same
                    if (j < s2.length() && 
                        (Character.toUpperCase(s1.charAt(i)) == s2.charAt(j)))
                        dp[i + 1][j + 1] = true;
      
                    // if not upper then deletion is 
                    // possible
                    if (!Character.isUpperCase(s1.charAt(i)))
                        dp[i + 1][j] = true;
                }
            }
        }
      
        return (dp[n][m]);
    }
}