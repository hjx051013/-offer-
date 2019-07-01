package com.leetcode;
<<<<<<< HEAD
=======

>>>>>>> dc29d8906e4e9d00cd6e7eea9eb92f49ddfeea08
import java.util.*;
/*
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

<<<<<<< HEAD
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
=======

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
>>>>>>> dc29d8906e4e9d00cd6e7eea9eb92f49ddfeea08
        List<Integer> res = s.findSubstring(str, words);
        for(Integer e:res) {
            System.out.print(e+" ");
        }
    }

}

class Solution64 {
    public List<Integer> findSubstring(String s, String[] words) {
<<<<<<< HEAD
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
=======
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
>>>>>>> dc29d8906e4e9d00cd6e7eea9eb92f49ddfeea08
        }
        return res;
    }
<<<<<<< HEAD
=======

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
>>>>>>> dc29d8906e4e9d00cd6e7eea9eb92f49ddfeea08
}
