package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

        '?' 可以匹配任何单个字符。
        '*' 可以匹配任意字符串（包括空字符串）。
        两个字符串完全匹配才算匹配成功。

        说明:

        s 可能为空，且只包含从 a-z 的小写字母。
        p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
        示例 1:

        输入:
        s = "aa"
        p = "a"
        输出: false
        解释: "a" 无法匹配 "aa" 整个字符串。
        示例 2:

        输入:
        s = "aa"
        p = "*"
        输出: true
        解释: '*' 可以匹配任意字符串。
        示例 3:

        输入:
        s = "cb"
        p = "?a"
        输出: false
        解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
        示例 4:

        输入:
        s = "adceb"
        p = "*a*b"
        输出: true
        解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
        示例 5:

        输入:
        s = "acdcb"
        p = "a*c?b"
        输入: false

方法一：有限状态自动机，超时
方法二：动态规划，boolean类型 match[m][n]代表s的前m个字符子串是否与p的前n个字符子串想匹配
*/

public class WildCardMatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        Solution39 sol = new Solution39();
        System.out.println(sol.isMatch(s,p));
        in.close();
    }
}

class Solution39 {
//    public boolean isMatch(String s, String p) {
//        VariantNode ptrS = buildListFromStr(s);
//        p = removeRepeatSharp(p);
//        VariantNode ptrP = buildListFromStr(p);
//        return dfs(ptrS,ptrP);
//    }
//
//    private String removeRepeatSharp(String s) {
//        return s.replaceAll("(\\*)+","*");
//    }
//
//    private boolean dfs(VariantNode ptrS,VariantNode ptrP) {
//        if(ptrS.val==ptrP.val || ptrP.val=='?' || ptrP.val=='*') {
//            if(ptrS.next.size()!=0&&ptrP.next.size()!=0) {
//                if(ptrP.next.size()==1) return dfs(ptrS.next.get(0),ptrP.next.get(0));
//                else return dfs(ptrS.next.get(0),ptrP.next.get(0)) || dfs(ptrS.next.get(0),ptrP.next.get(1));
//            } else if(ptrS.next.size()==0&&ptrP.next.size()==0) {
//                return true;
//            } else if(ptrS.next.size()==0&&ptrP.next.size()==1&&ptrP.next.get(0).val=='*') {//s到末尾，p以*为结尾
//                return true;
//            }
//            else return false;
//        } else {
//            return false;
//        }
//    }
//
//    private VariantNode buildListFromStr(String str) {
//        VariantNode first = new VariantNode('h');
//        VariantNode prev = first;
//        VariantNode prePrev = null;
//        for(int i = 0; i < str.length(); i++) {
//            VariantNode cur = new VariantNode(str.charAt(i));
//            prev.next.add(cur);
//            if(prev.val=='*'&&prePrev!=null) prePrev.next.add(cur);
//            if(str.charAt(i)=='*') {
//                cur.next.add(cur);
//                prePrev = prev;
//            }
//            prev = cur;
//        }
//        return first;
//    }


    private boolean isAllSharp(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='*') return false;
        }
        return true;
    }

    public boolean isMatch(String s,String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];//match[m][n]代表s的前m个字符子串是否与p的前n个字符子串想匹配
        match[0][0] = true;
        for(int i = 1; i <= s.length(); i++) {
            match[i][0] = false;
        }
        for(int j = 1; j <= p.length(); j++) {
            if(isAllSharp(p.substring(0,j))) match[0][j] = true;
            else match[0][j] = false;

        }


        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                if(p.charAt(j-1)=='*') {
                    match[i][j] = match[i-1][j-1] || match[i-1][j] || match[i][j-1];
                } else {
                    if(p.charAt(j-1)=='?'||s.charAt(i-1)==p.charAt(j-1)) match[i][j] = match[i-1][j-1];
                    else if(p.charAt(j-1)!='?'&&s.charAt(i-1)!=p.charAt(j-1)) match[i][j] = false;
                }
            }
        }

        return match[s.length()][p.length()];
    }
}

//class VariantNode {
//    char val;
//    List<VariantNode> next;
//    public VariantNode(char value) {
//        this.val = value;
//        this.next = new ArrayList<>();
//    }
//}