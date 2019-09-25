package com.leetcode;

public class KMP {
    private String pat;
    private int[][] dp;

    public KMP(String pat_) {
        int M = pat_.length();
        this.pat = pat_;
        dp = new int[M][256];
        dp[0][pat.charAt(0)] = 1;
        int X = 0;
        for(int j = 1; j < M; j++) {
            for(char k = 0; k < 256; k++) {
                if(pat.charAt(j)==k) {
                    dp[j][k] = j+1;
                } else {
                    dp[j][k] = dp[X][k];
                }
            }
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int j = 0;
        for(int i = 0; i < N; i++) {
            j = dp[j][txt.charAt(i)];
            if(j==M) return i-M+1;
        }
        return -1;
    }
}
