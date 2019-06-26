package com.leetcode;

/*
72. 编辑距离
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
示例 1:

输入: word1 = "horse", word2 = "ros"
输出: 3
解释:
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2:

输入: word1 = "intention", word2 = "execution"
输出: 5
解释:
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

思路：
动态规划，dp[i][j]代表word1[0,i)和word2[0,j)的距离
有递推式如下
对于任意i, dp[i][0] = i;
对于任意j，dp[0][j] = j
if(word1[i-1]==word2[j-1]) dp[i][j] = dp[i-1][j-1]
else {
    dp[i][j] = min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1
}
 */
public class MinDistance {
    public static void main(String[] args) {
        Solution63 s = new Solution63();
        System.out.println(s.minDistance("horse", "ros"));
    }
}

class Solution63 {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        for(int i = 0; i < word1.length()+1; i++) dp[i][0] = i;
        for(int j = 0; j < word2.length()+1; j++) dp[0][j] = j;
        for(int i = 1; i < word1.length()+1; i++) {
            for(int j = 1; j < word2.length()+1; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    int minV = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(minV, dp[i-1][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
