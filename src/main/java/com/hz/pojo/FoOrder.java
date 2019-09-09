package com.hz.pojo;

public class FoOrder {
    private long order_id;//订单ID
    private long user_id;// 用户ID
    private double order_money;//消费金额
    private long order_power;//充电量
    private long station_id;//电站ID
    private String order_starttime;//开始时间
    private String order_endtime;//结束时间
    private int order_reason;//结束原因 0到时结束 1.用户结束 2.未结束订单
    private double order_cost;//成本金额
    private double order_service;//服务费
    private String order_time;//充电时长
    private long pile_id;//电桩ID


    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public double getOrder_money() {
        return order_money;
    }

    public void setOrder_money(double order_money) {
        this.order_money = order_money;
    }

    public long getOrder_power() {
        return order_power;
    }

    public void setOrder_power(long order_power) {
        this.order_power = order_power;
    }

    public long getStation_id() {
        return station_id;
    }

    public void setStation_id(long station_id) {
        this.station_id = station_id;
    }

    public String getOrder_starttime() {
        return order_starttime;
    }

    public void setOrder_starttime(String order_starttime) {
        this.order_starttime = order_starttime;
    }

    public String getOrder_endtime() {
        return order_endtime;
    }

    public void setOrder_endtime(String order_endtime) {
        this.order_endtime = order_endtime;
    }

    public int getOrder_reason() {
        return order_reason;
    }

    public void setOrder_reason(int order_reason) {
        this.order_reason = order_reason;
    }

    public double getOrder_cost() {
        return order_cost;
    }

    public void setOrder_cost(double order_cost) {
        this.order_cost = order_cost;
    }

    public double getOrder_service() {
        return order_service;
    }

    public void setOrder_service(double order_service) {
        this.order_service = order_service;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public long getPile_id() {
        return pile_id;
    }

    public void setPile_id(long pile_id) {
        this.pile_id = pile_id;
    }
}
