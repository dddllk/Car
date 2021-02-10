package com.bjpowernode.test;

import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by dlkyy on 2021/2/10 20:31
 */
public class TestMain {
  public static void main(String[] args) throws SQLException {
    JdbcUtil util = new JdbcUtil();

    PreparedStatement ps = null;
    ResultSet rs = null;

    Scanner sc = new Scanner(System.in);
    String sql_1 = "select count(*) from emp where ename=? and  empno = ?";
    String username, password;
    int flag = 0;

    // ------登录验证------start
    System.out.println("请输入用户名：");
    username = sc.next();
    System.out.println("请输入密码：");
    password = sc.next();

    ps = util.createStatement(sql_1);
    ps.setString(1, username);
    ps.setString(2, password);

    rs = ps.executeQuery();
    while(rs.next()) {
      flag = rs.getInt("count(*)");
    }

    // 销毁资源
    util.close(rs);

    if(flag == 1) {
      System.out.println("登录成功！");
    }else {
      System.out.println("登录失败！");
    }
    // ------登录验证------end

    // ------具体功能------start

    // ------具体功能------end
  }
}
