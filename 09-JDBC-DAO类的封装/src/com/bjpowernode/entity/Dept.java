package com.bjpowernode.entity;

/**
 * Created by dlkyy on 2021/2/10 22:52
 */
public class Dept {
  private Integer deptNo;
  private String dname;
  private String loc;

  public Integer getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(Integer deptNo) {
    this.deptNo = deptNo;
  }

  public String getDname() {
    return dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }

  public String getLoc() {
    return loc;
  }

  public void setLoc(String loc) {
    this.loc = loc;
  }

  public Dept() {
  }

  public Dept(Integer deptNo, String dname, String loc) {
    this.deptNo = deptNo;
    this.dname = dname;
    this.loc = loc;
  }
}
