package com.supermarket.dao.impl;

import com.supermarket.dao.EmployeeDao;
import com.supermarket.entity.Employee;
import com.supermarket.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employee(number,username,password,sex,phone,role,remark)values(?,?,?,?,?,?,?)";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,employee.getNumber(),employee.getUsername(),employee.getPassword(),employee.getSex(),employee.getPhone(), employee.getRole(),1);
            System.out.println("插入成功...");
        } catch (SQLException e) {
            System.out.println("插入失败...");
        }

    }
//    @Override
//    public void addVip(Vip vip) {
//
//        String sql = "INSERT INTO vip(v_number,v_name,v_phone,v_date)values(?,?,?,?)";
//        //创建runner对象
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//        try {
//            qr.update(sql,vip.getV_number(),vip.getV_name(),vip.getV_score(),vip.getV_phone(),vip.getV_date());
//            System.out.println("插入成功...");
//        } catch (SQLException e) {
//            System.out.println("插入失败...");
//        }
//
//    }

    @Override
    public void updateEmployee(String employee_num, Employee employee) {
        String sql = "update employee set username=?,password=?,sex=?,phone=?,role=?,remark=? where number=?";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,employee.getUsername(),employee.getPassword(),employee.getSex(),employee.getPhone(), employee.getRole(), employee.getRemark(),employee_num);
            System.out.println("修改成功...");
        } catch (SQLException e) {
            System.out.println("修改失败...");
        }
    }
//@Override
//    public void updateVip(String v_number, Vip vip) {
//        String sql = "update vip set v_name=?,v_score=?,v_phone=?,v_date=? where v_number=?";
//        //创建runner对象
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//        try {
//            qr.update(sql,vip.getV_name(),vip.getV_score(),vip.getV_phone(), vip.getV_date(),v_number);
//            System.out.println("修改成功...");
//        } catch (SQLException e) {
//            System.out.println("修改失败...");
//        }
//    }

    @Override
    public void removeEmployee(String employee_num) {
//        String sql = "delete from employee where number=?";
//
//        JDBCUtil.update(sql, employee_num);
//        String sql = "delete from employee where number=?";
        String sql = "update employee set remark =0 where number=?";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,employee_num);
            System.out.println("删除成功...");
        } catch (SQLException e) {
            System.out.println("删除失败...");
        }
    }
//    @Override
//    public void removeVip(String v_number) {
////        String sql = "delete from employee where number=?";
////
////        JDBCUtil.update(sql, employee_num);
//        String sql = "delete from vip where v_number=?";
//        //创建runner对象
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//        try {
//            qr.update(sql,v_number);
//            System.out.println("删除成功...");
//        } catch (SQLException e) {
//            System.out.println("删除失败...");
//        }
//    }
    //查询员工编号
//    @Override
//    public Vip getVipNum(String v_number) {
//        //查询
//        String sql ="SELECT*FROM vip WHERE v_number=?";
//
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//        //封装
//        ResultSetHandler<Vip> rsh = new BeanHandler<>(Vip.class);
//        Vip vip = null;
//        try {
//            vip = qr.query(sql,rsh,v_number);
//
//        } catch (SQLException e) {
//            System.out.println("查询失败！");
//        }catch (NullPointerException e){
//            System.out.println("不存在此会员!");
//        }
//        return vip;
//    }
@Override
    public Employee getEmployeeNum(String employee_num) {
        //查询
        String sql ="SELECT*FROM employee WHERE number=? and remark =1";

        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        //封装
        ResultSetHandler<Employee> rsh = new BeanHandler<>(Employee.class);
        Employee employee = null;
        try {
            employee = qr.query(sql,rsh,employee_num);

        } catch (SQLException e) {
            System.out.println("查询失败！");
        }catch (NullPointerException e){
            System.out.println("不存在此员工!");
            employee.setUsername("空");
        }
        return employee;

    }
    @Override
    public Employee getEmployeeSellNum(String employee_num) {
        //查询
        String sql ="SELECT*FROM employee WHERE number=?";

        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        //封装
        ResultSetHandler<Employee> rsh = new BeanHandler<>(Employee.class);
        Employee employee = null;
        try {
            employee = qr.query(sql,rsh,employee_num);

        } catch (SQLException e) {
            System.out.println("查询失败！");
        }catch (NullPointerException e){
            System.out.println("不存在此员工!");
            employee.setUsername("空");
        }
        return employee;

    }
