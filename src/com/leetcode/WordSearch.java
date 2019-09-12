package com.leetcode;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.

思路：
    深度遍历+回溯法。找到与word[0]匹配的第一个字符，然后向周边深度遍历，如果遇到字符不匹配，就回溯。
 */
public class WordSearch {
    public static void main(String[] args) {
        Solution79 s = new Solution79();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "SEE";
        System.out.println(s.exist(board, word));
    }
}

class Solution79 {
    private int[][] directions  = {{0,1},{1,0},{0,-1},{-1,0}};
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        boolean isExist;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    isExist = dfs(board, i, j, word, 0);
                    visited[i][j] = false;
                    if(isExist) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index) {

        if(index == word.length()-1) return true;
        boolean found;
        for(int i = 0; i < 4; i++) {
            int nextX = x + directions[i][0], nextY = y + directions[i][1];
            if(nextX >= 0 && nextX < board.length && nextY >= 0 &&
                    nextY < board[0].length && visited[nextX][nextY] == false
                    && board[nextX][nextY] == word.charAt(index+1)) {
                visited[nextX][nextY] = true;
                found = dfs(board, nextX, nextY, word, index+1);
                visited[nextX][nextY] = false;
                if(found) {
                    return true;
                }
            }
        }
        return false;
    }
}