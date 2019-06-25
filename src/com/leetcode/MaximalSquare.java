package com.leetcode;

public class MaximalSquare {
    public static void main(String[] args) {
//        char [][] mat ={{'0','1','1','0','0','1','0','1','0','1'},
//                        {'0','0','1','0','1','0','1','0','1','0'},
//                        {'1','0','0','0','0','1','0','1','1','0'},
//                        {'0','1','1','1','1','1','1','0','1','0'},
//                        {'0','0','1','1','1','1','1','1','1','0'},
//                        {'1','1','0','1','0','1','1','1','1','0'},
//                        {'0','0','0','1','1','0','0','0','1','0'},
//                        {'1','1','0','1','1','0','0','1','1','1'},
//                        {'0','1','0','1','1','0','1','0','1','1'}};
        char[][] mat = {{'1','1'},{'1','1'}};
        Solution25 s = new Solution25();
        System.out.println(s.maximalSquare(mat));
    }
}

class Solution25 {
    private int[][] h;//横向统计点(i,j)(包含)之前的连续1的数量
    private int[][] c;//纵向统计点(i,j)(包含)之前的连续1的数量
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        h = new int[matrix.length][matrix[0].length];
        c = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='1') {
                    if(j>0) h[i][j] = h[i][j-1]+1;
                    else h[i][j] = 1;
                    if(i>0) c[i][j] = c[i-1][j]+1;
                    else c[i][j] = 1;
                } else {
                    h[i][j] = 0;
                    c[i][j] = 0;
                }
            }
        }

        int maxS = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int size = Math.min(h[i][j], c[i][j]);
                    int lastS = size;
                    for (int k = j-size+1; k < j; k++) {
                        if(c[i][k] >= j - k + 1) {//如果
                            if(c[i][k] < lastS) lastS = c[i][k];
                        } else {
                            lastS = j-k;
                        }
                    }
                    if(lastS>maxS) maxS = lastS;
                }
            }
        }

        return maxS*maxS;
    }
}
