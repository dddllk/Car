package com.bjpowernode.dao;

import com.bjpowernode.entity.Dept;
import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/10 23:42
 *
 * 对部门表进行增删改查
 */
public class DeptDao {

  private PreparedStatement ps;
  private final JdbcUtil util = new JdbcUtil();

  // 增
  public int add(int deptNo, String dname, String loc){
    int result = 0;
    String sql = "insert into dept(deptNo,dname,loc) values(?,?,?)";

    ps  = util.createStatement(sql);
    try {
      ps.setInt(1, deptNo);
      ps.setString(2, dname);
      ps.setString(3, loc);
      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close();
    }
    return result;
  }

  // 删
  public int delete(int deptNo){
    int result = 0;
    String sql = "delete from dept where deptno = ?";

    ps = util.createStatement(sql);
    try {
      ps.setInt(1, deptNo);
      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close();
    }
    return result;
  }

  // 改
  public int update(String dname, String loc, int deptNo){
    int result = 0;
    String sql = "update dept set dname=?,loc=? where deptno=?";

    ps = util.createStatement(sql);
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

  // 查
  public List findAll(){
    ResultSet rs = null;
    List list = new ArrayList();
    String sql = "select *from dept";

    ps = util.createStatement(sql);
    try {
      rs = ps.executeQuery();
      while(rs.next()){
      /*
        Dept dept = new Dept();
        dept.setDeptNo(rs.getInt(1));
        dept.setDname(rs.getString(2));
        dept.setLoc(rs.getString(3));
      */
        int deptNo = rs.getInt(1);
        String dname = rs.getString(2);
        String loc = rs.getString(3);
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
