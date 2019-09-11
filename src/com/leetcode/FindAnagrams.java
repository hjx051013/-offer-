package com.leetcode;

import java.util.*;
/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

思路：
    选择固定大小的滑动窗口，将滑动窗口的字母的统计map及值同给定字符串的统计map进行比较(遍历是
    ，只需要修正前一个字符删去和最后一个字符加入造成的map变动，通过formed记录与给定字符串的统计map符合的字符个数)，
    如果完全一致，就加入返回数组。
注意点：
    Integer比较是否相等不能用==，用equals或者intValue比较

 */
public class FindAnagrams {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        Solution77 sol = new Solution77();
        System.out.println(sol.findAnagrams(s, p));

    }
}

class Solution77 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() < p.length()) return res;
        Map<Character,Integer> pmap = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            int count = pmap.getOrDefault(p.charAt(i), 0);
            pmap.put(p.charAt(i), count+1);
        }
        int required = pmap.keySet().size();
        int formed = 0;
        Map<Character,Integer> wDict = new HashMap<>();
        for(int j = 0; j < p.length(); j++) {
            char c = s.charAt(j);
            int cnt = wDict.getOrDefault(c, 0);
            wDict.put(c, cnt+1);
            if(pmap.containsKey(c) && wDict.get(c).intValue()==pmap.get(c).intValue()) {
                formed++;
            }
        }
        if(formed == required) res.add(0);
        for(int j = 1; j <= s.length()-p.length(); j++) {
            char preChar = s.charAt(j-1);
            int preCharCnt = wDict.get(preChar);
            wDict.put(preChar, preCharCnt-1);
            char lastChar = s.charAt(j+p.length()-1);
            if(pmap.containsKey(preChar) && preCharCnt == pmap.get(preChar).intValue()) formed--;
            int lastCharCnt = wDict.getOrDefault(lastChar, 0);
            wDict.put(lastChar, lastCharCnt+1);
            if(pmap.containsKey(lastChar) && lastCharCnt+1 == pmap.get(lastChar).intValue()) formed++;
            if(formed==required) res.add(j);
        }

        return res;
    }
}