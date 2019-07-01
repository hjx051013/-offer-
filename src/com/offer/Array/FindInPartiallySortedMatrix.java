package com.offer.Array;

/*
题目：
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。例如下例：
1  2  8  9
2  4  9  12
4  7  10 13
6  8  11 15
如果在这个数组中查找数字7，则返回true；如果查找数字5，由于数组不含有该数字，则返回false。
思路：
找当前选定矩阵的右上角元素，如果右上角元素大于目标元素，删去第一行
如果右上角元素小于目标元素，删去最后一列，如果等于，返回true.

* */
public class FindInPartiallySortedMatrix {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(s.Find(5, array));
    }

}

class Solution4 {
    public boolean Find(int target, int[][] array) {
        int curI = 0, curJ = array[0].length-1;
        while(curI < array.length && curJ >= 0) {
            if(target > array[curI][curJ]) {
                curI++;
            } else if(target < array[curI][curJ]) {
                curJ--;
            } else {
                return true;
            }
        }
        return false;
    }
}