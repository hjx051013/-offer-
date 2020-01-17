package com.leetcode;

import java.util.Scanner;
/*
21. 合并两个有序链表
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

方法：
取两个链表当中的小值构成结果链表的新节点，被取值的链表指针指向下一个节点
 */
public class MergeList {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String list1 = in.nextLine();
        String list2 = in.nextLine();
        ListNode p1 = buildListFromStr(list1);
        ListNode p2 = buildListFromStr(list2);

        Solution7 s = new Solution7();
        ListNode last = s.mergeTwoLists(p1,p2);
        printList(last);
        in.close();
    }

    public static ListNode buildListFromStr(String list) {
        if(list.equals("null")) return null;
        String[] listStr = list.split("->");
        ListNode p1 = null;
        ListNode first = null;
        for(int i = 0; i < listStr.length; i++) {
            int val = Integer.parseInt(listStr[i]);
            ListNode node = new ListNode(val);
            if(p1==null) {
                p1 = node;
                first = node;
            }
            else {
                p1.next = node;
                p1 = node;
            }
        }
        if(p1!=null) p1.next = null;
        return first;
    }
    public static void printList(ListNode p) {
        if(p==null) System.out.print("null");
        else {
            while(p!=null) {
                System.out.print(p.val);
                if(p.next!=null) {
                    System.out.print("->");
                }
                p = p.next;
            }
        }
    }

    public static ListNode getTargetNode(ListNode p, int targetVal) {
        while(p!=null) {
            if(p.val == targetVal) return p;
            p = p.next;
        }
        return null;
    }
}

class Solution7 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode p1=l1,p2=l2;
        ListNode prevP = null;
        ListNode merge = p1.val<=p2.val?p1:p2;
        while(p1!=null&&p2!=null) {
            if(p1.val>p2.val) {
                while(p2!=null&&p2.val<=p1.val) {
                    prevP = p2;
                    p2 = p2.next;
                }
                prevP.next = p1;
            } else {
                while(p1!=null&&p1.val<=p2.val) {
                    prevP = p1;
                    p1 = p1.next;
                }
                prevP.next = p2;
            }
        }
        return merge;
    }
}
