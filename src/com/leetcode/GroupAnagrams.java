package com.leetcode;

import java.util.*;
/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

思路：
    对每个字符串进行排序，依此为key插入Map<String, List<String>>对象中
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution73 s = new Solution73();
        String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = s.groupAnagrams(strArr);
        for(List<String> strings: res) {
            for(String str: strings) {
                System.out.print(str+",");
            }
            System.out.println();
        }
    }
}

class Solution73 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(res.containsKey(sortedStr)) {
                List<String> strList = res.get(sortedStr);
                strList.add(strs[i]);
            } else {
                List<String> strList = new LinkedList<>();
                strList.add(strs[i]);
                res.put(sortedStr, strList);
            }
        }
        List<List<String>> ret = new ArrayList<>();
        for(List<String> strList : res.values()) {
            ret.add(strList);
        }

        return ret;
    }
}
