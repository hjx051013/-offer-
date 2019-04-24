package com.leetcode;

import java.util.Scanner;

/*
2. 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

方法：
两个单链表依次序合并，需处理好进位问题
 */
public class AddNum {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String list1 = in.nextLine();
        String list2 = in.nextLine();
        ListNode p1 = MergeList.buildListFromStr(list1);
        ListNode p2 = MergeList.buildListFromStr(list2);

        Solution8 s = new Solution8();
        ListNode result = s.addTwoNumbers(p1,p2);
        MergeList.printList(result);
    }
}

class Solution8 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        int carry = 0;
        ListNode p1 = l1,p2 = l2;
        ListNode result = null,cur = null;
        ListNode lastNode = null;
        while(p1!=null||p2!=null) {
            int val1 = 0, val2 = 0;
            if(p1!=null) {
                val1 = p1.val;
                p1 = p1.next;
            }
            if(p2!=null) {
                val2 = p2.val;
                p2 = p2.next;
            }
            int tmp = val1+val2+carry;
            if(tmp>9) {
                tmp = tmp%10;
                carry = 1;
            } else {
                carry = 0;
            }
            if(cur==null) {//头结点
                cur = new ListNode(tmp);
                result = cur;
                lastNode = cur;
            } else {
                cur.next = new ListNode(tmp);
                cur = cur.next;
                lastNode = cur;
            }
        }
        if(carry==1&&lastNode!=null) {
            lastNode.next = new ListNode(carry);
        }

        return result;
    }
}

