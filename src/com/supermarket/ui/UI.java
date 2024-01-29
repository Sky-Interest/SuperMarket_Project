package com.supermarket.ui;

import java.util.Scanner;

public class UI {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=====================欢迎来到xx超市xx=!===========================");
            System.out.println("=====================员工登录请输入:1=============================");
            System.out.println("=====================会员登录请输入:2=============================");
            System.out.println("请输入您的选择");
            int i = sc.nextInt();
            switch (i){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("亲爱的客户,再见,欢迎您再次光临！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("选择有误!");
            }
        }

    }
    public static void employeeLogin(){

        while (true){

        }
    }

}
