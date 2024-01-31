package com.supermarket.ui;

import com.supermarket.entity.Employee;
import com.supermarket.service.EmployeeService;
import com.supermarket.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class UI {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    adminFunc_cashier();

//        mainLogin();
    }

    //第一层登录UI
    public static void mainLogin() {
        while (true) {
            System.out.println("=====================欢迎来到一家超市=============================");
            System.out.println("=====================员工登录请输入:1=============================");
            System.out.println("=====================会员登录请输入:2=============================");
            System.out.println("=====================退出系统请输入:0=============================");
            System.out.println("请输入您的选择");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    Employee employee_info = employeeLogin();
                    String role = null;
                    if (employee_info.getRole() == 1) {
                        role = "管理员";
                        adminFunc(employee_info, role);
                    } else if (employee_info.getRole() == 2) {
                        role = "收银员";
                        cashierFunc(employee_info, role);
                    } else if (employee_info.getRole() == 3) {
                        role = "采购员";
                        buyerFunc(employee_info, role);
                    }

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
    public static Employee employeeLogin() {
//    @Test
//    public void employeeLogin(){
        EmployeeService employeeService = new EmployeeServiceImpl();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Employee employee_info = null;

        while (flag) {
            System.out.println("==========当前页面:员工登录==========");
//            System.out.println("==========管理员登录请输入:1=========");
//            System.out.println("==========收银员登录请输入:2=========");
//            System.out.println("==========采购员登录请输入:3=========");
//            System.out.println("==========退出此页面请输入:0=========");
//            System.out.println("请输入您的账号:");
//            String enumber = sc.next();
//            System.out.println("请输入您的密码:");
//            String epsw = sc.next();
//            Employee employeeNamePsw = employeeService.getEmployeeNumNamePsw(enumber,epsw);
//            employeeNamePsw.getNumber();

            //登录功能
            while (flag) {
                try {

                    if (!flag) {

                        break;
                    }
                    while (flag) {

                        System.out.println("请输入您的账号:");
                        String enumber = sc.next();
                        System.out.println("请输入您的密码:");
                        String epsw = sc.next();
                        employee_info = employeeService.getEmployeeNumNamePsw(enumber, epsw);
                        System.out.println(employee_info.toString());
                        if (employee_info != null) {
                            flag = false;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("账号或密码错误，请重新输入");
                }
            }

//            employeeService.getEmployeesAll();
//            int i = sc.nextInt();
//            switch (i) {
//                case 1:
//                    //管理员登录
//                    System.out.println("跳转中");
//                    adminFunc();
//                    break;
//                case 2:
//                    //收银员登录
//                    System.out.println("跳转中");
//                    cashierFunc();
//                    break;
//                case 3:
//                    //采购员登录
//                    System.out.println("跳转中");
//                    buyerFunc();
//                    break;
//                case 0:
//                    //退出登录
//                    System.out.println("亲爱的客户,再见,欢迎您再次光临！");
//
//                    return;
//                default:
//                    System.out.println("您的输入有误，请重新输入！");
//            }

            //需要添加跳出循环标志
        }
        return employee_info;
    }

    public static void vipLogin() {
        //1.判断登录的账号密码
        System.out.println("vip");
        while (true) {
            System.out.println("==========您好!尊贵的会员xxx==========");
            System.out.println("==========查询会员积分请输入:1=========");
            System.out.println("==========退出系统请输入:0=============");
            int i = sc.nextInt();
            switch (i) {
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
    public static void adminFunc(Employee employee_info, String role) {
        //1.判断登录账户
        //2.功能:收银员账户增删改查
        //3.功能:采购员账户增删改查
        //4.功能:员工出勤管理
        //5.功能:查询超市营业额
        //6.会员管理
        //7.查询所有人信息
        //8上下班打卡
        while (true) {
            System.out.println("==========欢迎您!"+employee_info.getUsername()+"("+role+")"+"==========");
            System.out.println("1.收银员管理");
            System.out.println("2.采购员管理");
            System.out.println("3.员工出勤管理");
            System.out.println("4.查询超市营业额");
            System.out.println("5.会员管理");
            System.out.println("6.查询所有人信息");
            System.out.println("7.上班打卡");
            System.out.println("8.下班打卡");
            System.out.println("0.退出系统");
            System.out.println("请选择功能:");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    adminFunc_cashier();
                case 2:
                    adminFunc_buyer();
                case 3:
                    while (true) {
                        System.out.println("==========当前页面:收银员管理==========");

                    }

                case 4:
                    while (true) {
                        System.out.println("==========当前页面:收银员管理==========");

                    }

                case 5:
                    adminFunc_vip();

                case 6:
                    EmployeeService employee = new EmployeeServiceImpl();
                    employee.getEmployeesAll();
                case 7:
                    while (true) {
                        System.out.println("==========当前页面:收银员管理==========");

                    }

                case 8:
                    while (true) {
                        System.out.println("==========当前页面:收银员管理==========");

                    }

                case 0:
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
                    break;
            }
        }


    }

    public static void cashierFunc(Employee employee_info, String role) {
        //1.判断账户
        //1.收银结算
        //2.会员积分查询
        //3.开通会员:增加会员信息
        //4.上下班打卡
//        System.out.println(employee_info);
        System.out.println("==========欢迎您！" + employee_info.getUsername() + "(" + role + ")" + "==========");


    }

    public static void buyerFunc(Employee employee_info, String role) {
        //1.判断账户
        //1.进行商品补货:获取低于某值的商品信息,并进行修改
        //2.查询进货信息
        //3.上下班打卡
//        System.out.println(employee_info);
        System.out.println("==========欢迎您！" + employee_info.getUsername() + "(" + role + ")" + "==========");


    }

    public static void vipFunc() {
        //会员功能：查询积分
        System.out.println("vipfunc");
    }

    public static void adminFunc_cashier() {
        EmployeeService admin_cashier = new EmployeeServiceImpl();
        Employee cashier = new Employee();
        while (true) {
            System.out.println("==========当前页面:收银员管理==========");
            System.out.println("1.增加收银员");
            System.out.println("2.删除收银员");
            System.out.println("3.修改收银员");
            System.out.println("4.查询收银员");
            System.out.println("0.退出此页面");
            System.out.println("请输入选项:");
            int i1 = sc.nextInt();
            switch (i1) {
                case 1:
                    //增加收银员
                    //角色默认为2
                    cashier.setRole(2);
                    System.out.println("请输入收银员编号");
                    cashier.setNumber(sc.next());
                    System.out.println("请输入收银员姓名");
                    cashier.setUsername(sc.next());
                    System.out.println("请输入收银员密码");
                    cashier.setPassword(sc.next());
                    System.out.println("请输入收银员性别");
                    cashier.setSex(sc.next());
                    System.out.println("请输入收银员手机");
                    cashier.setPhone(sc.next());
                    System.out.println("请输入备注");
                    cashier.setRemark(sc.nextInt());
                    System.out.println(cashier);
                    //向数据库发送数据
                    admin_cashier.addEmployee(cashier);
                    System.out.println(admin_cashier.getEmployeesAll());
                    break;
                case 2:
                    //删除收银员
                    System.out.println("请输入需要删除的编号");
                    String num1 =sc.next();
//                    System.out.println("你确定要删除吗?输入是|否:");
//                    String isDelete = sc.next();
//                    if(isDelete.equals("是")){
//                     admin_cashier.removeEmployee(cashier);
//                    }
                    admin_cashier.removeEmployee(num1);
                    System.out.println(admin_cashier.getEmployeesAll());
                    break;
                case 3:
                    //修改收银员
                    cashier.setRole(2);
                    System.out.println("请输入需要修改的收银员编号");
                    String num = sc.next();
                    System.out.println("请输入新的收银员姓名");
                    cashier.setUsername(sc.next());
                    System.out.println("请输入新的收银员密码");
                    cashier.setPassword(sc.next());
                    System.out.println("请输入新的收银员性别");
                    cashier.setSex(sc.next());
                    System.out.println("请输入新的收银员手机");
                    cashier.setPhone(sc.next());
                    System.out.println("请输入备注");
                    cashier.setRemark(sc.nextInt());
                    System.out.println(cashier);
                    //向数据库发送数据
                    admin_cashier.updateEmployee(num,cashier);
                    System.out.println(admin_cashier.getEmployeesAll());
                    break;


                case 4:
                    //查询收银员
                    System.out.println("请输入需要查询的收银员编号");
                    String num2 = sc.next();
                    Employee cashier_ser = admin_cashier.getEmployeeNum(num2);
                    System.out.println("姓名:"+cashier_ser.getUsername() +
                            "\n密码:"+ cashier_ser.getPassword()+
                            "\n性别:"+ cashier_ser.getSex()+
                            "\n手机:"+ cashier_ser.getPhone()+
                            "\n状态:"+ cashier_ser.getRemark());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
                    break;
            }
        }
    }

    public static void adminFunc_buyer() {
        while (true) {
            System.out.println("==========当前页面:采购员管理==========");
            System.out.println("1.增加采购员");
            System.out.println("2.删除采购员");
            System.out.println("3.修改采购员");
            System.out.println("4.查询采购员");
            System.out.println("0.退出此页面");
            System.out.println("请输入选项:");
            int i1 = sc.nextInt();
            switch (i1) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 0:
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
            }
        }
    }

    public static void adminFunc_vip() {
        while (true) {
            System.out.println("==========当前页面:会员管理==========");
            System.out.println("1.增加会员");
            System.out.println("2.删除会员");
            System.out.println("3.修改会员");
            System.out.println("4.查询会员");
            System.out.println("0.退出此页面");
            System.out.println("请输入选项:");
            int i1 = sc.nextInt();
            switch (i1) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 0:
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
            }
        }
    }


}
