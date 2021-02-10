package com.bjpowernode.test;

import com.bjpowernode.dao.DeptDao;
import com.bjpowernode.entity.Dept;

import java.util.List;
import java.util.Scanner;

/**
 * Created by dlkyy on 2021/2/10 22:07
 */
public class TestMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 部门管理系统
    System.out.println("******欢迎使用部门管理系统******");
    System.out.println("******请选择功能******");
    System.out.println("******1.增加功能******");
    System.out.println("******2.删除功能******");
    System.out.println("******3.查询功能******");
    System.out.println("******4.修改功能******");

    String username, password, dname, loc;
    int deptNo;
    int flag = 0;
    flag = sc.nextInt();

    DeptDao dao = new DeptDao();

    if(flag == 1){
      System.out.println("******请输入部门编号******");
      deptNo = sc.nextInt();
      System.out.println("******请输入部门名称******");
      dname = sc.next();
      System.out.println("******请输入部门位置******");
      loc = sc.next();
      flag = dao.add(deptNo, dname, loc);
      if (flag == 1) {
        System.out.println("部门添加成功！");
      }else{
        System.out.println("部门添加失败！");
      }
    }else if(flag == 2) {
      System.out.println("请输入部门编号：");
      deptNo = sc.nextInt();
      flag = dao.delete(deptNo);
      if (flag == 1) {
        System.out.println("部门删除成功！");
      }else{
        System.out.println("部门删除失败！");
      }
    }else if (flag == 3) {
      List<Dept> deptList = dao.findAll();
      for(Dept dept: deptList){
        System.out.println(dept.getDeptNo() + "|" +dept.getDname() + "|" +dept.getLoc());
      }
    }else if (flag == 4) {
      System.out.println("请输入新的部门名称：");
      dname = sc.next();
      System.out.println("请输入新的部门地址：");
      loc = sc.next();
      System.out.println("请输入部门编号：");
      deptNo = sc.nextInt();
      flag = dao.update(dname, loc, deptNo);
      if(flag == 1){
        System.out.println("更新成功！");
      }else{
        System.out.println("更新失败！");
      }
    }else {
      System.out.println("没有此功能，退出程序重新选择！");
    }

  }
}
