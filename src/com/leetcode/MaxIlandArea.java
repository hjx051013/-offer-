package com.leetcode;

/*
给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。

示例 2:

[[0,0,0,0,0,0,0,0]]
对于上面这个给定的矩阵, 返回 0。

注意: 给定的矩阵grid 的长度和宽度都不超过 50。

方法一：
深度优先搜索
对每个值为1并且未访问的点深度遍历，统计以该点为中心向四周扩展的未访问过的值为①的点的个数
方法二：
并查集
起初将每个点设为孤立的并查集，然后每次扫描到一个值为1的点，就将它四周的点的并查集与该点并查集合并
 */

public class MaxIlandArea {
    public static void main(String[] args) {
//        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                         {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                         {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                         {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                         {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                         {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid = {{0,0,0,0,0,0,0,0}};
        Solution4 s = new Solution4();
        System.out.println(s.maxAreaOfIsland(grid));

    }
}

//class Solution3 {
//    private int maxArea = 0;
//    private int[][] d = {{-1,0},{0,-1},{1,0},{0,1}};
//    boolean[][] visited;
//
//    private int dfs(int[][] grid,int x,int y) {
//        int sum = 0;
//        visited[x][y] = true;
//        sum++;
//        for(int i = 0; i < d.length; i++) {
//            int newX=x+d[i][0],newY = y+d[i][1];
//            if(newX>=0&&newX<grid.length&&newY>=0&&newY<grid[0].length&&visited[newX][newY]==false&&grid[newX][newY]==1) {
//                sum+=dfs(grid,x+d[i][0],y+d[i][1]);
//            }
//        }
//        return sum;
//    }
//
//    public int maxAreaOfIsland(int[][] grid) {
//        visited = new boolean[grid.length][grid[0].length];
//        int max = 0;
//        for(int i = 0; i < grid.length; i++) {
//            for(int j = 0; j < grid[0].length; j++) {
//                if(grid[i][j]==1&&visited[i][j]==false) {
//                    int tmpArea = dfs(grid,i,j);
//                    if(max<tmpArea) max = tmpArea;
//                }
//            }
//        }
//        return max;
//    }
//}

class Solution4 {
    private int[][] d = {{-1,0},{0,-1},{1,0},{0,1}};

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length*grid[0].length;
        UnionSet us = new UnionSet(n);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    for(int k = 0; k < d.length; k++) {
                        int newX = i+d[k][0],newY = j+d[k][1];
                        if(newX>=0&&newX<grid.length&&newY>=0&&newY<grid[0].length&&grid[newX][newY]==1) {
                            us.union(i*grid[0].length+j,newX*grid[0].length+newY);
                        }
                    }
                }
            }
        }
        int[] set = us.getSet();
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) {
                    int root = us.find(i*grid[0].length+j);
                    if(Math.abs(set[root])>max) max = Math.abs(set[root]);
                }
            }
        }
        return max;
    }
}

class UnionSet {
    private int[] set;
    public UnionSet(int n) {
        set = new int[n];
        for(int i = 0; i < n; i++) {
            set[i] = -1;
        }
    }

    public int[] getSet() {
        return set;
    }

    public int find(int x) {
        int r = x;
        while(set[r]>0) r = set[r];//r为根
        while(set[x]>0) {
            int father = set[x];
            set[x] = r;
            x = father;
        }
        return r;
    }

    public void union(int x,int y) {
        int fx = find(x);
        int fy = find(y);
        if(fx==fy) return;
        else {
            int size_x = -set[fx];
            int size_y = -set[fy];
            set[fx] = fy;
            set[fy] = -(size_x+size_y);
        }

    }
}