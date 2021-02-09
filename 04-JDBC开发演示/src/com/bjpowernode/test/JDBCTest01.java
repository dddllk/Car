package com.bjpowernode.test;

import java.sql.*;

/**
 * Created by dlkyy on 2021-02-09 13:18
 */
public class JDBCTest01 {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/bjpowernode";
		String sql = "insert into dept(deptno,dname,loc) values(90,'财务部','bj')";
		// 1.注册驱动
		Driver driver= new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		//2.建立连接通道
		Connection con = DriverManager.getConnection(url, "root", "123456");
		//3.在通道上创建工具
		PreparedStatement ps = con.prepareStatement("");
		//4.通过交通工具将SQL命令推送到MySql服务器上来执行并带回处理结果
		int result = ps.executeUpdate(sql);
		//5.销毁相关的资源
		if(ps != null){
			ps.close();
		}
		if(con != null){
			con.close();
		}
		System.out.println("参入"+ result +"条数据");
	}
}
