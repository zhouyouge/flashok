package com.hz.pojo;


import java.util.List;

public class FoPile {

  private long pile_id;//电桩ID
  private String pile_code;//电桩编号
  private long station_id;//电站ID
  private long piletype_id;//电桩类型ID
  private String pile_creationtime;//创建时间
  private String pile_state;//电桩运行状态(1.空闲 2.运行中 3.离线4.维护5 被删除)
  private FoParameter parameter;//电桩参数对象
  private FoPiletype piletype;//电桩类型对象
  private FoStation station;//电站对象
  private List<FoWarning> foWarning1List; //故障对象
  private String pile_warning_images; //故障图片
  private String pile_warning_beizhu; //故障备注
  private int pile_electric_type;//电桩电流类型

  public int getPile_electric_type() {
    return pile_electric_type;
  }

  public void setPile_electric_type(int pile_electric_type) {
    this.pile_electric_type = pile_electric_type;
  }

  public List<FoWarning> getFoWarning1List() {
    return foWarning1List;
  }

  public void setFoWarning1List(List<FoWarning> foWarning1List) {
    this.foWarning1List = foWarning1List;
  }

  public String getPile_warning_images() {
    return pile_warning_images;
  }

  public void setPile_warning_images(String pile_warning_images) {
    this.pile_warning_images = pile_warning_images;
  }

  public String getPile_warning_beizhu() {
    return pile_warning_beizhu;
  }

  public void setPile_warning_beizhu(String pile_warning_beizhu) {
    this.pile_warning_beizhu = pile_warning_beizhu;
  }

  public long getPile_id() {
    return pile_id;
  }

  public void setPile_id(long pile_id) {
    this.pile_id = pile_id;
  }

  public String getPile_code() {
    return pile_code;
  }

  public void setPile_code(String pile_code) {
    this.pile_code = pile_code;
  }

  public long getStation_id() {
    return station_id;
  }

  public void setStation_id(long station_id) {
    this.station_id = station_id;
  }

  public long getPiletype_id() {
    return piletype_id;
  }

  public void setPiletype_id(long piletype_id) {
    this.piletype_id = piletype_id;
  }

  public String getPile_creationtime() {
    return pile_creationtime;
  }

  public void setPile_creationtime(String pile_creationtime) {
    this.pile_creationtime = pile_creationtime;
  }

  public String getPile_state() {
    return pile_state;
  }

  public void setPile_state(String pile_state) {
    this.pile_state = pile_state;
  }

  public FoParameter getParameter() {
    return parameter;
  }

  public void setParameter(FoParameter parameter) {
    this.parameter = parameter;
  }

  public FoPiletype getPiletype() {
    return piletype;
  }

  public void setPiletype(FoPiletype piletype) {
    this.piletype = piletype;
  }

  public FoStation getStation() {
    return station;
  }

  public void setStation(FoStation station) {
    this.station = station;
  }
}
