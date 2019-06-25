package com.leetcode;

import java.util.Scanner;

import static com.leetcode.SymmetricTree.buildTreeFromStr;

public class ValidBST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        TreeNode root = buildTreeFromStr(line);
        Solution38 s = new Solution38();
        System.out.println(s.isValidBST(root));
    }
}

class Solution38 {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean leftLessThanRoot = true;
        boolean rightMoreThanRoot = true;
        if(root.left!=null)
            leftLessThanRoot = getMax(root.left)<root.val;
        if(root.right!=null)
            rightMoreThanRoot = getMin(root.right)>root.val;
        return leftLessThanRoot&&rightMoreThanRoot&&isValidBST(root.left)&&isValidBST(root.right);
    }

    private int getMin(TreeNode root) {
        TreeNode tmp = root;
        while(tmp.left!=null) {
            tmp = tmp.left;
        }
        return tmp.val;
    }

    private int getMax(TreeNode root) {
        TreeNode tmp = root;
        while(tmp.right!=null) {
            tmp = tmp.right;
        }
        return tmp.val;
    }
}
