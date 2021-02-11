package com.bjpowernode.entity;

/**
 * Created by dlkyy on 2021/2/11 14:01
 *
 * 2.throw和throws的区别
 * 	a：throws:
 * 		1)声明位置：方法名之后
 * 			public void test() throws Exception{}
 * 		2)作用：通知开发人员当前方法在运行时，【有可能】抛出异常
 * 		3)携带数据：throws后面携带【异常类型】，一个throws后面可以携带多个异常类型
 * 		4)调用：当一个方法被throws修饰时，调用方法时必须考虑异常捕捉问题。
 * 	b：throw：
 * 		1）声明位置：方法执行体
 * 			public void test1() {
 * 			   throw new RuntimeException();
 *            }
 * 		2）作用：throw是一个命令，执行是抛出一个指定异常对象
 * 		3）携带数据：throw后面携带【异常对象】，一个throw一次只能携带一个异常对象
 * 		4）调用：当一个方法内部在throw命令时，在调用时可以不考虑异常捕捉问题。
 */
public class Dept {

  public void test1() throws ClassNotFoundException {
    System.out.println("dd");
  }

  public void test2() {
    throw new RuntimeException();
  }
}
