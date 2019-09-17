package com.hz.pojo;

public class FoWarning {
    private int warning_id; //故障id
    private String warning_type; //故障类型
    private int warning_station_id; //故障电站id
    private int warning_pile_id; // 故障电桩id
    private int warning_piletype_id; // 故障电桩类型id
    private String warning_images; // 故障图片
    private String warning_beizhu; //故障备注



    public int getWarning_station_id() {
        return warning_station_id;
    }

    public void setWarning_station_id(int warning_station_id) {
        this.warning_station_id = warning_station_id;
    }

    public int getWarning_id() {
        return warning_id;
    }

    public void setWarning_id(int warning_id) {
        this.warning_id = warning_id;
    }

    public String getWarning_type() {
        return warning_type;
    }

    public void setWarning_type(String warning_type) {
        this.warning_type = warning_type;
    }

    public int getWarning_pile_id() {
        return warning_pile_id;
    }

    public void setWarning_pile_id(int warning_pile_id) {
        this.warning_pile_id = warning_pile_id;
    }

    public int getWarning_piletype_id() {
        return warning_piletype_id;
    }

    public void setWarning_piletype_id(int warning_piletype_id) {
        this.warning_piletype_id = warning_piletype_id;
    }

    public String getWarning_images() {
        return warning_images;
    }

    public void setWarning_images(String warning_images) {
        this.warning_images = warning_images;
    }

    public String getWarning_beizhu() {
        return warning_beizhu;
    }

    public void setWarning_beizhu(String warning_beizhu) {
        this.warning_beizhu = warning_beizhu;
    }
}
