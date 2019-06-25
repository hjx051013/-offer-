package com.leetcode;

import java.util.*;

/*
870. 优势洗牌
给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。

返回 A 的任意排列，使其相对于 B 的优势最大化。



示例 1：

输入：A = [2,7,11,15], B = [1,10,4,11]
输出：[2,11,7,15]
示例 2：

输入：A = [12,24,8,32], B = [13,25,32,11]
输出：[24,32,8,12]


提示：

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9

方法：
    贪心，对A和B进行排序。
    对于sortedB[i],如果能够找到刚好大于sortedB[i]的sortedA数组中的值，就配对，否则就为配对的A值队列中找一个与之配对。


 */
public class AdvantageCount {
    public static void main(String[] args) {
//        int[] A = {2,7,11,15};
//        int[] B = {1,10,4,11};
        int[] A = {2,0,4,1,2};
        int[] B = {1,3,0,0,2};
        Solution22 s = new Solution22();
        int[] res = s.advantageCount(A,B);
        for(int x:res) {
            System.out.println(x);
        }
    }
}

class Solution22 {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        int[] sortedB = B.clone();

        Arrays.sort(sortedA);
        Arrays.sort(sortedB);

        Map<Integer,List<Integer>> assigned = new HashMap<>();//键为B元素的值，值为能与该值相对应的A值列表
        List<Integer> remaining = new ArrayList<>();
        for(int b:sortedB) {
            if(assigned.get(b)==null) {
                List<Integer> list = new LinkedList<>();
                assigned.put(b,list);
            }
        }

        int j = 0;
        for(int a:sortedA) {
            if(a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        for(int i = 0; i < B.length; i++) {
            if(assigned.get(B[i]).size()!=0) {
                A[i] = assigned.get(B[i]).remove(0);
            } else {
                A[i] = remaining.remove(0);
            }
        }

        return A;
    }
}
