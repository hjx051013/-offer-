package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
思路：
先层序遍历将节点加入到list中，中间用null节点作为每一层的间隔，当从queue中取到null节点并且queue不空时就可以向queue中加入下一个节点
*/
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Solution90 s = new Solution90();
        TreeNode root = SymmetricTree.buildTreeFromStr(str);
        List<List<Integer>> res = s.zigzagLevelOrder(root);
        for(int i = 0; i < res.size(); i++) {
            List<Integer> singleRow = res.get(i);
            int rowSize = singleRow.size();
            for(int j = 0; j < rowSize; j++) {
                System.out.print(singleRow.get(j)+" ");
            }
            System.out.println();
        }
        in.close();
    }
}

class Solution90 {
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> singleRow = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode node = queue.pop();
            singleRow.add(node);
            if(node == null && !queue.isEmpty()) {
                queue.add(null);
            }
            if(node != null && node.left != null) {
                queue.add(node.left);
            }
            if(node != null && node.right != null) {
                queue.add(node.right);
            }
        }
        LinkedList<Integer> row = new LinkedList<>();
        int rowIndex = 0;
        for(int i = 0; i < singleRow.size(); i++) {
            TreeNode node = singleRow.get(i);
            if(node != null) {
                if(rowIndex%2 == 0) {
                    row.addLast(node.val);
                } else {
                    row.addFirst(node.val);
                }
            } else {
                rowIndex++;
                res.add(row);
                row = new LinkedList<>();
            }
        }
        return res;
    }
}