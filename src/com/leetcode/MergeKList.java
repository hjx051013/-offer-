package com.leetcode;

import java.util.PriorityQueue;
import java.util.*;

import static com.leetcode.MergeList.buildListFromStr;
import static com.leetcode.MergeList.printList;

/*
23. 合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

方法一：
参考两个单链表有序合并，将k个链表合并分而治之
方法二：
通过优先队列，进行k路合并，思想类似于外部排序。
 */
public class MergeKList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        ListNode[] lists = new ListNode[num];
        for(int i = 0; i < num; i++) {
            String line = in.nextLine();
            ListNode listHead = buildListFromStr(line);
            lists[i] = listHead;
        }
        Solution18 s = new Solution18();
        ListNode head = s.mergeKLists(lists);
        printList(head);
    }
}

class Solution18 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);//头哨兵节点
        ListNode resP = result;
        ListNode[] cur = new ListNode[lists.length];
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if(o1.v2<o2.v2) return -1;
                else if(o1.v2==o2.v2) return 0;
                else return 1;
            }
        });

        for(int i = 0; i < lists.length; i++) {
            cur[i] = lists[i];
            Pair<Integer,Integer> pair = new Pair(i,cur[i].val);
            pq.add(pair);
        }

        while(!pq.isEmpty()) {
            Pair<Integer,Integer> p = pq.remove();
            ListNode node = new ListNode(p.v2);
            resP.next = node;
            resP = resP.next;
            cur[p.v1] = cur[p.v1].next;
            if(cur[p.v1]!=null) pq.add(new Pair<Integer, Integer>(p.v1,cur[p.v1].val));
        }
        return result.next;
    }
}
class Pair<T1,T2> {
    T1 v1;
    T2 v2;
    public Pair(T1 value1,T2 value2) {
        v1 = value1;
        v2 = value2;
    }
}

