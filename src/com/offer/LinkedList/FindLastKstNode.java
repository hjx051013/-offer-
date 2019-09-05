package com.offer.LinkedList;

import com.leetcode.ListNode;
import com.leetcode.MergeList;
import java.util.HashMap;
import java.util.Scanner;

/*
面试题15：链表中倒数第k个结点
题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是值为4的结点。

思路：
    设置两个指针p1,p2都指向头结点，p2先走k-1步，
    然后p1,p2同步前进，当p2到达尾结点时p1就会到达倒数第k个节点
 */
public class FindLastKstNode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        ListNode list = MergeList.buildListFromStr(line);
        Soluition15 s = new Soluition15();
        ListNode target = s.findLastKstNode(list, 3);
        System.out.println(target!=null?target.val:"null");
    }
}

class Soluition15 {
    public ListNode findLastKstNode(ListNode head,int k) {
        if(head==null || k <= 0) return null;
        if(head.next == null && k == 1) return head;
        ListNode p1 = head;
        ListNode p2 = head;
        int cnt = 0;
        while(p2.next!=null && cnt < k-1) {
            cnt++;
            p2 = p2.next;
        }
        if(cnt < k-1) {
            return null;
        }
        while(p2.next!=null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
