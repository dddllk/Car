package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by dlkyy on 2021/2/9 20:56
 *  预编译
 */
public class Test02 {
  public static void main(String[] args) throws Exception{
    // 预编译SQL命令
    // ?是占位符
    // 预编译SQL相当于是个模具，在后续开发是需要将数据填充到占位符，就可以得到一个全新的SQL
    String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";

    // 注册驱动
    Class.forName("com.mysql.jdbc.Driver");
    // 创建连接
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123456");
    // 创建数据库操作对象
    PreparedStatement ps = conn.prepareStatement(sql);
    // 向服务器插入100条数据
    for(int i = 0; i <= 100; i++){
      // 通过向预编译SQL命令插入数据生成新的sql数据。
      ps.setInt(1, i);
      ps.setString(2, "dept_" + i);
      ps.setString(3, "重庆");
      // 在新的SQL语句生成之后，将SQL语句作为子弹添加到ps的弹夹
      ps.addBatch(); //sql1, sql2
    }
    // 推送100条SQL命令（一次）
    ps.executeBatch();

    if(ps != null){
      ps.close();
    }
    if(conn != null){
      conn.close();
    }
  }
}
