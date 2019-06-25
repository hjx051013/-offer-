package com.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
/*
32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

方法：
先用List记录每一对相互匹配的右括号的位置
然后从左往右开始扫描，扫到最长的互相匹配的括号，如果当前括号对能和之前的括号对连起来，就连起来
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution21 s = new Solution21();
        int res = s.longestValidParentheses("(()()(())((");
        System.out.println(res);
    }
}

class Solution21 {
    public int longestValidParentheses(String s) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] rParPos = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') stack.push(i);
            else if(s.charAt(i)==')'){
                if(!stack.isEmpty()) {
                    int ele = stack.pop();
                    rParPos[ele] = i;
                }
            }
        }
        int lastRParPos = -1;//记录上一次匹配成功右括号位置
        int lastLen = 0;//记录上一次匹配成功的长度
        int p = 0;
        int maxLen = 0;
        while(p < s.length()) {
            if(rParPos[p]!=0) {
                int curLen = rParPos[p]+1-p;
                if(lastRParPos!=-1&&p-1==lastRParPos) {
                    curLen += lastLen;
                }
                if(curLen>maxLen) {
                    maxLen = curLen;
                }
                lastRParPos = rParPos[p];
                lastLen = curLen;
                p = rParPos[p]+1;//下一个开始扫描位置
            } else {
                p++;
            }
        }
        return maxLen;
    }
}