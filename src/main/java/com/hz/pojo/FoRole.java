package com.hz.pojo;


public class FoRole {

  private long role_id;//角色id
  private String role_name;//角色名称
  private String role_description;//角色描述
  private String role_ids;//权限IDs
  private long role_ids_description;//权限描述


  public long getRole_id() {
    return role_id;
  }

  public void setRole_id(long role_id) {
    this.role_id = role_id;
  }

  public String getRole_name() {
    return role_name;
  }

  public void setRole_name(String role_name) {
    this.role_name = role_name;
  }

  public String getRole_description() {
    return role_description;
  }

  public void setRole_description(String role_description) {
    this.role_description = role_description;
  }

  public String getRole_ids() {
    return role_ids;
  }

  public void setRole_ids(String role_ids) {
    this.role_ids = role_ids;
  }

  public long getRole_ids_description() {
    return role_ids_description;
  }

  public void setRole_ids_description(long role_ids_description) {
    this.role_ids_description = role_ids_description;
  }
}
