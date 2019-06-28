package com.leetcode;

import java.util.*;

public class FindSubString {
    public static void main(String[] args) {
        Solution64 s = new Solution64();
        String[] words = {"aa","aa","aa"};
        String str = "aaaaaaaa";
        List<Integer> res = s.findSubstring(str, words);
        for(Integer e:res) {
            System.out.print(e+" ");
        }
    }

}

class Solution64 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s.length()==0 || words.length==0) return res;
        Map<String, Integer> map = new HashMap<>();
        int totLen  = words.length*words[0].length();
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) map.put(words[i], map.get(words[i])+1);
            else map.put(words[i], 1);
        }

        for(int i = 0; i <= s.length()-totLen; i++) {
            if(isValid(s.substring(i), map, words[0].length(), words.length)) res.add(i);
        }

        return res;
    }

    private boolean isSame(Map<String,Integer> strMap, Map<String,Integer> wordMap) {
        if(strMap.keySet().size()!=wordMap.keySet().size()) return false;
        for(String key:wordMap.keySet()) {
            if(!wordMap.containsKey(key)) return false;
            if(wordMap.get(key)!=strMap.get(key)) return false;
        }

        return true;
    }
    private boolean isValid(String str, Map<String,Integer> wordMap, int wordLen, int wordNum) {
        Map<String,Integer> strMap = new HashMap<>();

        for(int i = 0; i < wordNum; i++) {
            String newWord = str.substring(i*wordLen,(i+1)*wordLen);
            if(strMap.containsKey(newWord)) {
                strMap.put(newWord,strMap.get(newWord)+1);
            } else {
                strMap.put(newWord,1);
            }
        }

        return isSame(strMap,wordMap);
    }
