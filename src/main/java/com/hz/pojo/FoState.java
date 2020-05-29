package com.hz.pojo;


public class FoState {

  private long state_id;//区域ID
  private String state_name;//区域名称
  private long state_pid;//区域父级ID
  private long admin_id;//管理员ID
  private String[] states;//区域id集合
  private FoStation station;


  public FoStation getStation() {
    return station;
  }

  public void setStation(FoStation station) {
    this.station = station;
  }

  public long getAdmin_id() {
    return admin_id;
  }

  public void setAdmin_id(long admin_id) {
    this.admin_id = admin_id;
  }

  public String[] getStates() {
    return states;
  }

  public void setStates(String[] states) {
    this.states = states;
  }

  public long getState_id() {
    return state_id;
  }

  public void setState_id(long state_id) {
    this.state_id = state_id;
  }

  public String getState_name() {
    return state_name;
  }

  public void setState_name(String state_name) {
    this.state_name = state_name;
  }

  public long getState_pid() {
    return state_pid;
  }

  public void setState_pid(long state_pid) {
    this.state_pid = state_pid;
  }
}
