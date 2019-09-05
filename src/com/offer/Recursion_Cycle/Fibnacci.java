package com.offer.Recursion_Cycle;
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
思路：
    斐波那契数列， 迭代规律， f(n) = f(n-1)+f(n-2)  , n>=2
 */
public class Fibnacci {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAnsNum(10));
    }
}


class Solution {
    public int findAnsNum(int n) {
        if (n == 0 || n == 1) return 1;
        int[] ansNum = new int[n+1];
        ansNum[0] = 0;
        ansNum[1] = 1;
        for(int i = 2; i <= n; i++) {
            ansNum[i] = ansNum[i-2] + ansNum[i-1];
        }

        return ansNum[n];
    }
}