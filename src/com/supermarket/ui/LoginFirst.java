package com.supermarket.ui;

import java.util.Scanner;

public class LoginFirst {
    private Scanner sc = new Scanner(System.in);

    public void UI() {
        while (true) {
            System.out.println("*****************粤嵌超市欢迎你*****************");
            System.out.println("\t1.员工登录\n\t2.VIP登录\n\t0.安全退出");
            String in = sc.next();
            switch (in) {
                case "1":
//                    String json = login("employee-login");
//                    if (json.equals("null")) {
//                        System.out.println("账号或者密码错误!");
//                    } else {
//                        //判断角色
//                        Employee employee = JSON.parseObject(json, Employee.class);
//                        switch (employee.getRole()) {
//                            case 1:
//                                //管理员
//
//                                break;
//                            case 2://收银员
//
//                                break;
//                            case 3:
//                                //采购员
//
//                                break;
//                        }
//                    }

                    break;
                case "2":
                    //会员登录
//                    login("vip-login");

                    break;
                case "0":
                    System.out.println("*****************see you*****************");
                    System.exit(0);
                    break;
                default:
                    System.out.println("选择有误!");
            }


        }
    }

}
