package com.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

思路：
朝着当前方向往前走，如果下一个位置已经访问或者走不通，就转换方向走，如果转换方向下一个位置仍然已经访问或者走不通，就结束
*/
public class SpiralOrder {
    public static void main(String[] args) {
        Solution88 s = new Solution88();
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12}
        };
        List<Integer> res = s.spiralOrder(matrix);
        for(Integer e:res) {
            System.out.print(e+" ");
        }
    }
}

class Solution88 {
    private int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}}; // 右，下，左，上
    private boolean[][] visited;
    private List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length == 0) {
            return res;
        }
        visited = new boolean[matrix.length][matrix[0].length];
        int nowDir = 0;
        int x = 0, y = 0;
        while(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y]) {
            visited[x][y] = true;
            res.add(Integer.valueOf(matrix[x][y]));
            int nextX, nextY;
            nextX = x + directions[nowDir][0];
            nextY = y + directions[nowDir][1];
            if(!(nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && !visited[nextX][nextY])) {//该方向往前不通
                nowDir = (nowDir+1)%4;
                nextX = x + directions[nowDir][0];
                nextY = y + directions[nowDir][1];
            }
            if(!(nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && !visited[nextX][nextY])) {//换方向仍然不通break
                break;
            }
            x = nextX;
            y = nextY;
        }
        return res;
    }
}