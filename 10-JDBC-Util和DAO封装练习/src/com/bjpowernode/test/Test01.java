package com.bjpowernode.test;

import com.bjpowernode.dao.DeptDao;
import com.bjpowernode.entity.Dept;

import java.util.List;

/**
 * Created by dlkyy on 2021/2/11 0:08
 */
public class Test01 {
  public static void main(String[] args) {
    // 查询测试
    DeptDao dao = new DeptDao();
    List<Dept> deptList = dao.findAll();
    for(Dept dept : deptList){
      System.out.println(dept.getDeptNo() + "|" +dept.getDname() + "|" + dept.getLoc());
    }
  }
}
