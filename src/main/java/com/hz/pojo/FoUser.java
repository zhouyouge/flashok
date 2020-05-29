package com.hz.pojo;


public class FoUser {

  private long user_id;//用户ID
  private String user_openid; //用户openid
  private String user_wechat_name;//用户微信号
  private String user_wechat_iocn;//用户头像
  private int user_sex;//用户性别
  private String user_idcard;//用户身份证号
  private String user_phone;//用户电话
  private double user_money;//用户余额
  private String user_createtime;//用户创建时间
  private Integer user_state;//用户状态
  private String user_addr;//用户地址
  private int user_integral; //用户积分
  private String user_email;//用户邮箱
  private String user_beizhu;//用户备注


  public String getUser_openid() {
    return user_openid;
  }

  public void setUser_openid(String user_openid) {
    this.user_openid = user_openid;
  }

  public String getUser_beizhu() {
    return user_beizhu;
  }

  public void setUser_beizhu(String user_beizhu) {
    this.user_beizhu = user_beizhu;
  }

  public int getUser_sex() {
    return user_sex;
  }

  public void setUser_sex(int user_sex) {
    this.user_sex = user_sex;
  }

  public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_addr() {
    return user_addr;
  }

  public void setUser_addr(String user_addr) {
    this.user_addr = user_addr;
  }

  public int getUser_integral() {
    return user_integral;
  }

  public void setUser_integral(int user_integral) {
    this.user_integral = user_integral;
  }

  public long getUser_id() {
    return user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }

    public String getUser_wechat_name() {
        return user_wechat_name;
    }

    public void setUser_wechat_name(String user_wechat_name) {
        this.user_wechat_name = user_wechat_name;
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

  public Integer getUser_state() {
    return user_state;
  }

  public void setUser_state(Integer user_state) {
    this.user_state = user_state;
  }
}
