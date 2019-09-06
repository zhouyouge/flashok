package com.hz.pojo;


public class FoPile {

  private long pileId;
  private String pileCode;
  private long stationId;
  private long piletypeId;
  private String pileCreationtime;
  private String pileState;


  public long getPileId() {
    return pileId;
  }

  public void setPileId(long pileId) {
    this.pileId = pileId;
  }


  public String getPileCode() {
    return pileCode;
  }

  public void setPileCode(String pileCode) {
    this.pileCode = pileCode;
  }


  public long getStationId() {
    return stationId;
  }

  public void setStationId(long stationId) {
    this.stationId = stationId;
  }


  public long getPiletypeId() {
    return piletypeId;
  }

  public void setPiletypeId(long piletypeId) {
    this.piletypeId = piletypeId;
  }


  public String getPileCreationtime() {
    return pileCreationtime;
  }

  public void setPileCreationtime(String pileCreationtime) {
    this.pileCreationtime = pileCreationtime;
  }


  public String getPileState() {
    return pileState;
  }

  public void setPileState(String pileState) {
    this.pileState = pileState;
  }

}
