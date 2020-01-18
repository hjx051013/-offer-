package com.leetcode;

import java.util.Scanner;
/*
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

思路：
朝着当前方向往前走，如果下一个位置已经访问或者走不通，就转换方向走，如果转换方向下一个位置仍然已经访问或者走不通，就结束
*/
public class GenerateMatrix {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final Solution89 s = new Solution89();
        final int[][] res = s.generateMatrix(n);
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
        in.close();
    }
}

class Solution89 {
    private final int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}}; // 右，下，左，上
    private boolean[][] visited;
    private int[][] matrix;
    public int[][] generateMatrix(final int n) {
        matrix = new int[n][n];
        visited = new boolean[n][n];
        int nowDir = 0;
        int x = 0, y = 0;
        int k = 1;
        while(x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
            visited[x][y] = true;
            matrix[x][y] = k;
            int nextX, nextY;
            nextX = x + directions[nowDir][0];
            nextY = y + directions[nowDir][1];
            if(!(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY])) {//该方向往前不通
                nowDir = (nowDir+1)%4;
                nextX = x + directions[nowDir][0];
                nextY = y + directions[nowDir][1];
            }
            if(!(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY])) {//换方向仍然不通break
                break;
            }
            x = nextX;
            y = nextY;
            k++;
        }
        return matrix;
    }
}