package com.leetcode;
import java.util.*;
/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

思路：
    通过dfs来回溯剪枝，关键是快速判断选中列，选中正对角线和副对角线是否已经有皇后存在
 */
public class NQueens {
    public static void main(String[] args) {
        Solution71 s = new Solution71();
        List<List<String>> res = s.solveNQueens(6);
        System.out.println(res.size());
        for(int i = 0; i < res.size(); i++) {
            List<String> result = res.get(i);
            for(int j = 0; j < result.size(); j++) {
                if(j==0) System.out.println("[\"" + result.get(j)+"\",");
                else if(j==result.size()-1) System.out.println(" \"" + result.get(j)+"\"]");
                else System.out.println(" \"" + result.get(j)+"\",");
            }
        }
    }
}

class Solution71 {
    private int[][] matrix;
    private boolean[] colVisited;
    private int[] selectCol;
    private boolean[] posDiag;
    private boolean[] negDiag;
    private int N;
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        N = n;
        matrix = new int[n][n];
        colVisited = new boolean[n];
        selectCol = new int[n];
        posDiag = new boolean[2*n-1];
        negDiag = new boolean[2*n-1];
        for(int i = 0; i < n; i++) colVisited[i] = false;
        for(int i = 0; i < 2*n-1; i++) {
            posDiag[i] = false;
            negDiag[i] = false;
        }
        for(int i = 0; i < n; i++) selectCol[i] = -1;
        dfs(0);
        return res;
    }

    private void dfs(int row) {
        if(row >= N) {
            List<String> result = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                StringBuilder rowRes = new StringBuilder();
                for(int j = 0; j < N; j++) {
                    rowRes.append(selectCol[i]==j?'Q':'.');
                }
                result.add(rowRes.toString());
            }
            res.add(result);
        }
        for(int i = 0; i < N; i++) {
            if(colVisited[i]==false && posDiag[row+i]==false && negDiag[N-1-i+row]==false) {
                colVisited[i] = true;
                posDiag[row+i] = true;
                negDiag[N-1-i+row] = true;
                selectCol[row] = i;
                dfs(row+1);
                selectCol[row] = -1;
                posDiag[row+i] = false;
                negDiag[N-1-i+row] = false;
                colVisited[i] = false;
            }
        }
    }
}