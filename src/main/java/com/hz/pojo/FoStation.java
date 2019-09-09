package com.hz.pojo;


public class FoStation {

  private long station_id;//电站id
  private long station_code;//电站编号
  private String station_name;//电站名称
  private String station_longitude;//经度
  private String station_latitude;//纬度
  private long state_id;//区域ID
  private double station_cost;//成本电费
  private double station_service;//服务费
  private double state_price;//充电费用
  private String subscribe_rule;//预约收费标准
  private String station_createtime;//创建时间
  private String station_state;//电站状态(1正常，2在建，5停运)


  public long getStation_id() {
    return station_id;
  }

  public void setStation_id(long station_id) {
    this.station_id = station_id;
  }

  public long getStation_code() {
    return station_code;
  }

  public void setStation_code(long station_code) {
    this.station_code = station_code;
  }

  public String getStation_name() {
    return station_name;
  }

  public void setStation_name(String station_name) {
    this.station_name = station_name;
  }

  public String getStation_longitude() {
    return station_longitude;
  }

  public void setStation_longitude(String station_longitude) {
    this.station_longitude = station_longitude;
  }

  public String getStation_latitude() {
    return station_latitude;
  }

  public void setStation_latitude(String station_latitude) {
    this.station_latitude = station_latitude;
  }

  public long getState_id() {
    return state_id;
  }

  public void setState_id(long state_id) {
    this.state_id = state_id;
  }

  public double getStation_cost() {
    return station_cost;
  }

  public void setStation_cost(double station_cost) {
    this.station_cost = station_cost;
  }

  public double getStation_service() {
    return station_service;
  }

  public void setStation_service(double station_service) {
    this.station_service = station_service;
  }

  public double getState_price() {
    return state_price;
  }

  public void setState_price(double state_price) {
    this.state_price = state_price;
  }

  public String getSubscribe_rule() {
    return subscribe_rule;
  }

  public void setSubscribe_rule(String subscribe_rule) {
    this.subscribe_rule = subscribe_rule;
  }

  public String getStation_createtime() {
    return station_createtime;
  }

  public void setStation_createtime(String station_createtime) {
    this.station_createtime = station_createtime;
  }

  public String getStation_state() {
    return station_state;
  }

  public void setStation_state(String station_state) {
    this.station_state = station_state;
  }
}
