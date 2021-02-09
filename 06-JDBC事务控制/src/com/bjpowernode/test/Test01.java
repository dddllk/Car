package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by dlkyy on 2021/2/9 21:33
 *
 * 需求：
 *  删除部门30及其部门下所有的员工信息
 *  SQL：
 *    delete from dept where deptno=30  #dept.bak
 *    delete from emp where deptno=30   #emp.bak
 */
public class Test01 {
  public static void main(String[] args) throws Exception{
    String sql_1 = "delete from emp where deptno = 30";
    String sql_2 = "delete from dept where deptno = 30";

    // 注册驱动
    Class.forName("com.mysql.jdbc.Driver");
    // 建立连接通道
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123456");
    // 通过【连接通道】向mysql服务器发送“start transaction”
    conn.setAutoCommit(false);
    // 创建数据库操作对象
    PreparedStatement ps = conn.prepareStatement("");
    // 推送SQL命令
    try{
      ps.executeUpdate(sql_1);
      ps.executeUpdate(sql_2);
      // 如果程序能够执行到这里，说明推送的两条sql命令都能正常执行
      // 此时通知mysql服务器将本次操作中表文件备份进行删除
      conn.commit(); // 向mysql服务器推送
    }catch(SQLException e) {
        // 由Connection 通知mysql服务器将本次操作做所有表文件备份覆盖备份文件，取消本次操作
      conn.rollback();
    }
  }
}
