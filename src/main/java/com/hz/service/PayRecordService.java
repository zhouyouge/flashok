package com.hz.service;

import com.hz.pojo.FoPayrecord;



import java.util.List;

public interface PayRecordService {
    public List<FoPayrecord> getFoPayrecordList(int pagecurr, int pagesize,String user_wechat_name )throws Exception;
    public int getPayRecordCount() throws Exception;
    public int addPayRecord(FoPayrecord foPayrecord)throws Exception;
}
