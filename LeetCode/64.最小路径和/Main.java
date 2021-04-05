import java.lang.*;
import java.io.*;

import java.util.*;

public class Main {

    // input：grid = [[1,3,1],
    //                [1,5,1],
    //                [4,2,1]]
    // output：7
    // 解释：因为路径 1→3→1→1→1 的总和最小。

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        minPathSum(grid);
    }

    public static int minPathSum(int[][] grid) {
        // array check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // init dp[][]
        int rows = grid.length;
        int columns = grid[0].length;
        int dp[][] = new int[rows][columns];

        dp[0][0] = grid[0][0];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if(i == 0 && j == 0){   // edge case, very top left corner
                    dp[i][j] = grid[i][j];
                }
                else if(i == 0){  // at the first row, only can go from left
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                else if(j == 0){  // at the first column, only can go from top
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                else{   // compare the top and left
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[rows - 1][columns - 1];
    }
}