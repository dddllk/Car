package com.bjpowernode.dao;

import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by dlkyy on 2021/2/10 21:01
 *
 * Dao封装增删改查
 */
public class DeptDao {

  // 添加数据行
  public int add(int deptNo, String dname, String loc){
    // 初始化sql
    String sql = "insert into dept(deptNo,dname,loc) values(?,?,?)";
    int result = 0;
    // 调用工具类
    JdbcUtil util = new JdbcUtil();
    PreparedStatement ps = util.createStatement(sql);
    try {
      ps.setInt(1, deptNo);
      ps.setString(2, dname);
      ps.setString(3, loc);
      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 关闭资源
      util.close();
    }
    return result;
  }

  // 删除数据行
  public int delete(int deptNo){
    // 初始化SQL
    String sql = "delete from dept where deptno = ?";
    // 初始化结果
    int result = 0;
    // 调用工具类
    JdbcUtil util = new JdbcUtil();
    PreparedStatement ps = util.createStatement(sql);
    try {
      ps.setInt(1, deptNo);
      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 关闭资源
      util.close();
    }
    return result;
  }

  // 更新数据行
  public int update(String dname, String loc, int deptNo) {
    // 初始化sql
    String sql = "update dept set dname=?,loc=? where deptno=?";
    // 初始化结果
    int result = 0;
    // 调用工具类
    JdbcUtil util = new JdbcUtil();
    PreparedStatement ps = util.createStatement(sql);
    try {
      ps.setString(1, dname);
      ps.setString(2, loc);
      ps.setInt(3, deptNo);
      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close();
    }
    return result;
  }
}
