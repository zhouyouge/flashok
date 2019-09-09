package com.hz.pojo;


public class FoResource {

  private long resource_id;//模块ID
  private String resource_name;//模块名称
  private String resource_url;//路径
  private String resource_iocn;//图标
  private String resource_sorts;//排序
  private long resource_pid;//父级ID


  public long getResource_id() {
    return resource_id;
  }

  public void setResource_id(long resource_id) {
    this.resource_id = resource_id;
  }

  public String getResource_name() {
    return resource_name;
  }

  public void setResource_name(String resource_name) {
    this.resource_name = resource_name;
  }

  public String getResource_url() {
    return resource_url;
  }

  public void setResource_url(String resource_url) {
    this.resource_url = resource_url;
  }

  public String getResource_iocn() {
    return resource_iocn;
  }

  public void setResource_iocn(String resource_iocn) {
    this.resource_iocn = resource_iocn;
  }

  public String getResource_sorts() {
    return resource_sorts;
  }

  public void setResource_sorts(String resource_sorts) {
    this.resource_sorts = resource_sorts;
  }

  public long getResource_pid() {
    return resource_pid;
  }

  public void setResource_pid(long resource_pid) {
    this.resource_pid = resource_pid;
  }
}
