package com.hz.pojo;


public class FoUser {

  private long user_id;//用户ID
  private String user_wechat_id;//用户微信号
  private String user_wechat_iocn;//用户头像
  private String user_idcard;//用户身份证号
  private String user_phone;//用户电话
  private double user_money;//用户余额
  private String user_createtime;//用户创建时间
  private long user_state;//用户状态


  public long getUser_id() {
    return user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }

  public String getUser_wechat_id() {
    return user_wechat_id;
  }

  public void setUser_wechat_id(String user_wechat_id) {
    this.user_wechat_id = user_wechat_id;
  }

  public String getUser_wechat_iocn() {
    return user_wechat_iocn;
  }

  public void setUser_wechat_iocn(String user_wechat_iocn) {
    this.user_wechat_iocn = user_wechat_iocn;
  }

  public String getUser_idcard() {
    return user_idcard;
  }

  public void setUser_idcard(String user_idcard) {
    this.user_idcard = user_idcard;
  }

  public String getUser_phone() {
    return user_phone;
  }

  public void setUser_phone(String user_phone) {
    this.user_phone = user_phone;
  }

  public double getUser_money() {
    return user_money;
  }

  public void setUser_money(double user_money) {
    this.user_money = user_money;
  }

  public String getUser_createtime() {
    return user_createtime;
  }

  public void setUser_createtime(String user_createtime) {
    this.user_createtime = user_createtime;
  }

  public long getUser_state() {
    return user_state;
  }

  public void setUser_state(long user_state) {
    this.user_state = user_state;
  }
}
