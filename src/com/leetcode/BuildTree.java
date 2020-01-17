package com.leetcode;
/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

思路：
    递归分治解决问题
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] preOrder = {1,2};
        int[] inOrder = {2,1};
        Solution85 s = new Solution85();
        TreeNode root = s.buildTree(preOrder, inOrder);
        Solution82 s1 = new Solution82();
        System.out.println(s1.inorderTraversal(root));
        return;
    }

}

class Solution85 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length!=inorder.length || preorder.length==0) return null;
        return rebuildTree(preorder,0,inorder,0,preorder.length);
    }

    private TreeNode rebuildTree(int[] preorder, int preStart, int[] inorder, int inStart, int length) {
        if(length==1) return new TreeNode(preorder[preStart]);
        int rootInIndex = 0;
        for(int i = inStart; i < inStart+length; i++) {
            if(inorder[i] == preorder[preStart]) rootInIndex = i;
        }
        TreeNode tmpRoot = new TreeNode(preorder[preStart]);
        int leftLen = rootInIndex-inStart;
        int rightLen = length-1-leftLen;
        tmpRoot.left = leftLen>0?rebuildTree(preorder, preStart+1, inorder, inStart, leftLen):null;
        tmpRoot.right = rightLen>0?rebuildTree(preorder, preStart+1+leftLen, inorder, rootInIndex+1, rightLen):null;
        return tmpRoot;
    }
}