package com.hz.pojo;


public class FoState {

  private long state_id;//区域ID
  private String state_name;//区域名称
  private long state_pid;//区域父级ID


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
