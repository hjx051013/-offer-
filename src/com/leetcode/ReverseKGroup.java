package com.leetcode;

import java.util.Scanner;
/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例 :

给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

说明 :

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

解题思路：
    遍历每获得k个节点，将这k个节点组成的链表翻转，然后继续，知道遍历到尾节点
*/
public class ReverseKGroup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        ListNode head = MergeList.buildListFromStr(str1);
        Solution49 s = new Solution49();
        ListNode newList = s.reverseKGroup(head, 5);
        MergeList.printList(newList);
        in.close();
    }

}

class Solution49 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode first = head, last, curNext, cur = head, prevSegNode = newHead;
        int cnt = 1;
        while(cur != null) {
            if(cnt%k==0) {
                last = cur;
                curNext = cur.next;
                Pair<ListNode,ListNode> nodePair = reverseList(first,last);
                ListNode newFirst = nodePair.v1, newLast = nodePair.v2;
                prevSegNode.next = newFirst;
                prevSegNode = newLast;
                first = curNext;
                cur = curNext;
                cnt++;
            } else {
                cnt++;
                cur = cur.next;
            }
        }
        prevSegNode.next = first;
        return newHead.next;
    }

    private Pair<ListNode, ListNode> reverseList(ListNode first, ListNode last) {
        if(first==null&&last==null) return new Pair<>(null,null);
        ListNode temp = first, next, prev = null;
        while(temp!=last) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        temp.next = prev;
        return new Pair<ListNode,ListNode>(last,first);
    }
}