package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by dlkyy on 2021/2/9 20:31
 *
 * 此程序的问题：
 *  1.SQL语句书写麻烦，需要进行字符串拼接
 *  2.浪费时间：
 *    PreparedStatement每次只能推送一条数据
 *    为了推送100条sql命令，需要往返100次，浪费了大量时间
 *
 */
public class Test01 {
  public static void main(String[] args) throws Exception{
    // 1.注册驱动
    Class.forName("com.mysql.jdbc.Driver");
    // 2.建立通道
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123456");
    // 3.创建数据库操作对象
    PreparedStatement ps = conn.prepareStatement("");
    // 4.向mysql服务器推送100条数据进行插入
    for(int i = 0;i <= 100; i++) {
      String sql = "insert into dept(deptno,dname,loc) values ("+ i+", 'dept_" + i +"', '重庆')";
      ps.executeUpdate(sql);
    }
    // 销毁资源
    if(ps != null){
      ps.close();
    }
    if(conn != null){
      conn.close();
    }
  }
}
