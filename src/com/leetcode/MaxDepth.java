package com.leetcode;

import java.util.Scanner;
/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3

思路：
    递归实现，不要太简单
 */
public class MaxDepth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        TreeNode root= SymmetricTree.buildTreeFromStr(line);
        Solution84 s = new Solution84();
        System.out.println(s.maxDepth(root));
    }
}

class Solution84 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        return Math.max(leftH, rightH)+1;
    }
}
