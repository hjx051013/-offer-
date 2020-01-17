package com.leetcode;

import java.util.Scanner;

/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

方法一：
    动态规划法，dp[i][j]代表字符串子串s.subString(i,j+1)是不是回文字符串,状态转移方程为
        dp[i][j] = dp[i+1][j-1],  s[i]==s[j]
        dp[i][j] = 0           ,  s[i]!=s[j]
方法二:
    中心扩展法，即遍历每一位置的字符，以该字符或者该字符为起始的数个相同字符为中心，向两边扩张，在遍历过程中记录最大长度及其起始点
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Solution40 s = new Solution40();
        System.out.println(s.longestPalindrome(str));
        in.close();
    }
}

class Solution40 {
    //方法一
//    public String longestPalindrome(String s) {
//        if(s.length()==0) return "";
//        boolean[][] dp = new boolean[s.length()][s.length()];//dp[i][j]代表字符串子串s.subString(i,j+1)是不是回文字符串
//        int longest = 1;
//        int start = 0;
//        for(int i = 0; i < s.length(); i++) {
//            dp[i][i] = true;
//            if(i<s.length()-1) {
//                if(s.charAt(i)==s.charAt(i+1)) {
//                    dp[i][i+1] = true;
//                    longest = 2;
//                    start = i;
//                } else {
//                    dp[i][i+1] = false;
//                }
//
//            }
//        }
//
//        for(int L = 3; L <= s.length(); L++) {//L为测试的字符串的长度
//            for(int i = 0; i+L-1 < s.length(); i++) {//i为测试字符串的起始位置
//                int  j = i+L-1;
//                if(s.charAt(i)==s.charAt(j)) {
//                    dp[i][j] = dp[i+1][j-1];
//                    if(dp[i][j]&&L>longest) {
//                        longest = L;
//                        start = i;
//                    }
//                }
//                else dp[i][j] = false;
//            }
//        }
//        return s.substring(start,start+longest);
//    }

    //方法二
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        int pos[] = new int[2];//pos[0]为起始位置,pos[1]为终点位置
        char[] c = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            next(i,c,pos);
        }

        return s.substring(pos[0],pos[1]+1);
    }

    private void next(int center,char[] c,int[] pos) {
        int left = center;
        int right = center;
        while(right+1<c.length&&c[left]==c[right+1]) {
            right++;
        }

        while(left-1>=0&&right+1<c.length&&c[left-1]==c[right+1]) {
            left--;
            right++;
        }

        int curLen = right-left;
        if(curLen>pos[1]-pos[0]) {
            pos[0] = left;
            pos[1] = right;
        }
    }
}
