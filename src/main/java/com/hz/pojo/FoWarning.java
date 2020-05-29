package com.hz.pojo;

public class FoWarning {
    private int  warning_ID;//故障id
    private String warning_type; //故障类型
    private String warning_pile_code; //故障电桩编号
    private String warning_images; //故障图片
    private String warning_beizhu; //故障备注
    private FoPile foPile; //电桩对象
    private Integer warning_state;//故障状态


    public int getWarning_ID() {
        return warning_ID;
    }

    public void setWarning_ID(int warning_ID) {
        this.warning_ID = warning_ID;
    }

    public Integer getWarning_state() {
        return warning_state;
    }

    public void setWarning_state(Integer warning_state) {
        this.warning_state = warning_state;
    }

    public FoPile getFoPile() {
        return foPile;
    }

    public void setFoPile(FoPile foPile) {
        this.foPile = foPile;
    }
    public String getWarning_type() {
        return warning_type;
    }

    public void setWarning_type(String warning_type) {
        this.warning_type = warning_type;
    }

    public String getWarning_pile_code() {
        return warning_pile_code;
    }

    public void setWarning_pile_code(String warning_pile_code) {
        this.warning_pile_code = warning_pile_code;
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
