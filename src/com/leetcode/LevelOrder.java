package com.leetcode;

import java.util.LinkedList;
import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;

import static com.leetcode.SymmetricTree.buildTreeFromStr;

/*
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class LevelOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        TreeNode root = buildTreeFromStr(line);
        Solution34 s = new Solution34();
        List<List<Integer>>  result = s.levelOrder(root);
        for(List<Integer> level:result) {
            for(Integer i:level) System.out.print(i+" ");
            System.out.println();
        }
        in.close();
    }
}

class Solution34 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> intList = new ArrayList<>();
        if(root==null) {
            return resList;
        }
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {//每一层最后一个节点
                resList.add(intList);
                intList = new ArrayList<>();
                if(!queue.isEmpty()) queue.add(null);//当前层结束，意味着其下一层子节点都已经入队了
            } else {
                intList.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return resList;
    }
}
