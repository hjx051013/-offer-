package com.leetcode;

import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;

import static com.leetcode.MergeList.buildListFromStr;
import static com.leetcode.MergeList.printList;

/*
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
方法一：
一种是将每个节点的地址存起来，然后将倒数第n+1个节点指向倒数第n-1个节点，
方法二：
另一种思路是快慢指针，就是让快指针先走n步，然后快指针和慢指针同步前进，直到快指针指向null,
同时记录慢指针的前驱。然后将此前驱节点指向慢指针的下一个节点
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = in.nextInt();
        ListNode head = buildListFromStr(line);
        Solution17 s = new Solution17();
        printList(s.removeNthFromEnd(head,n));
    }
}

class Solution17 {
//    方法一：
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        List<ListNode> listNodeList = new ArrayList<>();
//        ListNode ptr = head;
//        while(ptr!=null) {
//            listNodeList.add(ptr);
//            ptr = ptr.next;
//        }
//        ListNode target  = listNodeList.get(listNodeList.size()-n);
//        ListNode targetPrev = listNodeList.size()-n-1>=0?listNodeList.get(listNodeList.size()-n-1):null;
//        if(targetPrev==null) {//删除的是头结点
//            head = target.next;
//            target.next = null;
//        } else {
//            targetPrev.next = target.next;
//            target = null;
//        }
//        return head;
//    }


    public ListNode removeNthFromEnd(ListNode head,int n) {
        ListNode fast = head,slow = head,pre = null;
        while(n>0&&fast!=null) {
            fast = fast.next;
            n--;
        }
        if(fast==null) {
            if(n==0) return head.next;//删除倒数第n个节点，即头结点
            return head;//n超范围
        }
        while(fast!=null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        slow = null;
        return head;
    }
}
