package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/9/23.
 * 已知某公司总人数为W，平均年龄为Y岁(每年3月末计算，同时每年3月初入职新人)，假设每年离职率为x，x>0&&x<1,每年保持所有员工总数不变进行招聘，新员工平均年龄21岁。
 * 从今年3月末开始，请实现一个算法，可以计算出第N年后公司员工的平均年龄。(结果向上取整)。
 * 输入描述:
 * 输入W Y x N
 * 输出描述:
 * 输出第N年后的平均年龄
 * 输入例子: 168 26 0.4 78
 * 输出例子: 5
 * <p>
 * self 分析:
 * 初始年和 WY,y0=Y
 * 1: 走Wx, 剩W(1-x), y1=[W(1-x)*(y0+1)+Wx*21]/W
 * 2: y2=[W(1-x)*(y1+1)+Wx*21]/W
 * yn=[W(1-x)*(yn-1 + 1) + Wx*21]/W
 * Yn=(1-x)(Yn-1 + 1)+ 21x ->
 * Yn + C = (1-x)(Yn-1 + C), C=-(1+20x)/x
 * Yn = (Y0+C)(1-x)^(n-1)-C
 */
public class AverageAge {
    public static int getNYearsAge(double y, double x, int n) {
        double a = 1 - x;
        double b = 1 + 20 * x;
        double base = y + b / (a - 1);
        double res = Math.pow(a, n) * base;
        return (int) Math.ceil(res - b / (a - 1));
    }

    public double getPower(double a, int n) {
        double res = 1;
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res *= a;
            }
            a *= a;
        }
        return res;
    }

    public int getNYearsAgeSelf(double y, double x, int n) {
        double C = -(1 + 20 * x) / x;
        double res = (y + C) * getPowerSelf(1 - x, n) - C;
        return (int) Math.ceil(res);
    }

    public double getPowerSelf(double a, int n) {
        if (n == 0) return 1;
        if (n == 1) return a;
        if ((n & 1) == 0) {
            return getPowerSelf(a * a, n / 2);
        } else {
            return getPowerSelf(a * a, n / 2) * a;
        }
    }

    public static void main(String[] args) {
        int w = 168;
        double y = 26;
        double x = 0.59;
        int n = 3;
        System.out.println("y = " + y + ", x = " + x + ", n = " + n);
        System.out.println("getNYearsAge(y,x,n) = " + getNYearsAge(y, x, n));
        System.out.println("getPowerSelf(y,x,n) = " + new AverageAge().getNYearsAgeSelf(y, x, n));
    }
}
