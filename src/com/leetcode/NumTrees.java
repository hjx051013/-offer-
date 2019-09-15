package com.leetcode;

/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
   G[i]代表1-n的二叉树种类个数
   G(n)=
        n
        ∑ F(i,n)
        i=1
   F(i,n)代表1-n序列中以i为根的种类数
   F(i,n) = G(i-1)*G(n-i)
 */
public class NumTrees {
    public static void main(String[] args) {
        Solution83 s = new Solution83();
        System.out.println(s.numTrees(3));
    }
}

class Solution83 {
    public int numTrees(int n) {
        if(n==0 || n==1) return 1;
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
}