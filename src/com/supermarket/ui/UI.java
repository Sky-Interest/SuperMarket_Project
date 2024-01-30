package com.supermarket.ui;

import java.util.Scanner;

public class UI {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mainLogin();
    }
    //第一层登录UI
    public static void mainLogin(){
        while (true) {
            System.out.println("=====================欢迎来到一家超市=============================");
            System.out.println("=====================员工登录请输入:1=============================");
            System.out.println("=====================会员登录请输入:2=============================");
            System.out.println("=====================退出系统请输入:0=============================");
            System.out.println("请输入您的选择");
            int i = sc.nextInt();
            switch (i){
                case 1:
                    employeeLogin();
                    break;
                case 2:
                    vipLogin();
                    break;
                case 0:
                    System.out.println("亲爱的客户,再见,欢迎您再次光临！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("选择有误!");
            }
        }
    }
    //第二层登录UI
    public static void employeeLogin(){

        while (true){
            System.out.println("==========当前页面:员工登录==========");
            System.out.println("==========管理员登录请输入:1=========");
            System.out.println("==========收银员登录请输入:2=========");
            System.out.println("==========采购员登录请输入:3=========");
            System.out.println("==========退出此页面请输入:0=========");
            System.out.println("请输入您的选项:");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    //管理员登录
                    System.out.println("跳转中");
                    adminFunc();
                    break;
                case 2:
                    //收银员登录
                    System.out.println("跳转中");
                    cashierFunc();
                    break;
                case 3:
                    //采购员登录
                    System.out.println("跳转中");
                    buyerFunc();
                    break;
                case 0:
                    //退出登录
                    System.out.println("亲爱的客户,再见,欢迎您再次光临！");

                    return;
                default:
                    System.out.println("您的输入有误，请重新输入！");
            }
        }
    }
    public static void vipLogin(){
        //1.判断登录的账号密码
        System.out.println("vip");
        while (true){
            System.out.println("==========您好!尊贵的会员xxx==========");
            System.out.println("==========查询会员积分请输入:1=========");
            System.out.println("==========退出系统请输入:0=============");
            int i = sc.nextInt();
            switch (i){
                case 1:
                    //查询积分
                    vipFunc();
                    break;
                case 0:
                    //退出系统
                    System.out.println("亲爱的会员,再见,欢迎您再次光临！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入！");
                    break;
            }
        }

    }
    //第三层登录UI
    public static void adminFunc(){
        //1.判断登录账户
        //2.功能:收银员账户增删改查
        //3.功能:采购员账户增删改查
        //4.功能:员工出勤管理
        //5.功能:查询超市营业额
        //6.会员管理
        //7.查询所有人信息
        //8上下班打卡
        System.out.println("admin");
    }
    public static void cashierFunc(){
        //1.判断账户
        //1.收银结算
        //2.会员积分查询
        //3.开通会员:增加会员信息
        //4.上下班打卡
        System.out.println("cashier");
    }
    public static void buyerFunc(){
        //1.判断账户
        //1.进行商品补货:获取低于某值的商品信息,并进行修改
        //2.查询进货信息
        //3.上下班打卡
        System.out.println("buyer");
    }
    public static void vipFunc(){
        //会员功能：查询积分
        System.out.println("vipfunc");
    }



}
