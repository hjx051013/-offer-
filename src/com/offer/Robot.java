package com.offer;


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