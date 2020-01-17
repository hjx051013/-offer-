package com.leetcode;

import java.util.Scanner;


import static com.leetcode.SymmetricTree.buildTreeFromStr;

/*
124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42

方法：
    递归遍历某节点的左右子树，找到子树根节点为起点的最大path和，
    然后左右子树最大path和与根节点相并，再与全局最大path和比较
 */
public class MaxPathSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        TreeNode root = buildTreeFromStr(line);
        Solution36 s = new Solution36();
        System.out.println(s.maxPathSum(root));
        in.close();
    }


}

class Solution36 {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    public int traverse(TreeNode root) {//返回根节点为起点的最大路径和
        if(root==null) return 0;
        int leftMaxPath = traverse(root.left);
        int rightMaxPath = traverse(root.right);
        int curMaxPathSum = root.val;
        if(leftMaxPath>0) curMaxPathSum+=leftMaxPath;
        if(rightMaxPath>0) curMaxPathSum+=rightMaxPath;
        if(curMaxPathSum>maxSum) maxSum = curMaxPathSum;
        return threeMax(root.val,root.val+leftMaxPath,root.val+rightMaxPath);
    }

    private int threeMax(int x,int y,int z) {//求三个数之中的最大值
        return x>y?(x>z?x:z):(y>z?y:z);
    }
}
