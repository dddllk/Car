package com.bjpowernode;

/**
 * Created by dlkyy on 2021/2/11 14:17
 */
public interface rule {
  public void write(); // 接口实现类不喜欢，不需要的方法
  public void study(); // 接口实现类喜欢，需要的方法
}
