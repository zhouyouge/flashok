package com.hz.pojo;


import java.sql.Timestamp;

public class FoPiletype {

  private long piletype_id;//电桩类型ID
  private String piletype_name;//电桩类型名称
  private String piletype_createtime;//创建时间


  public long getPiletype_id() {
    return piletype_id;
  }

  public void setPiletype_id(long piletype_id) {
    this.piletype_id = piletype_id;
  }

  public String getPiletype_name() {
    return piletype_name;
  }

  public void setPiletype_name(String piletype_name) {
    this.piletype_name = piletype_name;
  }

  public String getPiletype_createtime() {
    return piletype_createtime;
  }

  public void setPiletype_createtime(String piletype_createtime) {
    this.piletype_createtime = piletype_createtime;
  }
}
