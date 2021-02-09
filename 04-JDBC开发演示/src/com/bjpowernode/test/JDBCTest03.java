package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		// 3.创建连接工具
		PreparedStatement ps = con.prepareStatement("");
		// 4.执行sql
		ResultSet rs = ps.executeQuery(sql);
		// 5.遍历,读取信息
		while(rs.next()){
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String location = rs.getString("loc");
			System.out.println(deptno + "|" + dname + "|" + location);
		}
		// 6.销毁资源
		if(rs != null){
			rs.close();
		}
		if(ps != null){
			ps.close();
		}
		if(con != null){
			con.close();
		}
	}
}
