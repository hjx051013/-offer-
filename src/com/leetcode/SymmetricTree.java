package com.leetcode;
import java.util.LinkedList;
import java.util.Scanner;

/*
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

1
/ \
2   2
/ \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

1
/ \
2   2
\   \
3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

方法一：
    递归，递归比较两个子树，其中左子树的左节点与右子树的右节点递归比较，左子树的右节点与右子树的左节点递归比较
    迭代，将根节点的左右子节点插入队列中，每次取出两个节点比较其值是否相等，如果不等，跳出，如果相等，然后依次插入第一个节点的左节点，第二个节点的右节点，第一个节点的右节点，第二个节点的左节点，循环判断直到队列不空
*/
public class SymmetricTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        TreeNode root = buildTreeFromStr(line);
        Solution33 s = new Solution33();
        System.out.println(s.isSymmetric(root));
        in.close();
    }

    public static TreeNode buildTreeFromStr(String str) {
        String[] nodes_str = str.split(",");
        TreeNode[] nodes = new TreeNode[nodes_str.length];
        for(int i = 0; i < nodes.length; i++) {
            if(nodes_str[i].equals("null")) {
                nodes[i] = null;
            } else {
                int num = Integer.parseInt(nodes_str[i]);
                TreeNode node = new TreeNode(num);
                nodes[i] = node;
            }
        }
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i]!=null) {
                nodes[i].left = 2*i+1<nodes.length?nodes[2*i+1]:null;
                nodes[i].right = 2*i+2<nodes.length?nodes[2*i+2]:null;
            }
        }
        return nodes[0];
    }
}

class Solution33 {
    /*
    方法一：递归
     */
//    public boolean isSymmetric(TreeNode root) {
//        if(root==null) return true;
//        return symmetricTree(root.left,root.right);
//    }
//
//    public boolean symmetricTree(TreeNode tree1,TreeNode tree2) {
//        if(tree1==null&&tree2==null) return true;
//        else if(tree1==null||tree2==null) return false;
//        else if(tree1.val!=tree2.val) return false;
//        else return symmetricTree(tree1.left,tree2.right)&&symmetricTree(tree1.right,tree2.left);
//    }


    /*
    方法二：迭代
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        boolean isSymmetric = true;
        while(!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if(leftNode!=null&&rightNode!=null) {
                if(leftNode.val == rightNode.val) {
                    queue.add(leftNode.left);queue.add(rightNode.right);
                    queue.add(leftNode.right);queue.add(rightNode.left);
                } else {
                    isSymmetric = false;
                    break;
                }
            } else if(leftNode==rightNode) {//我为null
                continue;
            } else {//只有一个为null
                isSymmetric = false;
                break;
            }
        }

        return isSymmetric;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}