package com.hz.pojo;

public class JSONOBJECTA {

    private int code;//开关充电桩0开启，1关闭
    private String msg;//充电桩信息
    private String endtime;//开始时间
    private String startime;//关闭时间
    private String StartChargeSeq;//充电订单号 格式“运营商ID+唯一编号”
    private int StartChargeSeqStat;//充电订单状态1启动中，2充电中，3停止中，4已结束，5未知
    private int SuccStat;//操作结果0成功，1失败
    private int FailReason;//失败原因0无,1此设备不存在,2此设备离线
    private int ConnectorStatus;//充电设备接口状态1空闲,2占用（未充电）,3占用（充电中）,4占用（预约锁定）,255故障

    public String getStartChargeSeq() {
        return StartChargeSeq;
    }

    public void setStartChargeSeq(String startChargeSeq) {
        StartChargeSeq = startChargeSeq;
    }

    public int getStartChargeSeqStat() {
        return StartChargeSeqStat;
    }

    public void setStartChargeSeqStat(int startChargeSeqStat) {
        StartChargeSeqStat = startChargeSeqStat;
    }

    public int getSuccStat() {
        return SuccStat;
    }

    public void setSuccStat(int succStat) {
        SuccStat = succStat;
    }

    public int getFailReason() {
        return FailReason;
    }

    public void setFailReason(int failReason) {
        FailReason = failReason;
    }

    public int getConnectorStatus() {
        return ConnectorStatus;
    }

    public void setConnectorStatus(int connectorStatus) {
        ConnectorStatus = connectorStatus;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStartime() {
        return startime;
    }

    public void setStartime(String startime) {
        this.startime = startime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
