package com.bjpowernode.dao;

import com.bjpowernode.entity.Dept;
import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/10 21:01
 *
 * Dao封装增删改查
 */
public class DeptDao {
  // 调用工具类
  private final JdbcUtil util = new JdbcUtil();

  // 添加数据行
  public int add(int deptNo, String dname, String loc){
    // 初始化sql
    String sql = "insert into dept(deptNo,dname,loc) values(?,?,?)";
    int result = 0;

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

  // 查询所有
  public List findAll(){
    String sql = "select *from dept";
    PreparedStatement ps = util.createStatement(sql);
    ResultSet rs = null;
    List list = new ArrayList();
    try {
      rs = ps.executeQuery();
      // 将临时表中的数据行转换成实体类实例对象保管
      while(rs.next()){
        int deptNo = rs.getInt("deptno");
        String dname = rs.getString("dname");
        String loc = rs.getString("loc");
        Dept dept = new Dept(deptNo, dname, loc);
        list.add(dept);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close(rs);
    }
    return list;
  }
}
