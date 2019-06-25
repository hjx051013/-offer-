package com.leetcode;

import java.util.*;

public class LetterCombinations {
    public static void main(String[] args) {
        Solution45 s = new Solution45();
        List<String> res = s.letterCombinations("23");
        for(String str: res) {
            System.out.println(str);
        }
    }
}


class Solution45 {
    //递归
    /*
    private List<String> strList = new ArrayList<>();
    private String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        dfs("", digits);
        return strList;
    }

    private void dfs(String prefix, String availDigits) {
        if(availDigits==null||availDigits.length()==0) return;
        String curStr = map[availDigits.charAt(0)-'0'];
        if(availDigits.length()==1) {
            for(int i = 0; i < curStr.length(); i++) {
                strList.add(prefix + curStr.charAt(i));
            }
        } else {
            for(int i = 0; i < curStr.length(); i++) {
                dfs(prefix + curStr.charAt(i), availDigits.substring(1));
            }
        }
    }
    */
    //非递归
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits==null || digits.length()==0) {
            return res;
        }
        res.add("");
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i = 0; i < digits.length(); i++) {
            String curStr = map[digits.charAt(i)-'0'];
            int curLen = res.size();
            for(int k = 0; k < curLen; k++) {
                String prefix = res.removeFirst();
                for(int j = 0; j < curStr.length(); j++) {
                     res.addLast(prefix+curStr.charAt(j));
                }
            }
        }

        return res;
    }
}