package com.supermarket.dao.impl;

import com.supermarket.dao.ClockDao;
import com.supermarket.entity.Clock;
import com.supermarket.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ClockDaoImpl implements ClockDao {
    EmployeeDaoImpl employee = new EmployeeDaoImpl();
    @Override
    public List<Clock> getSalaryAll() {
//        String sql = "select * from clock_info";
//        String sql = "select clock_info.clock_id,clock_info.employee_no,employee.username,clock_info.clock_in_time,clock_info.clock_off_time from clock_info " +
//                "left join employee on clock_info.employee_no=employee.number";
        String sql = "select work_date,employee_no,username,clock_in_time,clock_off_time,diff_in_status,diff_off_time from check_info "+
                    "left join employee on check_info.employee_no=employee.number ";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);

        ResultSetHandler<List<Clock>> rh = new BeanListHandler<>(Clock.class);
//        List<String> salary_info = new ArrayList<>();

        List<Clock> clock_info = null;


        try {
            clock_info = qr.query(sql,rh);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("工作日期\t\t"+"员工编号\t\t"+"员工姓名\t\t"+"上班时间\t\t"+"下班时间\t\t"+"上班状态\t\t"+"下班状态");
        for (Clock clock: clock_info) {
            //转化变量
            LocalDateTime clock_in_time;
            LocalDateTime clock_off_time;
            String cit = null;
            String cot = null;
            //时间格式转化判断
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            if(clock.getClock_in_time()!=null) {
                // 定义日期时间格式
                clock_in_time = clock.getClock_in_time();
                cit = dtf.format(clock_in_time);
            }
            if (clock.getClock_off_time()!=null) {
                clock_off_time = clock.getClock_off_time();
                cot = dtf.format(clock_off_time);
            }
            //循环形式输出
            System.out.println(clock.getWork_date()+"\t"+clock.getEmployee_no()+"\t"+clock.getUsername()+"\t"+ cit +"\t"+ cot +"\t"+ clock.getDiff_in_status()+"\t"+clock.getDiff_off_time());


            }
//            System.out.println(clock_info);

//        return employees;
        return clock_info;

    }

    @Override
    public List<Clock> getSalaryToday() {

//        String sql = "select * from check_info where work_date=CURDATE() and employee_no=?";
        String sql = "select work_date,employee_no,username,clock_in_time,clock_off_time,diff_in_status,diff_off_time from check_info left join employee on check_info.employee_no=employee.number where work_date=CURDATE()";;
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);

        ResultSetHandler<List<Clock>> rh = new BeanListHandler<>(Clock.class);
//        List<String> salary_info = new ArrayList<>();

        List<Clock> clock_info = null;
        try {
            clock_info = qr.query(sql,rh);
//            for (Employee employee : employees) {
//                //循环形式输出
//                System.out.println(employee);
//            }
        }catch (SQLException e) {
            System.out.println("查询失败");
        }catch (NullPointerException e){
            System.out.println("空");
        }
        System.out.println("工作日期\t\t"+"员工编号\t\t"+"员工姓名\t\t"+"上班时间\t\t"+"下班时间\t\t"+"上班状态\t\t"+"下班状态");
        for (Clock clock: clock_info) {
            //转化变量
            LocalDateTime clock_in_time;
            LocalDateTime clock_off_time;
            String cit = null;
            String cot = null;
            //时间格式转化判断
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            if(clock.getClock_in_time()!=null) {
                // 定义日期时间格式
                clock_in_time = clock.getClock_in_time();
                cit = dtf.format(clock_in_time);
            }
            if (clock.getClock_off_time()!=null) {
                clock_off_time = clock.getClock_off_time();
                cot = dtf.format(clock_off_time);
            }
            //循环形式输出
            System.out.println(clock.getWork_date()+"\t"+clock.getEmployee_no()+"\t"+clock.getUsername()+"\t"+ cit +"\t"+ cot +"\t"+ clock.getDiff_in_status()+"\t"+clock.getDiff_off_time());


        }

        return clock_info;
//                .stream()
//                .peek(employee -> System.out.println(employee)) // 在遍历过程中打印员工信息
//                .collect(Collectors.toList()); // 收集并返回修改后的集合
    }

    @Override
    public void addSalaryIn(Clock clock) {
        //设置现在的时间
        clock.setClock_in_time(LocalDateTime.now());
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        String search = "SELECT * FROM clock_info WHERE employee_no = ? AND clock_date = CURDATE()";
        //存储
        ResultSetHandler<Clock> rsh = new BeanHandler<>(Clock.class);
        Clock clock1 = null;
        try {
            clock1 =  qr.query(search,rsh,clock.getEmployee_no());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //判断重复打卡
        if (clock1 != null){
            System.out.println("请勿重复打卡!");
        }else {
            String sql = "INSERT INTO clock_info (employee_no, clock_in_time, clock_date) VALUES (?, ?, CURDATE())";
            try {
                qr.update(sql, clock.getEmployee_no(), clock.getClock_in_time());
                System.out.println("打卡成功...");
            } catch (SQLException e) {
                System.out.println("打卡失败...");
            }
            insertOrUpdateWorkDate(clock.getClock_in_time());
        }

    }

    @Override
    public void addSalaryOut(Clock clock) {
        //设置现在的时间
        clock.setClock_off_time(LocalDateTime.now());
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        String search = "SELECT * FROM clock_info WHERE employee_no = ? AND clock_date = CURDATE() AND clock_off_time IS NOT NULL";
        //存储
        ResultSetHandler<Clock> rsh = new BeanHandler<>(Clock.class);
        Clock clock1 = null;
        try {
            clock1 =  qr.query(search,rsh,clock.getEmployee_no());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //判断重复打卡
        if (clock1 != null){
            System.out.println("请勿重复打卡!");
        }else {
            String sql = "UPDATE clock_info SET clock_off_time = ? WHERE employee_no = ? AND clock_date = CURDATE()";
            try {
                qr.update(sql,clock.getClock_off_time(),clock.getEmployee_no());
                System.out.println("打卡成功...");
            } catch (SQLException e) {
                System.out.println("打卡失败...");
            }

            insertOrUpdateWorkDate(clock.getClock_off_time());
        }

    }
    //同步work_date表
    private void insertOrUpdateWorkDate(LocalDateTime ldt)  {
        // 获取当前日期时间
//        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime currentDateTime = ldt;
        DateTimeFormatter word_date_format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDate = currentDateTime.format(word_date_format);

        QueryRunner qr = new QueryRunner(JDBCUtil.ds);

        // 检查是否存在今天的记录
        String checkQuery = "SELECT COUNT(*) FROM work_date WHERE work_date = ?";
        long count = 0;
        try {
            count = qr.query(checkQuery, new ScalarHandler<>(), currentDate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (count == 0) {
            // 插入新记录
            String insertQuery = "INSERT INTO work_date (work_date) VALUES (?)";
            try {
                qr.update(insertQuery, currentDate);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        // 如果已存在记录，则不需更新，因为只记录日期
    }
}



