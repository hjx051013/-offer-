package com.leetcode;

/*
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

思路：
    实现kmp算法，对于kmp算法，关键有两点
    1. 先计算出与pattern相关的dp[pat.length()][256],dp[i][c]表示了在第i步碰到了字符c应该怎样移动pattern串，
        本质上是一个有限状态机
    2.计算dp[pat.length()][256],dp[i][pat.charAt[i]] = i+1,dp[i][c] = dp[X][c](c!=pat.charAt[i]),
        X代表pat相对于pat.substr(0,i)的最长前缀子串
        "mississippi"
"issip"
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        Solution87 s = new Solution87();
        System.out.println(s.strStr(haystack, needle));
    }
}

class Solution87 {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }
}