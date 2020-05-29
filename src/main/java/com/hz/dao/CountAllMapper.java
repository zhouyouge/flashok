package com.hz.dao;


public interface CountAllMapper {
    //所有的电站
    public int getStationAll() throws Exception;
    //正常的电站
    public int getgetStationActive()throws Exception;
    //在建的电站
    public int getgetStationBuild()throws Exception;
    //所有的电桩
    public int getPileAll()throws Exception;
    //空闲的电桩
    public int getPileActive()throws Exception;
    //运行中的电站
    public int getPileRun()throws Exception;
    //离线的电站
    public int getPileOut()throws Exception;
    //维护的电站
    public int getPileRepair()throws Exception;
    //充值
    public double getPayrecordMoney()throws Exception;
    //注册用户
    public int getUserAll()throws Exception;

}