//    @Override
//    public Employee getEmployeeName(String employee_num) {
//        //查询
//        String sql ="SELECT*FROM employee WHERE number=?";
//
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//        //封装
//        ResultSetHandler<Employee> rsh = new BeanHandler<>(Employee.class);
//        Employee employee = null;
//        try {
//            employee = qr.query(sql,rsh,employee_num);
//
//        } catch (SQLException e) {
//            System.out.println("查询失败！");
//        }catch (NullPointerException e){
//            System.out.println("不存在此员工!");
//        }
//        return employee;
//
//    }



    //查询账号和密码
    @Override
    public Employee getEmployeeNumNamePsw(String employee_num, String employee_password) {
        String sql ="SELECT*FROM employee WHERE number=? and password=? and remark =1";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        ResultSetHandler<Employee> rsh = new BeanHandler<>(Employee.class);
        Employee employees = null;
        try {
            employees = qr.query(sql,rsh,employee_num,employee_password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
    //查询所有人
    @Override
    public List<Employee> getEmployeesAll() {

        String sql = "select * from employee where remark =1";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        ResultSetHandler<List<Employee>> rh = new BeanListHandler<>(Employee.class);
        List<Employee> employees = null;
        try {
            employees = qr.query(sql,rh);
//            for (Employee employee : employees) {
//                //循环形式输出
//                System.out.println(employee);
//            }
        }catch (Exception e) {
            System.out.println("查询失败");
        }
//        return employees;
        return employees.stream()
                .peek(employee -> System.out.println("员工号:"+employee.getNumber()+
                        "\t员工名:"+ employee.getUsername()+
                        "\t员工密码:"+ employee.getPassword()+
                        "\t员工性别:"+ employee.getSex()+
                        "\t员工手机:"+ employee.getPhone()+
                        "\t员工职位:"+employee.getRole()+
                        "\t员工就职状态:"+ employee.getRemark())) // 在遍历过程中打印员工信息
                .collect(Collectors.toList()); // 收集并返回修改后的集合
    }
//    @Override
//    public List<Clock> getSalaryAll() {
//        //后期需要联合上下班打卡状态
//        String sql = "select * from clock_info";
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//
//        ResultSetHandler<List<Clock>> rh = new BeanListHandler<>(Clock.class);
////        List<String> salary_info = new ArrayList<>();
//
//        List<Clock> clock_info = null;
//        try {
//            clock_info = qr.query(sql,rh);
////            for (Employee employee : employees) {
////                //循环形式输出
////                System.out.println(employee);
////            }
//        }catch (Exception e) {
//            System.out.println("查询失败");
//        }
////        return employees;
//        return clock_info;
////                .stream()
////                .peek(employee -> System.out.println(employee)) // 在遍历过程中打印员工信息
////                .collect(Collectors.toList()); // 收集并返回修改后的集合
//    }

//    @Override
//    public List<Vip> getVipAll() {
//
//        String sql = "select * from vip";
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//        ResultSetHandler<List<Vip>> rh = new BeanListHandler<>(Vip.class);
//        List<Vip> vips = null;
//        try {
//            vips = qr.query(sql,rh);
////            for (Employee employee : employees) {
////                //循环形式输出
////                System.out.println(employee);
////            }
//        }catch (Exception e) {
//            System.out.println("查询失败");
//        }
////        return employees;
//        return vips.stream()
//                .peek(vip -> System.out.println(vip)) // 在遍历过程中打印员工信息
//                .collect(Collectors.toList()); // 收集并返回修改后的集合
//    }
}
