package com.leetcode;

import java.util.*;
/*
给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。

思路1：
    滑动窗口法。设定l,r左右指针。当s[1,r]不全含有t中字母时，r++，若全部含有，则不断l++直到不满足要求，重复此判断直到r>=s.length()

思路2：
    优化滑动窗口法。
 */
public class MinWindow {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        Solution76 s = new Solution76();
        System.out.println(s.minWindow(S, T));
    }
}

class Solution76 {
    //思路1
    /*
    public String minWindow(String s, String t) {
        if(s==null || s.length() == 0) return "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), count+1);
        }
        int required = map.keySet().size();
        int formed = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int resL=0, resR=0;
        Map<Character,Integer> dictT = new HashMap<>();
        int l = 0, r = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            int count = dictT.getOrDefault(c, 0);
            dictT.put(c, count+1);
            if(map.containsKey(c) && dictT.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }
            while(l<=r && formed==required) {
                char cur = s.charAt(l);
                if(r-l+1 < minWindowSize) {
                    resL = l;
                    resR = r;
                    minWindowSize = r-l+1;
                }
                int cnt = dictT.get(cur);
                dictT.put(cur, cnt-1);
                if(map.containsKey(cur) && dictT.get(cur) < map.get(cur)) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        if(minWindowSize!=Integer.MAX_VALUE) return s.substring(resL, resR+1);
        else return "";
    }
    */
    //思路2
    public String minWindow(String s, String t) {
        if(s==null || s.length() == 0) return "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), count+1);
        }
        int required = map.keySet().size();
        int formed = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int resL=0, resR=0;
        List<Pair<Integer, Character>> filteredS = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) filteredS.add(new Pair<Integer,Character>(i, s.charAt(i)));
        }
        Map<Character,Integer> dictT = new HashMap<>();
        int l = 0, r = 0;
        while(r < filteredS.size()) {
            int cIndex = filteredS.get(r).v1;
            char c = s.charAt(cIndex);
            int count = dictT.getOrDefault(c, 0);
            dictT.put(c, count+1);
            if(dictT.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }
            while(l<=r && formed==required) {
                int curL = filteredS.get(l).v1, curR = filteredS.get(r).v1;
                char cur = s.charAt(curL);
                if(curR-curL+1 < minWindowSize) {
                    resL = curL;
                    resR = curR;
                    minWindowSize = curR-curL+1;
                }
                int cnt = dictT.get(cur);
                dictT.put(cur, cnt-1);
                if(map.containsKey(cur) && dictT.get(cur) < map.get(cur)) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        if(minWindowSize!=Integer.MAX_VALUE) return s.substring(resL, resR+1);
        else return "";
    }
}