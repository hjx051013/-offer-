package com.leetcode;

import java.util.Scanner;

/*
142. 环形链表II

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。



示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。


进阶：
你是否可以不用额外空间解决此题？

方法：
    双指针，一个指针每次走一步，另一个指针每次走两步，
    当相重时充分利用快指针走过的距离是慢指针所走距离的两倍，
    也就是说重合位置到交叉位置的距离与起始位置到交叉位置的距离是相等的
 */

public class DetectCycle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        ListNode list = MergeList.buildListFromStr(line);
        int pos = in.nextInt();
        if(pos>=0) {
            ListNode tail = DetectCycle.getTail(list);
            ListNode posNode = DetectCycle.getTargetNode(list,pos);
            tail.next = posNode;
        }
        Solution26 s = new Solution26();
        ListNode cross = s.detectCycle(list);
        System.out.println(cross.val);
        in.close();
    }

    public static ListNode getTail(ListNode p) {
        while(p!=null&&p.next!=null) {
            p = p.next;
        }
        return p!=null?p:null;
    }

    public static ListNode getTargetNode(ListNode p,int pos) {
        int index = 0;
        while(p!=null&&index!=pos) {
            p = p.next;
            index++;
        }
        return p!=null?p:null;
    }

}

class Solution26 {
    public ListNode detectCycle(ListNode head) {
        //p1,p2从起点出发，p1走一步，p2走两步
        if(head==null||head.next==null) return null;
        ListNode p1 = head, p2 = head;
        do {
            p1 = p1.next;
            if(p2.next!=null) p2 = p2.next.next;
            else p2 = null;
        } while(p1!=null&&p2!=null&&p1!=p2);
        if(p1==p2&&p1!=null&&p2!=null) {
            //有环
            ListNode p = head;
            while(p!=p1) {
                p = p.next;
                p1 = p1.next;
            }
            return p;
        }
        return null;
    }
}
