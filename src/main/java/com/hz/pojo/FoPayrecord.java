package com.hz.pojo;


public class FoPayrecord {

  private long payrecordId;
  private long userId;
  private String payrecordTime;
  private double payrecordMoney;


  public long getPayrecordId() {
    return payrecordId;
  }

  public void setPayrecordId(long payrecordId) {
    this.payrecordId = payrecordId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getPayrecordTime() {
    return payrecordTime;
  }

  public void setPayrecordTime(String payrecordTime) {
    this.payrecordTime = payrecordTime;
  }


  public double getPayrecordMoney() {
    return payrecordMoney;
  }

  public void setPayrecordMoney(double payrecordMoney) {
    this.payrecordMoney = payrecordMoney;
  }

}
