package com.leetcode;

/*

班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1:

输入:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。
示例 2:

输入:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出: 1
说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
注意：

N 在[1,200]的范围内。
对于所有学生，有M[i][i] = 1。
如果有M[i][j] = 1，则有M[j][i] = 1。

问题：简单的求图的连通分量的问题
方法一：对每一个没有访问的节点进行深度遍历，即从一个点出发寻找它能达到且没有访问过的点
方法二：并查集，起始将每个点设为一个单独的并查集，如果它和某个点连通，就合并这两个集合。最终计算并查集数组中值为-1的个数就代表不相重的并查集数目
*/
public class FriendCircle {
    public static void main(String[] args) {
        int[][] M = {{1,1,0},
                     {1,1,1},
                     {0,1,1}};
        Solution11 s = new Solution11();
        System.out.println(s.findCircleNum(M));
    }

}

class Solution11 {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int cnt = 0;
        for(int i = 0; i < M.length; i++) {
            if(visited[i]==false) {
                dfs(M,visited,i);
                cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int[][] M,boolean[] visited,int s) {
        //通过深度遍历将其能通过s访问到的节点全部访问一遍
        visited[s] = true;
        for(int i = 0; i < M.length;i++) {
            if(i!=s&&M[s][i]==1&&visited[i]==false) dfs(M,visited,i);
        }
    }
}