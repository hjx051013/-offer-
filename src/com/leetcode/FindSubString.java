package com.leetcode;
import java.util.*;
/*
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

 

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
以单词为基元，设定一个起始为0个元素的滑动窗口，滑动窗口向右扩张，
当遇到给定words数组中没有的单词时，就将滑动窗口的左边界收缩到该单词的下一个单词位置
当遇到的单词使得当前窗口中的该单词数量大于给定words数组中的数量时，就将滑动窗口左边界收缩到该单词第一次出现位置的下一个单词位置
如果当前窗口中的单词数量达到words数组的数量，就记录下该窗口的起始位置
* */
public class FindSubString {
    public static void main(String[] args) {
        Solution64 s = new Solution64();
        String[] words = {"fooo","barr","wing","ding","wing"};
        String str = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        List<Integer> res = s.findSubstring(str, words);
        for(Integer e:res) {
            System.out.print(e+" ");
        }
    }

}
class Solution64 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0)
            return new ArrayList<>();
        int wordLen = words[0].length();
        int len = words.length;
        int totalLen = wordLen * len;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        //把数组处理为Map提高检索速度
        for (String word : words) {
            if (map.containsKey(word)) {
                Integer value = map.get(word);
                value++;
                map.put(word, value);
            } else {
                map.put(word, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < wordLen; i++) {
            int index = i;
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String word = s.substring(j, j + wordLen);
                if (!map.containsKey(word)) {
                    //遇到不匹配的单词，清空map2,重新开始匹配
                    map2.clear();
                    index = j + wordLen;
                } else {
                    Integer value2 = map2.get(word);
                    if (value2 == null) {
                        map2.put(word, 1);
                    } else if (value2.equals(map.get(word))) {
                        //遇到重复次数过多的单词，index右移到第一次重复的位置，map2删除右移的单词
                        String temp;
                        while (!(temp = s.substring(index, index + wordLen)).equals(word)) {
                            map2.put(temp, map2.get(temp) - 1);
                            index += wordLen;
                        }
                        //删除第一个重复的单词，当前单词次数不变
                        index += wordLen;
                    } else {
                        map2.put(word, value2 + 1);
                    }
                    //判断子串长度是否匹配，匹配则说明遇到了一个匹配的下标
                    //下标右移一个单词的位置，map2去掉第一个单词
                    if (j + wordLen - index == totalLen) {
                        res.add(index);
                        String firstWord = s.substring(index, index + wordLen);
                        map2.put(firstWord, map2.get(firstWord) - 1);
                        index += wordLen;
                    }
                }
            }
            map2.clear();
        }
        return res;
    }
}
