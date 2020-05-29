package com.hz.pojo;


public class FoStation {

  private int station_id;//电站id
  private String station_code;//电站编号
  private String station_name;//电站名称
  private String station_longitude;//经度
  private String station_latitude;//纬度
  private long state_id;//区域ID
  private double station_cost;//成本电费
  private double station_service;//服务费
  private double state_dcprice;//直流充电费用
  private double state_acprice;//交流充电费用
  private String subscribe_rule;//预约收费标准
  private String station_createtime;//创建时间
  private Integer station_state;//电站状态(1正常，2在建，5停运)
  private FoState state;

  public FoState getState() {
    return state;
  }

  public void setState(FoState state) {
    this.state = state;
  }

  public int getStation_id() {
    return station_id;
  }

  public void setStation_id(int station_id) {
    this.station_id = station_id;
  }

  public Integer getStation_state() {
    return station_state;
  }

  public void setStation_state(Integer station_state) {
    this.station_state = station_state;
  }

  public String getStation_code() {
    return station_code;
  }

  public void setStation_code(String station_code) {
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

  public double getState_dcprice() {
    return state_dcprice;
  }

  public void setState_dcprice(double state_dcprice) {
    this.state_dcprice = state_dcprice;
  }

  public double getState_acprice() {
    return state_acprice;
  }

  public void setState_acprice(double state_acprice) {
    this.state_acprice = state_acprice;
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


}
