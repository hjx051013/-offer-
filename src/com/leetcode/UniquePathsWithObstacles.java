package com.leetcode;

public class UniquePathsWithObstacles {
    public static void main(String[] args) {

        int[][] mat = {{0,0,1},
                       {0,0,0}};
        Solution42 s = new Solution42();
        System.out.println(s.uniquePathsWithObstacles(mat));
    }
}

class Solution42 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];//dp[i][j]代表从（0,0）位置到达(m,n)位置的路径条数

        for(int i = 0;i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i==0&&j==0) {
                    dp[i][j] = obstacleGrid[i][j]==1?0:1;
                }
                else if(i==0) {
                    dp[i][j] = obstacleGrid[i][j]==1?0:dp[i][j-1];
                }
                else if(j==0) {
                    dp[i][j] = obstacleGrid[i][j]==1?0:dp[i-1][j];
                }
                else {
                    dp[i][j] = obstacleGrid[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
