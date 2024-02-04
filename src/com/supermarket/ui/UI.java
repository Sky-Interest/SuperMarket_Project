package com.supermarket.ui;

import com.supermarket.dao.impl.GoodsDaoImpl;
import com.supermarket.entity.Clock;
import com.supermarket.entity.Employee;
import com.supermarket.entity.Vip;
import com.supermarket.service.ClockService;
import com.supermarket.service.EmployeeService;
import com.supermarket.service.GoodsService;
import com.supermarket.service.VipService;
import com.supermarket.service.impl.ClockServiceImpl;
import com.supermarket.service.impl.EmployeeServiceImpl;
import com.supermarket.service.impl.GoodsServiceImpl;
import com.supermarket.service.impl.VipServiceImpl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
                    int role_num =0;
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
//                        System.out.println(employee_info.toString());
                        if (employee_info != null) {
                            flag = false;
                            break;
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
                            System.out.println("==========您好!尊贵的会员:"+vip_info.getV_name()+"==========");
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
                    }else{
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
            System.out.println("==========欢迎您!"+employee_info.getUsername()+"("+role+")"+"==========");
            System.out.println("1.收银员管理");//完成
            System.out.println("2.采购员管理");//完成
            System.out.println("3.员工出勤管理");//完成
            System.out.println("4.查询超市营业额");
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
//                    flag = false;
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
            System.out.println("1.收银结算");
            System.out.println("2.会员积分查询");//完成
            System.out.println("3.开通会员");//完成
            System.out.println("4.上班打卡");//完成
            System.out.println("5.下班打卡");//完成
            System.out.println("0.退出系统");
            System.out.println("请选择功能:");
            int i = sc.nextInt();
            switch (i){
                case 1:

                    break;
                case 2:
                    System.out.println("请输入您的账号:");
                    String v_number = sc.next();
                    Vip vip_info = cashier_vip.getVipNum(v_number);
                    System.out.println("此会员的积分:"+vip_info.getV_score());
                    break;
                case 3:
                    //增加会员
                    System.out.println("请输入会员编号:");
                    vip.setV_number(sc.next());
                    System.out.println("请输入会员姓名:");
                    vip.setV_name(sc.next());
                    System.out.println("请输入会员手机:");
                    vip.setV_phone(sc.next());
                    //自动获取会员创建时的时间
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String time = LocalDateTime.now().format(dtf);
                    try {
                        vip.setV_date(sdf.parse(time));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    //可优化UI显示
                    System.out.println(vip);
                    //向数据库发送数据
                    cashier_vip.addVip(vip);
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
//        System.out.println(employee_info);
        ClockService clockService = new ClockServiceImpl();
        Clock clock = new Clock();
        boolean flag = true;
        while (flag) {
            System.out.println("==========欢迎您！" + employee_info.getUsername() + "(" + role + ")" + "==========");
            System.out.println("1.收银结算");
            System.out.println("2.会员积分查询");
            System.out.println("3.开通会员");
            System.out.println("4.上班打卡");
            System.out.println("5.下班打卡");
            System.out.println("0.退出系统");
            System.out.println("请选择功能:");
            int i = sc.nextInt();
            switch (i){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
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

    public static void vipFunc(Vip vip_info) {
        //会员功能：查询积分
        System.out.println("您的积分:"+ vip_info.getV_score());
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
                    String num1 =sc.next();
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
                    admin_cashier.updateEmployee(num,cashier);
//                    System.out.println(admin_cashier.getEmployeesAll());
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
                        System.out.println("所有人数据:"+employee);
                    }
                    break;
                case 2:
                    //删除采购员
                    System.out.println("请输入需要删除的编号");
                    String num1 =sc.next();
//                    System.out.println("你确定要删除吗?输入是|否:");
//                    String isDelete = sc.next();
//                    if(isDelete.equals("是")){
//                     admin_cashier.removeEmployee(cashier);
//                    }
                    admin_buyer.removeEmployee(num1);
//                    System.out.println(admin_buyer.getEmployeesAll());
                    for (Employee employee : admin_buyer.getEmployeesAll()) {
                        System.out.println("所有人数据:"+employee);
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
                    admin_buyer.updateEmployee(num,buyer);
//                    System.out.println(admin_buyer.getEmployeesAll());
                    for (Employee employee : admin_buyer.getEmployeesAll()) {
                        System.out.println("所有人数据:"+employee);
                    }
                    break;
                case 4:
                    //查询采购员
                    System.out.println("请输入需要查询的采购员编号");
                    String num2 = sc.next();
                    Employee buyer_ser = admin_buyer.getEmployeeNum(num2);
                    System.out.println("姓名:"+buyer_ser.getUsername() +
                            "\n密码:"+ buyer_ser.getPassword()+
                            "\n性别:"+ buyer_ser.getSex()+
                            "\n手机:"+ buyer_ser.getPhone()+
                            "\n状态:"+ buyer_ser.getRemark());
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
                    System.out.println("请输入会员编号:");
                    vip.setV_number(sc.next());
                    System.out.println("请输入会员姓名:");
                    vip.setV_name(sc.next());
                    System.out.println("请输入会员手机:");
                    vip.setV_phone(sc.next());
//                    System.out.println("请输入时间(年-月(两位数)-日(两位数)):");
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                    try {
//                        vip.setV_date(sdf.parse(sc.next()));
//                    } catch (ParseException e) {
//                        System.out.println("时间格式错误!");
//                    }
                    //自动获取会员创建时的时间
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String time = LocalDateTime.now().format(dtf);
                    try {
                        vip.setV_date(sdf.parse(time));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    //可优化UI显示
                    System.out.println(vip);
                    //向数据库发送数据
                    admin_vip.addVip(vip);
//                    System.out.println(admin_buyer.getEmployeesAll());
                    for (Vip vip_info : admin_vip.getVipAll()) {
                        //可优化UI显示
                        System.out.println("所有人数据:"+vip_info);
                    }
                    break;
                case 2:
                    //删除会员
                    System.out.println("请输入需要删除的会员编号");
                    String num1 =sc.next();
//                    System.out.println("你确定要删除吗?输入是|否:");
//                    String isDelete = sc.next();
//                    if(isDelete.equals("是")){
//                     admin_cashier.removeEmployee(cashier);
//                    }
                    admin_vip.removeVip(num1);
//                    System.out.println(admin_buyer.getEmployeesAll());
                    for (Vip vip_info : admin_vip.getVipAll()) {
                        System.out.println("所有人数据:"+vip_info);
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
                        System.out.println("所有人数据:"+vip_info);
                    }
                    break;
                case 4:
                    //查询会员
                    System.out.println("请输入需要查询的会员编号");
                    String num2 = sc.next();
                    Vip vip_ser = admin_vip.getVipNum(num2);
                    System.out.println("姓名:"+vip_ser.getV_name() +
                            "\n积分:"+ vip_ser.getV_score()+
                            "\n手机:"+ vip_ser.getV_phone()+
                            "\n注册日期:"+ vip_ser.getV_date());
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

    public static void adminFunc_clock(){
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

}
