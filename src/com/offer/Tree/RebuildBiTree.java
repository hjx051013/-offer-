package com.offer.Tree;

/*
面试题6：重建二叉树
题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
则重建出下所示的二叉树并输出它的头结点。二叉树结点的定义如下：

        1
      /   \
     2     3
    /     /  \
   4     5    6
    \        /
     7      8

思路：
    递归，在inOrder序列中找到preOrder首元素位置，据此拆分左子树元素集和右子树元素集，递归建树
 */
public class RebuildBiTree {
    public static void main(String[] args) {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};
        Solution6 s = new Solution6();
        BinaryTreeNode tree = s.rebuildTree(preOrder, inOrder);
        printPreOrder(tree);
        System.out.println();
        printInOrder(tree);
    }
    public static void printPreOrder(BinaryTreeNode root) {
        if(root==null) return;
        System.out.print(root.val);
        printPreOrder(root.m_pLeft);
        printPreOrder(root.m_pRight);
    }

    public static void printInOrder(BinaryTreeNode root) {
        if(root == null) return;
        printInOrder(root.m_pLeft);
        System.out.print(root.val);
        printInOrder(root.m_pRight);
    }
}

class Solution6 {
    public BinaryTreeNode rebuildTree(int[] preOrder, int[] inOrder) {
        if(preOrder.length==0) return null;
        BinaryTreeNode root = rebuildSubTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
        return root;
    }

    public BinaryTreeNode rebuildSubTree(int[] preOrder, int preI, int preJ, int[] inOrder, int inI, int inJ) {
        if(preI > preJ) return null;
        if(preI == preJ) return new BinaryTreeNode(preOrder[preI]);
        BinaryTreeNode root = new BinaryTreeNode(preOrder[preI]);
        int inRootIndex = findIndex(inOrder, inI, inJ+1, root.val);
        if(inI<=inRootIndex-1) root.m_pLeft = rebuildSubTree(preOrder, preI+1, preI+inRootIndex-inI, inOrder, inI, inRootIndex-1);
        if(inRootIndex+1<=inJ) root.m_pRight = rebuildSubTree(preOrder, preI+inRootIndex-inI+1, preJ, inOrder, inRootIndex+1, inJ);
        return root;
    }

    private int findIndex(int[] array, int i, int j, int target) {
        for(int k = i; k <= j; k++) {
            if(array[k] == target) return k;
        }
        return -1;
    }
}

class BinaryTreeNode {
    int val;
    BinaryTreeNode m_pLeft = null;
    BinaryTreeNode m_pRight = null;
    public BinaryTreeNode(int val) {
        this.val = val;
    }
}