package com.bjpowernode.util;

import java.sql.*;

/**
 * Created by dlkyy on 2021/2/10 23:27
 */
public class JdbcUtil {
  private Connection conn = null;
  private PreparedStatement ps = null;

  // 加载数据库驱动
  static{
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  // 创建数据库连接
  public Connection createConn(){
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode",
          "root", "123456");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  // 创建数据库操作对象
  public PreparedStatement createStatement(String sql){
    Connection con = createConn();
    try {
      ps = con.prepareStatement(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ps;
  }

  // 关闭资源
  public void close() {
    if(ps != null) {
      try {
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if(conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  // 关闭资源
  public void close(ResultSet rs){
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    close();
  }
}
