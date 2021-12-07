//https://leetcode.com/problems/minimum-path-sum/

class Solution {
    public int minPathSum(int[][] grid) {
        int [][] dp = new int [grid.length][grid[0].length];

        for(int i = 0; i < dp.length; i++){
             for(int j = 0; j < dp[0].length; j++){
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if ( i == 0) dp[i][j] = grid[i][j] + dp[i][j-1];
                else if ( j == 0) dp[i][j] = grid[i][j] + dp[i-1][j];
                else dp[i][j] = -1;
            }
        }

        for(int i = 1; i < dp.length; i++){
             for(int j = 1; j < dp[0].length; j++){
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j-1] ,dp[i-1][j]);
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
