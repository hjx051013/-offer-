package com.offer.LinkedList;

import com.leetcode.ListNode;
import com.leetcode.MergeList;
import java.util.Scanner;

/*
面试题13：在O（1）时间删除链表结点
题目：
    给定单向链表的头指针和一个结点指针，定义一个函数在O（1）时间删除该结点。

思路：
    将删去结点的下一个结点的值复制到其值上，然后删去下一个结点
    如果删去的是尾结点，那么就需要从头到尾遍历一遍。
    待删除的链表只有一个结点，那么就要返回null
 */
public class DeleteListNode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        ListNode p = MergeList.buildListFromStr(line);
        int delVal = in.nextInt();
        ListNode delNode = MergeList.getTargetNode(p, delVal);
        Solution13 s = new Solution13();
        MergeList.printList(s.deleteListNodeO1(p, delNode));
        in.close();
    }
}

class Solution13 {
    public ListNode deleteListNodeO1(ListNode list, ListNode toBeDelNode) {
        if(list == null || toBeDelNode == null) {
            return list;
        }
        if(toBeDelNode.next == null) {//如果待删除结点为链表的尾结点，则必须顺序查找到尾结点
            if (list == toBeDelNode) {
                return null;//只有一个结点
            }
            ListNode p = list;
            while (p.next != null && p.next != toBeDelNode) p = p.next;
            if (p.next == toBeDelNode) {
                p.next = p.next.next;
            }
        } else {//否则就将下一个结点的值移到当前结点，然后删去下一个结点
            ListNode next = toBeDelNode.next;
            toBeDelNode.val = next.val;
            toBeDelNode.next = next.next;
        }
        return list;
    }
}