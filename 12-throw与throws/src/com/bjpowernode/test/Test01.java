package com.bjpowernode.test;

import com.bjpowernode.entity.Dept;

/**
 * Created by dlkyy on 2021/2/11 14:01
 */
public class Test01 {
  public static void main(String[] args) {
    Dept dept = new Dept();
    try {
      dept.test1();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    dept.test2();
  }
}
