package com.bjpowernode.test;

/**
 * Created by dlkyy on 2021/2/11 13:45
 *
 * 1.重写与重载的区别
 * 	a:重载：JAVA中运行同一个类文件中出现多个方法名相同
 * 		但参数列表不同同名方法，这种现象称为重载
 *
 * 		要求两个方法名称必须相同，但是参数列表不能相同（个数不同，参数类型不同，参数类型出现顺序）
 * 		目的，让方法在接受不同参数实现不同的功能。
 *
 * 	b：重写：发生在继承过程中，子类对父类方法实现细节进行重新定义。
 *
 * 		1）重写方法时，子类不能降低方法访问权限，可以扩大访问权限
 * 		2）由private或者final修饰方法不能被重写
 * 		3）重写方法时，抛出异常可以是父类方法抛出异常全集，子集，空集
 * 		4）重写方法返回值，可以缩小返回类型范围，但是不能增加返回类型范围。
 */
public class Son extends Father{
  @Override
  public void run() {
    System.out.println("你TM好像一条狗啊！");
  }

  @Override
  public void run(int id) {
    System.out.println("你TM好像一条狗啊！"+id);
  }
}
