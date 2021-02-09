package com.bjpowernode.test;

import java.util.Scanner;

/**
 * Created by dlkyy on 2021/2/9 22:10
 *
 * 需求：
 *  1.添加部门
 *  2.查询部门
 *  3.删除部门
 *  4.更新部门
 */
public class TestMain {
  public static void main(String[] args) {
    // 负责读取用户在控制台所输入的请求
    Scanner scanner = new Scanner(System.in);
    int flag = 0;

    System.out.println("******欢迎使用XX公司的部门管理系统******");
    System.out.println("******1.添加部门******");
    System.out.println("******2.查询部门******");
    System.out.println("******3.删除部门******");
    System.out.println("******4.更新部门******");
    System.out.println("******请输入操作******");

    flag = scanner.nextInt();
  }
}
