package com.leetcode;
/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

思路：
    斐波那契数列，从0开始迭代即可
 */
public class ClimbStairs {
    public static void main(String[] args) {
        Solution74 s = new Solution74();
        System.out.println(s.climbStairs(4));
    }
}

class Solution74 {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] climbNStairs = new int[n+1];
        climbNStairs[0] = 1;
        climbNStairs[1] = 1;
        for(int i = 2; i < n+1; i++) {
            climbNStairs[i] = climbNStairs[i-1] + climbNStairs[i-2];
        }
        return climbNStairs[n];
    }
}
