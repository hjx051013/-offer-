package com.leetcode;

import java.util.Scanner;

/*
编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表：
A:    a1->a2->
              c1->c2->c3
B:b1->b2->b3->


在节点 c1 开始相交。

示例 1：
A:    4->1
          ->8->4->5
B：5->0->1


输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。


示例 2：
A:  0->9->1
           ->2->4
B:        3


输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。


示例 3：
A: 2->6->4
B:    1->5


输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。


注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

方法：
    获得两个链表的长度差diff，然后chang'li'a'b'b

 */
public class GetInsertionNode {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1  =in.nextLine();
        String line2 = in.nextLine();
        int pos = in.nextInt();
        ListNode headA = MergeList.buildListFromStr(line1);
        ListNode headB = MergeList.buildListFromStr(line2);
        ListNode tailB = DetectCycle.getTail(headB);
        ListNode posA = DetectCycle.getTargetNode(headA,pos);
        if(tailB!=null) tailB.next = posA;
        Solution27 s = new Solution27();
        System.out.println(s.getIntersectionNode(headA,headB).val);

    }
}

class Solution27 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int len1 = 0, len2 = 0;
        while(p1!=null) {
            p1 = p1.next;
            len1++;
        }
        while(p2!=null) {
            p2 = p2.next;
            len2++;
        }
        ListNode longList = len2>len1?headB:headA;
        ListNode shortList = len2>len1?headA:headB;
        int diff = Math.abs(len2-len1);
        ListNode pL = longList, pS = shortList;
        while(pL!=null&&diff!=0) {
            pL = pL.next;
            diff--;
        }
        while(pL!=pS&&pL!=null&&pS!=null) {
            pL = pL.next;
            pS = pS.next;
        }
        if(pL==pS&&pL!=null&&pS!=null) {
            return  pL;
        }
        else return null;
    }
}

