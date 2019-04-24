package com.offer;
import java.util.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    private static boolean valid(int type1,int type2) {
        if((type1==1&&type2==3)||(type1==3&&type2==1)) return false;
        return true;
    }
    private static int totalPrice(int categoryCount, int totalVolume, int totalWeight, int[] volume, int[] weight,
                                  int[] stock, int[] price, int[] itemType) {
        int[][] type = new int[totalVolume+1][totalWeight+1];//0,1,3
        int[][] dp = new int[totalVolume+1][totalWeight+1];
        int[][][] used = new int[totalVolume+1][totalWeight+1][categoryCount+1];
        int minV = Integer.MAX_VALUE,minW = Integer.MAX_VALUE;
        for(int i = 0; i < categoryCount; i++) {
            if(volume[i] < minV) minV = volume[i];
            if(weight[i] < minW) minW = weight[i];
        }
        for(int i = 0;i < minV; i++) {
            for(int j = 0; j < minW; i++) {
                dp[i][j] = 0;
                type[i][j] = 0;
            }
        }
        for(int i = 0;i < totalVolume+1; i++) {
            for (int j = 0; j < totalWeight+1; j++) {
                for(int k = 1; k <= categoryCount; k++) used[i][j][k] = 0;
            }
        }
        for(int i = minV; i < totalVolume+1; i++) {
            for(int j = minW; j < totalWeight+1; j++) {
                int max = -1;
                int typ = 0;
                int tk = -1;
                for(int k = 1; k <= categoryCount; k++) {
                    if(volume[k]<=i&&weight[k]<=j&&dp[i-volume[k]][j-weight[k]]+price[k]>max&&used[i-volume[k]][j-weight[k]][k]<stock[k]&&valid(type[i-volume[k]][j-weight[k]],itemType[k])) {
                        max = dp[i-volume[k]][j-weight[k]]+price[k];
                        typ = itemType[k];
                        tk  = k;
                    }
                }
                if(max<0) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = max;
                    for(int k = 1; k <= categoryCount; k++) {
                        if(k==tk) {
                            used[i][j][k] = used[i-volume[tk]][j-weight[tk]][k]+1;
                        }
                        else used[i][j][k] = used[i-volume[tk]][j-weight[tk]][k];
                    }
                }
                type[i][j] = typ;
            }
        }

        return dp[totalVolume][totalWeight];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        //总共商品种类
        int categoryCount = Integer.valueOf(line[0]);
        //快递体积
        int totalVolume = Integer.valueOf(line[1]);
        //快递重量
        int totalWeight = Integer.valueOf(line[2]);

        //物品体积
        int[] volume = new int[50];
        //重量
        int[] weight = new int[50];
        //件数
        int[] stock = new int[50];
        //价格
        int[] price = new int[50];
        //类型
        int[] itemType = new int[50];

        for (int i = 1; i <= categoryCount; i++) {
            line = in.nextLine().split(",");
            volume[i] = Integer.valueOf(line[0]);
            weight[i] = Integer.valueOf(line[1]);
            stock[i] = Integer.valueOf(line[2]);
            price[i] = Integer.valueOf(line[3]);
            itemType[i] = Integer.valueOf(line[4]);
        }

        in.close();

        System.out.println(totalPrice(categoryCount, totalVolume, totalWeight, volume, weight, stock, price, itemType));

    }
}