package com.hz.pojo;


public class FoAdmin {

  private long admin_id;//管理员ID
  private String admin_name;//管理员账号
  private String admin_password;//管理员密码
  private String admin_addtime;//管理员添加时间
  private long admin_state;//状态（0正常1禁用）
  private long role_id;//角色id
  private long admin_pid;//管理员父级id
  private String admin_data;//上一次登录时间
  private String admin_remarks;//管理员备注
  private String admin_email;//管理员邮箱
  private FoRole foRole;  //角色
  private FoState state;//区域对象集合

  public FoState getState() {
    return state;
  }

  public void setState(FoState state) {
    this.state = state;
  }

  public FoRole getFoRole() {
    return foRole;
  }

  public void setFoRole(FoRole foRole) {
    this.foRole = foRole;
  }

  public long getAdmin_id() {
    return admin_id;
  }

  public void setAdmin_id(long admin_id) {
    this.admin_id = admin_id;
  }

  public String getAdmin_name() {
    return admin_name;
  }

  public void setAdmin_name(String admin_name) {
    this.admin_name = admin_name;
  }

  public String getAdmin_password() {
    return admin_password;
  }

  public void setAdmin_password(String admin_password) {
    this.admin_password = admin_password;
  }

  public String getAdmin_addtime() {
    return admin_addtime;
  }

  public void setAdmin_addtime(String admin_addtime) {
    this.admin_addtime = admin_addtime;
  }

  public long getAdmin_state() {
    return admin_state;
  }

  public void setAdmin_state(long admin_state) {
    this.admin_state = admin_state;
  }

  public long getRole_id() {
    return role_id;
  }

  public void setRole_id(long role_id) {
    this.role_id = role_id;
  }

  public long getAdmin_pid() {
    return admin_pid;
  }

  public void setAdmin_pid(long admin_pid) {
    this.admin_pid = admin_pid;
  }

  public String getAdmin_data() {
    return admin_data;
  }

  public void setAdmin_data(String admin_data) {
    this.admin_data = admin_data;
  }

  public String getAdmin_remarks() {
    return admin_remarks;
  }

  public void setAdmin_remarks(String admin_remarks) {
    this.admin_remarks = admin_remarks;
  }

  public String getAdmin_email() {
    return admin_email;
  }

  public void setAdmin_email(String admin_email) {
    this.admin_email = admin_email;
  }
}
