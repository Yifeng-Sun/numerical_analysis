package com.company;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Main {

    static final int ITERATIONS = 5;
    public static void main(String[] args) {
	// write your code here
        //rows
        double row1[] = {10, 2, 1};
        double[] lengthJ = new double[ITERATIONS];
        double[] lengthGS = new double[ITERATIONS];
        double[] lengthSOR = new double[ITERATIONS];
//        for(int i: row1){
//            System.out.println(i);
//        }
        //等价改写
        double row2[] = {3, -10, 3};
        double row3[] = {1, 3, 10};
        double row4[] = {14, -5, 14};
        double x[] = {0, 0, 0};
        double con[] = {0, 0, 0};
        con[0] = row4[0] / row1[0];
        con[1] = row4[1] / row2[1];
        con[2] = row4[2] / row3[2];
        double fac1[] = {0, 0, 0};
        fac1[0] = -row2[0] / row1[0];
        fac1[1] = -row1[1] / row2[1];
        fac1[2] = -row1[2] / row3[2];
        double fac2[] = {0, 0, 0};
        fac2[0] = -row3[0] / row1[0];
        fac2[1] = -row3[1] / row2[1];
        fac2[2] = -row2[2] / row3[2];
//        System.out.println(con[0]);

        System.out.println("G-S\n------------------------------------\n\n\n");
        for(int i = 0; i < ITERATIONS; i ++){
            //迭代过程
            x[0] = con[0] + fac1[0] * x[1] + fac2[0] * x[2];
            x[1] = con[1] + fac1[1] * x[0] + fac2[1] * x[2];
            x[2] = con[2] + fac1[2] * x[0] + fac2[2] * x[1];
            System.out.println(x[0] + " " + x[1] + " " + x[2]);
            double[] distance = new double[ITERATIONS];
            distance[0] = abs(1 - x[0]);
            distance[1] = abs(1 - x[1]);
            distance[2] = abs(1 - x[2]);
            lengthJ[i] = sqrt(distance[0] * distance[0] + distance[1] * distance[1] + distance[2] * distance[2]);//求二范数

        }
        System.out.println("final: " + x[0] + " " + x[1] + " " + x[2]);
        System.out.println("距离变化：");
        for(double i: lengthJ){
            System.out.println(i);
        }

        System.out.println("Jacobi\n------------------------------------\n\n\n");
        //transform
        double y[] = {0, 0, 0};//进行迭代
        double z[] = {0, 0, 0};//用于储存每次迭代的结果
        for(int i = 0; i < ITERATIONS; i ++){
            //迭代过程
            y[0] = con[0] + fac1[0] * z[1] + fac2[0] * z[2];
            y[1] = con[1] + fac1[1] * z[0] + fac2[1] * z[2];
            y[2] = con[2] + fac1[2] * z[0] + fac2[2] * z[1];
            z = y;
            System.out.println(z[0] + " " + z[1] + " " + z[2]);
            double[] distance = new double[ITERATIONS];
            distance[0] = abs(1 - z[0]);
            distance[1] = abs(1 - z[1]);
            distance[2] = abs(1 - z[2]);
            lengthJ[i] = sqrt(distance[0] * distance[0] + distance[1] * distance[1] + distance[2] * distance[2]);//求二范数

        }
        System.out.println("final: " + z[0] + " " + z[1] + " " + z[2]);
        System.out.println("距离变化：");
        for(double i: lengthJ){
            System.out.println(i);
        }

    }
}
