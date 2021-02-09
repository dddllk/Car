package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by dlkyy on 2021-02-09 13:34
 */
public class JDBCTest02 {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bjpowernode";
		String sql = "update dept set loc='c重庆' where deptno=90";
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.建立通道
		Connection con = DriverManager.getConnection(url, "root", "123456");
		// 3.建立交通工具
		PreparedStatement ps = con.prepareStatement("");
		// 4.执行sql，并带回结果
		int count = ps.executeUpdate(sql);
		// 5.销毁相关资源
		if(ps != null){
			ps.close();
		}
		if(con != null){
			con.close();
		}
		System.out.println("一共更新了" + count + "条数据！");
	}
}
