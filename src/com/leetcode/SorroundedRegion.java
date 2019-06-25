package com.leetcode;

import java.util.HashSet;
import java.util.Set;
/*
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

方法：
1. 并查集，将为'X','O'并且连通的字符组成并查集，然后挑选边框且字符为'O'的字符寻找其所在并查集根组成一个集合，然后将中间字符为'O'且S根不在S中的点置字符为'X'
2. dfs算法，对边框中为'O'的点进行dfs，dfs过的节点选中，遍历字符二维数组，对其中字符为'O'且未被选中的节点置字符为'X'
* */
public class SorroundedRegion {
    public static void main(String[] args) {
//        char[][] board = {{'X','O','X','X'},
//                          {'O','X','O','X'},
//                          {'X','O','X','O'},
//                          {'O','X','O','X'},
//                          {'X','O','X','O'},
//                          {'O','X','O','X'}};
        char[][] board = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','X','O','X'},
                          {'X','O','X','X'}};
        Solution50 s = new Solution50();
        s.solve(board);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class Solution50 {
    //并查集解法
    /*
    public void solve(char[][] board) {
        if(board==null || board.length<=2 ||board[0].length<=2) return;
        UnionSet us = new UnionSet(board.length*board[0].length);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(j<board[0].length-1&&board[i][j]==board[i][j+1]) us.union(i*board[0].length+j, i*board[0].length+j+1);
                if(i<board.length-1&&board[i][j]==board[i+1][j]) us.union(i*board[0].length+j, (i+1)*board[0].length+j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i  < board.length; i++) {
            if(i==0||i==board.length-1) {//第一行或者倒数第一行
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j]=='O') set.add(us.find(i*board[0].length+j));
                }
            } else {//中间行
                if(board[i][0]=='O') set.add(us.find(i*board[0].length));
                if(board[i][board[0].length-1]=='O') set.add(us.find(i*board[0].length+board[0].length-1));
            }
        }

        for(int i = 1; i < board.length-1; i++) {
            for(int j = 1; j < board[0].length-1; j++) {
                if(board[i][j]=='O'&&!set.contains(us.find(i*board[0].length+j))) {//如果与边界'O'不是同一个联通集，则需要改为'X'
                    board[i][j] = 'X';
                }
            }
        }
    }
    */
    boolean[][] selected;
    //dfs解法
    public void solve(char[][] board) {
        if(board==null || board.length<=2 ||board[0].length<=2) return;
        selected = new boolean[board.length][board[0].length];
        for(int i = 0; i < selected.length; i++) {
            if(i==0||i==board.length-1) {//第一行或者倒数第一行
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == 'O'&&selected[i][j] == false) {
                        dfs(i,j,board);
                    }
                }
            } else {//中间行
                if(board[i][0]=='O'&&selected[i][0] == false) dfs(i,0,board);
                if(board[i][board[0].length-1]=='O'&&selected[i][board[0].length-1] == false) dfs(i,board[0].length-1,board);
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='O'&&selected[i][j]!=true) board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j,char[][] board) {
        selected[i][j] = true;
        if(i-1>=0&&selected[i-1][j]==false&&board[i-1][j]=='O')
            dfs(i-1,j,board);
        if(j+1<selected[0].length&&selected[i][j+1]==false&&board[i][j+1]=='O')
            dfs(i,j+1,board);
        if(i+1<selected.length&&selected[i+1][j]==false&&board[i+1][j]=='O')
            dfs(i+1,j,board);
        if(j-1>=0&&selected[i][j-1]==false&&board[i][j-1]=='O')
            dfs(i,j-1,board);
    }
}