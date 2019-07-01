package com.offer;
/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
例如
a b c e
s f c s
a d e e
这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

思路：
从每个格点开始进行深度遍历，如果周围格点字符等于字符串响应位置上的字符，那么
 */

public class MatrixPath {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        char[] path = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'b','c','c','e','d'};
        System.out.println(s.hasPath(path,3,4,str));
    }
}

class Solution2 {

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
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                if(str.length>0&&matrix[i*cols+j]==str[0]&&dfs(matrix,visited,i,j,cols,rows,0,str)) return true;
            }
        }
        return false;
    }
}