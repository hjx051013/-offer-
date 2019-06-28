package com.leetcode;

import java.util.*;


/**
 30. 串联所有单词的子串
 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。



 示例 1：

 输入：
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 输出：[0,9]
 解释：
 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 输出的顺序不重要, [9,0] 也是有效答案。


 示例 2：

 输入：
 s = "wordgoodgoodgoodbestword",
 words = ["word","good","best","word"]
 输出：[]

 思路：
 直接遍历，对每个字符开始的以字符串数组总长度为length的子串与字符串数组进行Map的比较，如果Map一致，那么这个起始index就符合要求
*/

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
}
