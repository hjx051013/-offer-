package com.offer;

import java.util.ArrayList;
import java.util.List;
public class MatrixPath {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        char[] path = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'b','c','c','e','d'};
        System.out.println(s.hasPath(path,3,4,str));
    }
}

class Solution5 {

    private int[][] inc = {{-1,0},{0,1},{1,0},{0,-1}};
    private boolean dfs(char[] matrix,boolean[][] visited,int x, int y,int cols,int rows,int index,char[] str) {
        visited[x][y] = true;
        if(index==str.length-1) {
            return true;
        }
        boolean result = false;
        for(int i = 0; i < inc.length; i++) {
            int newX = x+inc[i][0],newY = y+inc[i][1];
            if(newX>=0&&newX<visited.length&&newY>=0&&newY<visited[0].length&&visited[newX][newY]==false&&matrix[newX*cols+newY]==str[index+1]) {
                result = result||dfs(matrix,visited,newX,newY,cols,rows,index+1,str);
            }
            if(result) break;
        }
        return result;
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        List<List<Integer>> startPos = new ArrayList<>();//存储起点的集合

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                if(str.length>0&&matrix[i*cols+j]==str[0]&&dfs(matrix,visited,i,j,cols,rows,0,str)) return true;
            }
        }
        return false;
    }
}