package com.hz.pojo;


public class FoPayrecord {

  private long payrecord_id;//充值记录ID
  private long payrecord_user_id;//用户ID
  private String payrecord_time;//充值时间
  private double payrecord_money;//充值金额
  private FoUser foUser;//用户

  public FoUser getFoUser() {
    return foUser;
  }

  public void setFoUser(FoUser foUser) {
    this.foUser = foUser;
  }

  public long getPayrecord_id() {
    return payrecord_id;
  }

  public void setPayrecord_id(long payrecord_id) {
    this.payrecord_id = payrecord_id;
  }

  public long getPayrecord_user_id() {
    return payrecord_user_id;
  }

  public void setPayrecord_user_id(long payrecord_user_id) {
    this.payrecord_user_id = payrecord_user_id;
  }

  public String getPayrecord_time() {
    return payrecord_time;
  }

  public void setPayrecord_time(String payrecord_time) {
    this.payrecord_time = payrecord_time;
  }

  public double getPayrecord_money() {
    return payrecord_money;
  }

  public void setPayrecord_money(double payrecord_money) {
    this.payrecord_money = payrecord_money;
  }
}
