package com.hz.pojo;


import java.sql.Timestamp;

public class FoPiletype {

  private long piletype_id;//电桩类型ID
  private String piletype_name;//电桩类型名称
  private java.sql.Timestamp pile_creationtime;//创建时间


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

  public Timestamp getPile_creationtime() {
    return pile_creationtime;
  }

  public void setPile_creationtime(Timestamp pile_creationtime) {
    this.pile_creationtime = pile_creationtime;
  }
}
