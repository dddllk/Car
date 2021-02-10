package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by dlkyy on 2021/2/9 22:10
 *
 * 需求：
 *  1.添加部门
 *  2.查询部门
 *  3.删除部门
 *  4.更新部门
 */
public class TestMain {
  public static void main(String[] args) throws Exception{
    // 负责读取用户在控制台所输入的请求
    Scanner scanner = new Scanner(System.in);
    int flag = 0;
    while(true){
      System.out.println("******欢迎使用XX公司的部门管理系统******");
      System.out.println("******1.添加部门******");
      System.out.println("******2.查询部门******");
      System.out.println("******3.删除部门******");
      System.out.println("******4.更新部门******");
      System.out.println("******请输入操作******");

      flag = scanner.nextInt();

      String sql_1 = "insert into dept(deptno,dname,loc) values(?,?,?)";
      String sql_2 = "select *from dept";
      String sql_3 = "delete from dept where deptno = ?";
      String sql_4 = "update dept set dname=?,loc=? where deptno = ?";
      // 注册数据库驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 获取数据库连接
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode",
          "root", "123456");

      int deptno;
      String dname;
      String loc;

      if(flag == 1){
        // 创建数据库操作对象
        PreparedStatement ps = conn.prepareStatement(sql_1);
        System.out.println("******请输入部门编号******");
        deptno = scanner.nextInt();
        ps.setInt(1, deptno);
        System.out.println("******请输入部门名称******");
        dname = scanner.next();
        ps.setString(2, dname);
        System.out.println("******请输入部门位置******");
        loc = scanner.next();
        ps.setString(3, loc);

        flag = ps.executeUpdate();
        if(flag == 1){
          System.out.println("部门添加成功！");
        }else{
          System.out.println("部门添加失败！");
        }
        // 关闭资源
        if(ps != null){
          ps.close();
        }
      }else if (flag == 2) {
        // 创建数据库操作对象
        PreparedStatement ps = conn.prepareStatement(sql_2);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
          deptno = rs.getInt("deptno");
          dname = rs.getString("dname");
          loc = rs.getString("loc");
          System.out.println(deptno + "|" + dname + "|" + loc);
        }
        // 关闭资源
        if(rs != null){
          rs.close();
        }
        if(ps != null){
          ps.close();
        }
      }else if (flag == 3) {
        // 创建数据库操作对象
        PreparedStatement ps = conn.prepareStatement(sql_3);
        System.out.println("******请输入部门编号******");
        deptno = scanner.nextInt();
        ps.setInt(1, deptno);
        flag = ps.executeUpdate();
        if(flag == 1){
          System.out.println("部门删除成功！");
        }else{
          System.out.println("部门删除失败！");
        }
        // 关闭资源
        if(ps != null){
          ps.close();
        }

      }else if(flag == 4){
        // 创建数据库操作对象
        PreparedStatement ps = conn.prepareStatement(sql_4);
        System.out.println("******请输入部门******");
        dname = scanner.next();
        ps.setString(1, dname);
        System.out.println("******请输入部门位置******");
        loc = scanner.next();
        ps.setString(2, loc);

        ps.setInt(3, 50);
        flag = ps.executeUpdate();
        if(flag == 1){
          System.out.println("更新成功！");
        }else{
          System.out.println("更新失败！");
        }
      }else{
        System.out.println("没有对应的操作请重新选择！");
      }
      if(conn != null){
        conn.close();
      }
    }
  }
}
