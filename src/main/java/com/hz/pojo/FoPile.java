package com.hz.pojo;


public class FoPile {

  private long pile_id;//电站ID
  private String pile_code;//电桩编号
  private long station_id;//电站ID
  private long piletype_id;//电桩类型ID
  private String pile_creationtime;//创建时间
  private String pile_state;//电桩运行状态(1.空闲 2.运行中 3.离线4.维护5 被删除)


  public long getPile_id() {
    return pile_id;
  }

  public void setPile_id(long pile_id) {
    this.pile_id = pile_id;
  }

  public String getPile_code() {
    return pile_code;
  }

  public void setPile_code(String pile_code) {
    this.pile_code = pile_code;
  }

  public long getStation_id() {
    return station_id;
  }

  public void setStation_id(long station_id) {
    this.station_id = station_id;
  }

  public long getPiletype_id() {
    return piletype_id;
  }

  public void setPiletype_id(long piletype_id) {
    this.piletype_id = piletype_id;
  }

  public String getPile_creationtime() {
    return pile_creationtime;
  }

  public void setPile_creationtime(String pile_creationtime) {
    this.pile_creationtime = pile_creationtime;
  }

  public String getPile_state() {
    return pile_state;
  }

  public void setPile_state(String pile_state) {
    this.pile_state = pile_state;
  }
}
