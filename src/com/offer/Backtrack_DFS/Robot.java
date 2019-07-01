package com.offer.Backtrack_DFS;

/*
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
但是不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

思路：
从每个未被访问的点开始深度遍历，遍历过程中标记已经访问的点并且自增已到达格子数目
 */
public class Robot {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.movingCount(4,4,4));
    }
}

class Solution1 {
    private int validCnt = 0;
    private int[][] inc = {{-1,0},{0,1},{1,0},{0,-1}};
    private boolean canVisit(int i,int j,int threshold) {
        String i_str = String.valueOf(i);
        String j_str = String.valueOf(j);
        int k;
        int sum = 0;
        for(k = 0; k < i_str.length(); k++) {
            sum += (i_str.charAt(k)-'0');
        }
        for(k = 0; k < j_str.length(); k++) {
            sum += (j_str.charAt(k))-'0';
        }
        if(sum > threshold) return false;
        else return true;

    }

    private void dfs(boolean[][] visited,int x,int y) {
        visited[x][y] = true;
        validCnt++;
        for(int i = 0; i < inc.length; i++) {
            int newX = x+inc[i][0],newY = y+inc[i][1];
            if(newX>=0&&newX<visited.length&&newY<visited[0].length&&newY>=0&&visited[newX][newY]==false) {
                dfs(visited,newX,newY);
            }
        }
    }

    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(!canVisit(i,j,threshold)) visited[i][j] = true;
            }
        }
        dfs(visited,0,0);
        return validCnt;
    }
}