package com.hz.pojo;


public class FoParameter {

  private long parameter_id;//电桩类型参数ID
  private long piletype_id;//电桩类型ID
  private String parameter_voltage;//电桩额定电压
  private String parameter_current;//电桩额定电流
  private String parameter_capacity;//电桩额定功率
  private String parameter_electricity;//电桩电流类型
  private String parameter_creationtime;//创建时间

  public long getParameter_id() {
    return parameter_id;
  }

  public void setParameter_id(long parameter_id) {
    this.parameter_id = parameter_id;
  }

  public long getPiletype_id() {
    return piletype_id;
  }

  public void setPiletype_id(long piletype_id) {
    this.piletype_id = piletype_id;
  }

  public String getParameter_voltage() {
    return parameter_voltage;
  }

  public void setParameter_voltage(String parameter_voltage) {
    this.parameter_voltage = parameter_voltage;
  }

  public String getParameter_current() {
    return parameter_current;
  }

  public void setParameter_current(String parameter_current) {
    this.parameter_current = parameter_current;
  }

  public String getParameter_capacity() {
    return parameter_capacity;
  }

  public void setParameter_capacity(String parameter_capacity) {
    this.parameter_capacity = parameter_capacity;
  }

  public String getParameter_electricity() {
    return parameter_electricity;
  }

  public void setParameter_electricity(String parameter_electricity) {
    this.parameter_electricity = parameter_electricity;
  }

  public String getParameter_creationtime() {
    return parameter_creationtime;
  }

  public void setParameter_creationtime(String parameter_creationtime) {
    this.parameter_creationtime = parameter_creationtime;
  }
}
