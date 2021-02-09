package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by dlkyy on 2021-02-09 13:45
 */
public class JDBCTest03 {
	public static void main(String[] args) throws Exception{
		String sql = "select *from dept";
		String url = "jdbc:mysql://localhost:3306/bjpowernode";
		// 1.Driver驱动注册
		Class.forName("com.mysql.jdbc.Driver");
		// 2.建立连接
		Connection con = DriverManager.getConnection(url, "root", "123456");
	}
}
