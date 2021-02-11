package com.bjpowernode;

/**
 * Created by dlkyy on 2021/2/11 14:21
 *
 * 抽象类在实现接口时，可以不对接口中方法进行重写
 * 抽象类没有重写的方法，必须由抽象类的子类负责实现。
 */
public abstract class Andy implements rule {
  @Override
  public void study() {

  }
  public Andy(){

  }
}
