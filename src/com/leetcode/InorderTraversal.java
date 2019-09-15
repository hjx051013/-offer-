package com.leetcode;

import java.util.*;
/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

思路：
    1. 递归算法。
    2. 迭代算法，用栈缓存根节点
 */
public class InorderTraversal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        TreeNode treeRoot = SymmetricTree.buildTreeFromStr(line);
        Solution82 s = new Solution82();
        List<Integer> res = s.inorderTraversal(treeRoot);
        for(Integer e:res) {
            System.out.print(e+",");
        }
    }
}

class Solution82 {
    /*递归*/
//    private List<Integer> list = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        recursiveTraverse(root);
//        return list;
//    }
//
//    private void recursiveTraverse(TreeNode root) {
//        if(root == null) return;
//        inorderTraversal(root.left);
//        list.add(root.val);
//        inorderTraversal(root.right);
//    }

    /*迭代*/
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(true) {
            while(p!=null) {
                stack.add(p);
                p = p.left;
            }
            if(stack.isEmpty()) break;
            p = stack.pop();
            list.add(p.val);
            p = p.right;
        }

        return list;
    }

}
