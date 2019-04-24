package com.leetcode;

/*
单链表快速排序

输入：7->8->10->5->6->9
输出：5->6->7->8->9->10

方法：
分治法，将链表头作为分隔节点，将后续节点中比分隔节点小的放在分隔节点之前，比分隔节点大的放在分隔节点之后
这样分隔节点的位置就是正确的，然后分治分隔节点左边的链表和分隔节点右边的链表
 */
public class ListSort {

    public static void main(String[] args) {
        int[] arr = {7,8,10,5,6,9};
        Node list = new Node(arr[0]),p = list;
        for(int i = 1; i < arr.length; i++) {
            Node tmp = new Node(arr[i]);
            p.next = tmp;
            p = tmp;
        }
        Node l = sort(list);
        while(l!=null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public static Node sort(Node list) {
        if(list==null || list.next==null) return list;
        Node par = list;//以第一个节点为分割节点
        Node newFirst = partition(par);//返回分割后左边链表的头结点
        Node left = (newFirst==list)?null:newFirst;
        Node right = par.next;
        left = sort(left);
        right = sort(right);
        if(left==null) {
            par.next = right;
            return par;
        }
        else {
            Node leftLast = left;
            while(leftLast.next!=null) {
                leftLast = leftLast.next;
            }
            leftLast.next = par;
            par.next = right;
            return left;
        }
    }

    private static Node partition(Node first) {//返回新的起始节点
        Node par = first;
        Node p = first.next;
        Node prevP = first;
        while(p!=null) {
            if(p.val<par.val) {
                prevP.next = p.next;
                if(first!=par) p.next = first;
                else p.next = null;
                first = p;
                p = prevP.next;
            } else {
                prevP = p;
                p = p.next;
            }
        }
        return first;
    }


}

class Node {
    int val;
    Node next = null;
    public Node(int v) {
        val = v;
    }
}
