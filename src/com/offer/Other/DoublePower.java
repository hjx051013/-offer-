package com.offer.Other;

/*
不使用库函数，计算double类型base的exponent次方，其中exponent为整型
思路：
    需要注意底数为0，而指数<0的异常
    先去指数的绝对值，然后求其幂，根据指数的正负返回结果
* */
public class DoublePower {
    public static void main(String[] args) {
        Solution11 s = new Solution11();
        System.out.println(s.power(0.9, 2));
    }
}

class Solution11 {
    public double power(double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            throw new IllegalArgumentException();
        }
        int absExpo = exponent < 0?-exponent:exponent;
        double result = powerWithPosExpo(base, absExpo);
        if (exponent < 0) return 1.0/result;
        else return result;
    }

    private double powerWithPosExpo(double base, int exponent) {
        double result;
        if(exponent == 0) return 1.0;
        else if(exponent == 1) return base;
        else {
            result = powerWithPosExpo(base, exponent>>1);
            result *= result;
            if ((exponent&0x1) == 1) {
                result *= base;
            }
            return result;
        }
    }

    private boolean equal(double d1, double d2) {
        if (d1 - d2 > 0.000001 || d1 - d2 < -0.000001) {
            return true;
        }
        return false;
    }
}