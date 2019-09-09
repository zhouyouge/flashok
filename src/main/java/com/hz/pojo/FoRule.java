package com.hz.pojo;


public class FoRule {

  private long rule_id;//规则ID
  private String charging_rules;//收费标准
  private long piletype_id;//电桩类型ID

  public long getRule_id() {
    return rule_id;
  }

  public void setRule_id(long rule_id) {
    this.rule_id = rule_id;
  }

  public String getCharging_rules() {
    return charging_rules;
  }

  public void setCharging_rules(String charging_rules) {
    this.charging_rules = charging_rules;
  }

  public long getPiletype_id() {
    return piletype_id;
  }

  public void setPiletype_id(long piletype_id) {
    this.piletype_id = piletype_id;
  }
}
