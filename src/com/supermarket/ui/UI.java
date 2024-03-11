package com.supermarket.ui;

import com.supermarket.entity.*;
import com.supermarket.service.*;
import com.supermarket.service.impl.*;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UI {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

//    adminFunc_cashier();
        mainLogin();
//        adminFunc_vip();
//        adminFunc_clock();
//        adminFunc_getsell();


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
                    int role_num = 0;
                    if (employee_info.getRole() == 1) {
                        role = "管理员";
                        role_num = 1;
//                        adminFunc(employee_info, role);
                    } else if (employee_info.getRole() == 2) {
                        role_num = 2;
                        role = "收银员";
//                        cashierFunc(employee_info, role);
                    } else if (employee_info.getRole() == 3) {
                        role_num = 3;
                        role = "采购员";
//                        buyerFunc(employee_info, role);
                    }
                    while (true) {
                        switch (role_num) {
                            case 1:
                                adminFunc(employee_info, role);
                                break;
                            case 2:
                                cashierFunc(employee_info, role);
                                break;
                            case 3:
                                buyerFunc(employee_info, role);
                                break;
                        }
                    }


//                    break;
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
        EmployeeService employeeService = new EmployeeServiceImpl();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Employee employee_info = null;

        while (flag) {
            System.out.println("==========当前页面:员工登录==========");
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
                        if (employee_info != null) {
                            flag = false;
                            break;
                        }else{
                            System.out.println("账号或密码错误！");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("账号或密码错误，请重新输入");
                }
            }
        }
        return employee_info;
    }

    public static void vipLogin() {
        VipService vipService = new VipServiceImpl();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Vip vip_info = null;
        //1.判断登录的账号密码
        //登录功能
        while (flag) {
            try {

                if (!flag) {

                    break;
                }
                while (flag) {

                    System.out.println("请输入您的账号:");
                    String v_number = sc.next();

                    vip_info = vipService.getVipNum(v_number);
//                        System.out.println(employee_info.toString());
                    if (vip_info != null) {
                        System.out.println("vip");
                        while (true) {
                            System.out.println("==========您好!尊贵的会员:" + vip_info.getV_name() + "==========");
                            System.out.println("==========查询会员积分请输入:1=========");
                            System.out.println("==========退出系统请输入:0=============");
                            int i = sc.nextInt();
                            switch (i) {
                                case 1:
                                    //查询积分
                                    vipFunc(vip_info);
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
//                        break;
                    } else {
                        System.out.println("会员信息获取失败,请重新获取!");
                        flag = false;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("账号或密码错误，请重新输入");
            }
        }

//        return vip_info;

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
        ClockService clockService = new ClockServiceImpl();
        Clock clock = new Clock();

        Boolean flag = true;
        while (flag) {
            System.out.println("==========欢迎您!" + employee_info.getUsername() + "(" + role + ")" + "==========");
            System.out.println("1.收银员管理");//完成
            System.out.println("2.采购员管理");//完成
            System.out.println("3.员工出勤管理");//完成
            System.out.println("4.查询超市营业额");//完成
            System.out.println("5.会员管理");//完成
            System.out.println("6.查询所有人信息");//完成
            System.out.println("7.上班打卡");//完成
            System.out.println("8.下班打卡");//完成
            System.out.println("0.退出系统");
            System.out.println("请选择功能:");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    adminFunc_cashier();
                    break;
                case 2:
                    adminFunc_buyer();
                    break;
                case 3:
//                    while (true) {
//                        System.out.println("==========当前页面:收银员管理==========");
//
//                    }
                    adminFunc_clock();
                    break;

                case 4:
                    adminFunc_getsell();
                    break;

                case 5:
                    adminFunc_vip();
                    break;

                case 6:
                    EmployeeService employee = new EmployeeServiceImpl();
                    VipService vip = new VipServiceImpl();
                    System.out.println("\n======================================");
                    System.out.println("Vip用户:");
                    vip.getVipAll();
                    System.out.println("\n======================================");
                    System.out.println("员工:");
                    employee.getEmployeesAll();
                    break;
                case 7:
                    clock.setEmployee_no(employee_info.getNumber());
                    clockService.addSalaryIn(clock);
                    break;
                case 8:
                    clock.setEmployee_no(employee_info.getNumber());
                    clockService.addSalaryOut(clock);
                    break;
                case 0:
                    System.exit(0);
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

        //会员积分查询
        VipService cashier_vip = new VipServiceImpl();
        Vip vip = new Vip();
        Scanner sc = new Scanner(System.in);
        //上下班打卡
        ClockService clockService = new ClockServiceImpl();
        Clock clock = new Clock();
        boolean flag = true;
        while (flag) {
            System.out.println("==========欢迎您！" + employee_info.getUsername() + "(" + role + ")" + "==========");
            System.out.println("1.收银结算");//完成
            System.out.println("2.会员积分查询");//完成
            System.out.println("3.开通会员");//完成
            System.out.println("4.上班打卡");//完成
            System.out.println("5.下班打卡");//完成
            System.out.println("0.退出系统");
            System.out.println("请选择功能:");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    cashierFunc_sell(employee_info);
                    break;
                case 2:
                    System.out.println("请输入您的账号:");
                    String v_number = sc.next();
                    Vip vip_info = cashier_vip.getVipNum(v_number);
                    System.out.println("此会员的积分:" + vip_info.getV_score());
                    break;
                case 3:
                    Func_addVip();
                    break;
                case 4:
                    clock.setEmployee_no(employee_info.getNumber());
                    clockService.addSalaryIn(clock);
                    break;
                case 5:
                    clock.setEmployee_no(employee_info.getNumber());
                    clockService.addSalaryOut(clock);
                    break;
                case 0:
//                    flag = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
                    break;
            }
        }
    }

    public static void buyerFunc(Employee employee_info, String role) {
        //1.判断账户
        //1.进行商品补货:获取低于某值的商品信息,并进行修改
        //2.查询进货信息
        //3.上下班打卡
        ClockService clockService = new ClockServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        Clock clock = new Clock();
        boolean flag = true;
        while (flag) {
            System.out.println("==========欢迎您！" + employee_info.getUsername() + "(" + role + ")" + "==========");
            System.out.println("1.查询进货单");
            System.out.println("2.商品补货");
            System.out.println("3.查询所有商品信息");
            System.out.println("4.上班打卡");
            System.out.println("5.下班打卡");
            System.out.println("0.退出系统");
            System.out.println("请选择功能:");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    System.out.println("请输入货物数量低于（低于此值为需要进货的货物）：");
                    int inventory = sc.nextInt();
                    System.out.println("商品编号\t\t\t商品名\t\t\t库存");
                    List<Goods> lowGoods = goodsService.getLowGoods(inventory);
                    for (Goods lowGood : lowGoods) {
                        System.out.println(lowGood.getC_number()+"\t\t\t"
                                +lowGood.getC_name()+"\t\t\t"
                                +lowGood.getInventory());
                    }
                    break;
                case 2:
                    System.out.println("请输入需要进货的货号：");
                    int goods_number = sc.nextInt();
                    Goods goods = goodsService.getGoodsName(goods_number);
                    System.out.println("请输入需要进货的数量：");
                    int goods_add_inventory = sc.nextInt();
                    int inventory_num = goods.getInventory();
                    int sum = goods_add_inventory+inventory_num;
                    Goods add_goods = new Goods(goods.getC_number(), goods.getC_name(), goods.getC_price(), goods.getVip_price(),sum);
                    goodsService.addGoods(add_goods);
                    break;
                case 3:
                    goodsService.getGoodsAll();
                    break;
                case 4:
                    clock.setEmployee_no(employee_info.getNumber());
                    clockService.addSalaryIn(clock);
                    break;
                case 5:
                    clock.setEmployee_no(employee_info.getNumber());
                    clockService.addSalaryOut(clock);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
                    break;
            }
        }
    }

    public static void vipFunc(Vip vip_info) {
        //会员功能：查询积分
        System.out.println("您的积分:" + vip_info.getV_score());
    }


    public static void adminFunc_cashier() {
        EmployeeService admin_cashier = new EmployeeServiceImpl();
        Employee cashier = new Employee();
        Boolean flag = true;
        while (flag) {
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
//                    System.out.println(admin_cashier.getEmployeesAll());
                    break;
                case 2:
                    //删除收银员
                    System.out.println("请输入需要删除的编号");
                    String num1 = sc.next();
//                    System.out.println("你确定要删除吗?输入是|否:");
//                    String isDelete = sc.next();
//                    if(isDelete.equals("是")){
//                     admin_cashier.removeEmployee(cashier);
//                    }
                    admin_cashier.removeEmployee(num1);
//                    System.out.println(admin_cashier.getEmployeesAll());
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
                    admin_cashier.updateEmployee(num, cashier);
//                    System.out.println(admin_cashier.getEmployeesAll());
                    break;
                case 4:
                    //查询收银员
                    System.out.println("请输入需要查询的收银员编号");
                    String num2 = sc.next();
                    Employee cashier_ser = admin_cashier.getEmployeeNum(num2);
                    try {
                        System.out.println("姓名:" + cashier_ser.getUsername() +
                                "\n密码:" + cashier_ser.getPassword() +
                                "\n性别:" + cashier_ser.getSex() +
                                "\n手机:" + cashier_ser.getPhone() +
                                "\n状态:" + cashier_ser.getRemark());
                    } catch (NullPointerException e) {
//                        throw new RuntimeException(e);
                        System.out.println("收银员离职或不存在!");
                    }
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
                    break;
            }
        }
    }

    public static void adminFunc_buyer() {
        EmployeeService admin_buyer = new EmployeeServiceImpl();
        Employee buyer = new Employee();
        Boolean flag = true;
        while (flag) {
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
                    //增加采购员
                    //角色默认为3
                    buyer.setRole(3);
                    System.out.println("请输入采购员编号");
                    buyer.setNumber(sc.next());
                    System.out.println("请输入采购员姓名");
                    buyer.setUsername(sc.next());
                    System.out.println("请输入采购员密码");
                    buyer.setPassword(sc.next());
                    System.out.println("请输入采购员性别");
                    buyer.setSex(sc.next());
                    System.out.println("请输入采购员手机");
                    buyer.setPhone(sc.next());
                    System.out.println("请输入备注");
                    buyer.setRemark(sc.nextInt());
                    System.out.println(buyer);
                    //向数据库发送数据
                    admin_buyer.addEmployee(buyer);
//                    System.out.println(admin_buyer.getEmployeesAll());
                    for (Employee employee : admin_buyer.getEmployeesAll()) {
                        System.out.println("所有人数据:" + employee);
                    }
                    break;
                case 2:
                    //删除采购员
                    System.out.println("请输入需要删除的编号");
                    String num1 = sc.next();
//                    System.out.println("你确定要删除吗?输入是|否:");
//                    String isDelete = sc.next();
//                    if(isDelete.equals("是")){
//                     admin_cashier.removeEmployee(cashier);
//                    }
                    admin_buyer.removeEmployee(num1);
//                    System.out.println(admin_buyer.getEmployeesAll());
                    for (Employee employee : admin_buyer.getEmployeesAll()) {
                        System.out.println("所有人数据:" + employee);
                    }
                    break;
                case 3:
                    //修改采购员
                    buyer.setRole(3);
                    System.out.println("请输入需要修改的采购员编号");
                    String num = sc.next();
                    System.out.println("请输入新的采购员姓名");
                    buyer.setUsername(sc.next());
                    System.out.println("请输入新的采购员密码");
                    buyer.setPassword(sc.next());
                    System.out.println("请输入新的采购员性别");
                    buyer.setSex(sc.next());
                    System.out.println("请输入新的采购员手机");
                    buyer.setPhone(sc.next());
                    System.out.println("请输入备注");
                    buyer.setRemark(sc.nextInt());
                    System.out.println(buyer);
                    //向数据库发送数据
                    admin_buyer.updateEmployee(num, buyer);
//                    System.out.println(admin_buyer.getEmployeesAll());
                    for (Employee employee : admin_buyer.getEmployeesAll()) {
                        System.out.println("所有人数据:" + employee);
                    }
                    break;
                case 4:
                    //查询采购员
                    System.out.println("请输入需要查询的采购员编号");
                    String num2 = sc.next();
                    Employee buyer_ser = admin_buyer.getEmployeeNum(num2);
                    System.out.println("姓名:" + buyer_ser.getUsername() +
                            "\n密码:" + buyer_ser.getPassword() +
                            "\n性别:" + buyer_ser.getSex() +
                            "\n手机:" + buyer_ser.getPhone() +
                            "\n状态:" + buyer_ser.getRemark());
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
                    break;
            }
        }
    }

    public static void adminFunc_vip() {
        VipService admin_vip = new VipServiceImpl();
        Vip vip = new Vip();
        Boolean flag = true;
        while (flag) {
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
                    //增加会员
//                    System.out.println("请输入会员编号:");
//                    vip.setV_number(sc.next());
//                    System.out.println("请输入会员姓名:");
//                    vip.setV_name(sc.next());
//                    System.out.println("请输入会员手机:");
//                    vip.setV_phone(sc.next());
////                    System.out.println("请输入时间(年-月(两位数)-日(两位数)):");
////                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////                    try {
////                        vip.setV_date(sdf.parse(sc.next()));
////                    } catch (ParseException e) {
////                        System.out.println("时间格式错误!");
////                    }
//                    //自动获取会员创建时的时间
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                    String time = LocalDateTime.now().format(dtf);
//                    try {
//                        vip.setV_date(sdf.parse(time));
//                    } catch (ParseException e) {
//                        throw new RuntimeException(e);
//                    }
//                    //可优化UI显示
//                    System.out.println(vip);
//                    //向数据库发送数据
//                    admin_vip.addVip(vip);
////                    System.out.println(admin_buyer.getEmployeesAll());
//                    for (Vip vip_info : admin_vip.getVipAll()) {
//                        //可优化UI显示
//                        System.out.println("所有人数据:" + vip_info);
//                    }
                    Func_addVip();
                    break;
                case 2:
                    //删除会员
                    System.out.println("请输入需要删除的会员编号");
                    String num1 = sc.next();
//                    System.out.println("你确定要删除吗?输入是|否:");
//                    String isDelete = sc.next();
//                    if(isDelete.equals("是")){
//                     admin_cashier.removeEmployee(cashier);
//                    }
                    admin_vip.removeVip(num1);
//                    System.out.println(admin_buyer.getEmployeesAll());
                    for (Vip vip_info : admin_vip.getVipAll()) {
//                        System.out.println("所有人数据:" + vip_info);
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    //修改会员
//                    buyer.setRole(3);
                    System.out.println("请输入需要修改的会员编号");
                    String num = sc.next();
                    System.out.println("请输入新的会员姓名");
                    vip.setV_name(sc.next());
//                    System.out.println("请输入新的会员密码");
//                    buyer.setPassword(sc.next());
//                    System.out.println("请输入新的会员性别");
//                    buyer.setSex(sc.next());
                    System.out.println("请输入新的会员手机");
                    vip.setV_phone(sc.next());
//                    System.out.println("请输入备注");
//                    buyer.setRemark(sc.nextInt());
                    System.out.println(vip);
                    //向数据库发送数据
                    admin_vip.updateVip(num, vip);
//                    System.out.println(admin_buyer.getEmployeesAll());
                    for (Vip vip_info : admin_vip.getVipAll()) {
//                        System.out.println("所有人数据:" + vip_info);
                        System.out.println(" ");

                    }
                    break;
                case 4:
                    //查询会员
                    System.out.println("请输入需要查询的会员编号");
                    String num2 = sc.next();
                    Vip vip_ser = admin_vip.getVipNum(num2);
                    System.out.println("姓名:" + vip_ser.getV_name() +
                            "\n积分:" + vip_ser.getV_score() +
                            "\n手机:" + vip_ser.getV_phone() +
                            "\n注册日期:" + vip_ser.getV_date());
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
                    break;
            }
        }


    }

    public static void adminFunc_clock() {
//                        System.out.println("==========当前页面:收银员管理==========");
        EmployeeService employeeService = new EmployeeServiceImpl();
        ClockService clockService = new ClockServiceImpl();
        boolean flag = true;
        while (flag) {
            System.out.println("==========当前页面:员工出勤管理==========");
            System.out.println("1.查看今日考勤");
            System.out.println("2.查看全部考勤");
            System.out.println("0.退出此页面");
            System.out.println("请输入选项:");
            int i1 = sc.nextInt();
            switch (i1) {
                case 1:
                    clockService.getSalaryToday();
                    break;
                case 2:
//                    employeeService.getSalaryAll();
//                    List<Clock> salaryAll = clockService.getSalaryAll();
                    clockService.getSalaryAll();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
                    break;
            }
        }
    }

    public static void adminFunc_getsell() {
        SellService sellService = new SellServiceImpl();
        SellGoodsService sellGoodsService = new SellGoodsServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        boolean flag = true;
        while (flag) {
            System.out.println("==========当前页面:查询超市营业额==========");
            System.out.println("1.查看超市所有销售信息");
            System.out.println("2.查看超市指定日期的销售信息");
            System.out.println("3.查看超市指定日期范围的营业额");
            System.out.println("0.退出此页面");
            System.out.println("请输入选项:");
            int i1 = sc.nextInt();
            switch (i1) {
                case 1:
                    List<Sell> sells = sellService.getAllSell();
                    System.out.println("货名\t\t\t\t销售量\t\t\t\t销售时间\t\t\t\t收银员\t\t\t\tVIP编号");
                    for (Sell sell_info1 : sells) {
                        //通过获取到的员工号获取员工名
                        Employee employee = null;
                        try {
                            employee = employeeService.getEmployeeSellNum(sell_info1.getS_e_number());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
//                        System.out.println(employee);
                        //通过获取到的货号获取货名
//                        System.out.println(sell_info1.getS_c_number());
                        Goods goods = goodsService.getGoodsName(sell_info1.getS_c_number());
                        //LocalDateTime 去T
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String time = sell_info1.getS_time().format(dtf);
//                        System.out.println(employee);//test

                        System.out.println(goods.getC_name() + "\t\t\t"
                                + sell_info1.getS_quantity() + "\t\t\t"
                                + time + "\t\t\t"
                                + employee.getUsername() + "\t\t\t"
                                + sell_info1.getS_vip_number());
                    }

                    break;
                case 2:
                    boolean flag1 = false;
                    Date date = null;
                    String input = null;
                    while (!flag1) {
                        System.out.print("请输入日期（格式为yyyy-MM-dd）：");
                        input = sc.next();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            date = sdf.parse(input);
                            flag1 = true;
                        } catch (Exception e) {
                            System.out.println("输入的日期格式不正确，请重新输入。");
//                            e.printStackTrace();
                        }
                    }
                    // 查询符合该日期格式的时间范围
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String startDateString = input + " 00:00:00";
                    String endDateString = input + " 23:59:59";

                    try {
                        Date startDate = sdf2.parse(startDateString);
                        Date endDate = sdf2.parse(endDateString);
                        System.out.println(startDate);
                        System.out.println(endDate);
//                        System.out.println("符合该日期格式的时间范围：");
//                        System.out.println(sdf2.format(startDate) + " 至 " + sdf2.format(endDate));
                        List<Sell> sell_info = sellService.getDaySell(startDate, endDate);
                        for (Sell sell : sell_info) {
                            //通过获取到的员工号获取员工名
                            Employee employee = employeeService.getEmployeeSellNum(sell.getS_e_number());
                            //通过获取到的货号获取货名
                            Goods goods = goodsService.getGoodsName(sell.getS_c_number());
                            //LocalDateTime 去T
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String time = sell.getS_time().format(dtf);

                            System.out.println(goods.getC_name() + "\t\t\t"
                                    + sell.getS_quantity() + "\t\t\t"
                                    + time + "\t\t\t"
                                    + employee.getUsername() + "\t\t\t"
                                    + sell.getS_vip_number());
                        }

                    } catch (Exception e) {
                        System.out.println("时间范围出现错误。");
                    }

                    break;
                case 3:
                    boolean flag2 = false;
                    Date date1 = null;
                    Date date2 = null;
                    String input1 = null;
                    String input2 = null;
                    while (!flag2) {
                        System.out.print("请输入开始日期（格式为yyyy-MM-dd）：");
                        input1 = sc.next();
                        System.out.print("请输入结束日期（格式为yyyy-MM-dd）：");
                        input2 = sc.next();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            date1 = sdf.parse(input1);
                            date2 = sdf.parse(input2);
                            flag2 = true;
                        } catch (Exception e) {
                            System.out.println("输入的日期格式不正确，请重新输入。");
                        }
                    }
                    // 查询符合该日期格式的时间范围
                    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String startDateString1 = input1 + " 00:00:00";
                    String endDateString1 = input2 + " 23:59:59";

                    try {
                        Date startDate = sdf3.parse(startDateString1);
                        Date endDate = sdf3.parse(endDateString1);
                        System.out.println(startDate);
                        System.out.println(endDate);
//                        System.out.println("符合该日期格式的时间范围：");
//                        System.out.println(sdf2.format(startDate) + " 至 " + sdf2.format(endDate));
                        List<Sell> sell_info = sellService.getDaySell(startDate, endDate);
                        for (Sell sell : sell_info) {
                            //通过获取到的员工号获取员工名
                            Employee employee = employeeService.getEmployeeSellNum(sell.getS_e_number());
                            //通过获取到的货号获取货名
                            Goods goods = goodsService.getGoodsName(sell.getS_c_number());
                            //LocalDateTime 去T
//                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String time = sell.getS_time().format(dtf);

                            System.out.println(goods.getC_name() + "\t\t\t"
                                    + sell.getS_quantity() + "\t\t\t"
                                    + time + "\t\t\t"
                                    + employee.getUsername() + "\t\t\t"
                                    + sell.getS_vip_number());
                        }

                    } catch (Exception e) {
                        System.out.println("时间范围出现错误。");
                    }

                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("您的输入有误,请重新输入!");
                    break;
            }
        }
    }

    public static void cashierFunc_sell(Employee employee_info) {
        //接口
        VipService vipService = new VipServiceImpl();
        GoodsService goodsService = new GoodsServiceImpl();
        SellService sellService = new SellServiceImpl();
        SellGoodsService sellGoodsService = new SellGoodsServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        //所需容器
        Vip vip = null;
        String vip_num = null;
        List<Goods> goods_info = new ArrayList<>();
        List<Integer> goods_in = new ArrayList<>();
        int num = 0;
        //是否为vip标志
        boolean vip_flag = false;

        //获取商品信息及是否为会员循环
        boolean flag = true;
        while (flag) {
            System.out.println("正在获取商品列表......");
            goodsService.getGoodsAll();
            System.out.println("是否使用会员卡(Y/N)");
            String i = sc.next();
            String sw = null;//会员卡判断标志
            if (i.equals("y") || i.equals("Y")) {
                sw = "1";//使用会员卡
            }
            if (i.equals("n") || i.equals("N")) {
                sw = "2";
            }
            if (sw != null) {
                boolean w = true;//循环标志
                while (w) {
                    switch (sw) {
                        case "1":
                            System.out.println("请输入卡号：");
                            vip_num = sc.next();
                            vip = vipService.getVipNum(vip_num);
                            if (vip != null) {
                                vip_flag = true;
                                w = false;
                            } else {
                                System.out.println("输入错误，请重新输入！");
                                break;
                            }
                            break;
                        case "2":
                            System.out.println("不使用VIP卡进行购物！");
                            w = false;
                            break;
                    }
                }
                //循环结束标志
                if (w == false) {
                    flag = false;
                }
            }
        }
        //购买循环
        boolean buy_flag = true;
        while (buy_flag) {
            try {
                Goods goods = null;
                boolean buy_flag1 = true;
                while (buy_flag1) {
                    System.out.println("请输入商品编号:");
                    num = sc.nextInt();
                    goods = goodsService.getGoodsName(num);
                    if (goods == null) {
                        System.out.println("商品编号输入错误！");
                        break;
                    } else {
                        goods_info.add(goods);
                    }
                    int n = 0;
                    while (n == 0) {
                        System.out.println("请输入购买数量");
                        int buy_num = sc.nextInt();
                        if (buy_num >= goods.getInventory()) {
                            System.out.println("超出库存！当前库存:" + goods.getInventory() + " 请重新输入：");
                            n = 0;
                        } else {
                            goods_in.add(buy_num);
                            n = 1;
                        }
                    }
                    System.out.println("1.继续购物\t2.结账");
                    int end = sc.nextInt();
                    if (end == 2) {
                        buy_flag1 = false;
                    }
                }
//                System.out.println("结账位置");
                //内层循环结束标志
                if (buy_flag1 == false) {
                    //外层循环结束标志
                    buy_flag = false;
                }
            } catch (Exception e) {
                System.out.println("输入错误，请重新选择");
            }
        }
        //
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sell_time = null;
        try {
            sell_time = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //账单打印
        System.out.println("\t\t\t\t\t\t账单");
        System.out.println("打印时间:"+sdf.format(date)+"\t收银员:"+employee_info.getUsername());
        System.out.println("商品号\t\t\t商品名\t\t\t购买数量\t\t\t购买价格");
        List<Double> bill_list = new ArrayList<>();
        Double bill_total_price = new Double("0");
        for (int i = 0; i < goods_info.size(); i++) {
            Double bill_price = null;
            if(vip_flag == true){
                bill_price = (goods_info.get(i).getVip_price())*goods_in.get(i);
//                System.out.println("bill_Vip_price:"+bill_price);
            }else{
                bill_price = (goods_info.get(i).getC_price())*goods_in.get(i);
//                System.out.println("bill_price:"+bill_price);
            }
            System.out.println(goods_info.get(i).getC_number()+"\t\t"
                    + goods_info.get(i).getC_name()+"\t\t"
                    + goods_in.get(i)+"\t\t"
                    + bill_price);
            bill_list.add(bill_price);
            //输入销售信息
            if (vip_flag == true) {
                sellService.addSell(goods_info.get(i).getC_number(),goods_in.get(i),sell_time, employee_info.getNumber(),vip.getV_number());
            } else {
                sellService.addSell(goods_info.get(i).getC_number(),goods_in.get(i),sell_time, employee_info.getNumber(),null);
            }
        }
        for (int i = 0; i < bill_list.size(); i++) {
            bill_total_price += bill_list.get(i);
        }
        System.out.println("总价:"+bill_total_price);
    }

    public static void Func_addVip(){
        VipService vipService = new VipServiceImpl();
        Vip vip = null;
        System.out.println("请输入要增加的vip的名字");
        String vip_name = sc.next();
        System.out.println("请输入要增加的vip的手机号");
        String vip_phone = sc.next();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("现有会员信息:");
        //设置vip编号格式
        List<Vip> vips = vipService.getVipAll();
        String vip_num_origin = vips.get(vips.size()-1).getV_number();
        String vip_last_num = vip_num_origin.substring(11);
//        System.out.println(vip_last_num);
        //vip编号自增
        int num = Integer.parseInt(vip_last_num);
        num++;
//        System.out.println(num);
        String new_last_num =String.format("%04d",num);
        Date vip_set_date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        String vip_num_day = sdf1.format(vip_set_date);
//        System.out.println(vip_num_day);
//        System.out.println(new_last_num);
        String vip_num = "vip"+vip_num_day+new_last_num;
        try {
            vip = new Vip(vip_num,vip_name,0,vip_phone,sdf.parse(sdf.format(date)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("要添加的会员的信息："+"VIP编号:"+vip.getV_number()+
                "\tVIP名称:"+ vip.getV_name()+
                "\tVIP积分:"+ vip.getV_score()+
                "\tVIP手机号:"+ vip.getV_phone()+
                "\tVIP注册日期:"+ vip.getV_date());
        vipService.addVip(vip);

    }

}



