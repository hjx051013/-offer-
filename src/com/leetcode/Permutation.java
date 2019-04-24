package com.leetcode;


import java.util.List;

import java.util.ArrayList;


/*
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"

方法：
根据p = k/(n-1)!可以获得n个数（升序）第p个数（首数是第0个数），在1-n的集合中除去这个数
k = k%(n-1)!，n--
p = k/(n-1)!获得n个数（升序）第p个数（首数是第0个数）
依此类推
 */
public class Permutation {

    public static void main(String[] args) {
        Solution9 s = new Solution9();
        String str = s.getPermutation(9, 155915);
        System.out.println(str);
    }
}

class Solution9 {

//    private List<String> strList = new ArrayList<>();
//    public String getPermutation(int n,int k) {
//        List<Integer> intList = new ArrayList<>();
//        for(int i = 1; i <= n; i++) {
//            intList.add(i);
//        }
//        dfs(intList,"",k);
////        Collections.sort(strList);
//        return strList.get(k-1);
//    }
//
//    private void dfs(List<Integer> list,String prefix,int k) {
//
//        for(int i = 0; i < list.size(); i++) {
//            Integer e = list.remove(i);
//            if(list.isEmpty()) {
//                strList.add(prefix+e.toString());
//            } else {
//                dfs(list,prefix+e.toString(),k);
//            }
//            list.add(i,e);
//            if(strList.size()==k) break;
//        }
//    }
    private int getFac(int x) {
        int res  =1;
        if(x<0) return 0;
        else if(x==0) return 1;
        for(int i = 1; i<=x; i++) {
            res = res*i;
        }
        return res;
    }
    public String getPermutation(int n,int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> intList = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            intList.add(i);
        }
        int avail = k-1;
        do {
            int factorial = getFac(n-1);
            int res = avail/factorial;
            avail = avail%factorial;
            sb.append(intList.get(res).toString());
            intList.remove(res);
            n--;
        } while(!intList.isEmpty());

        return sb.toString();
    }

}
