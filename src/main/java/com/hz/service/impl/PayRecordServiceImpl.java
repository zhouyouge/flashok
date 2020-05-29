package com.hz.service.impl;

import com.hz.dao.PayRecordMapper;
import com.hz.pojo.FoPayrecord;

import com.hz.service.PayRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("payRecordService")
public class PayRecordServiceImpl implements PayRecordService {
    @Resource
    private PayRecordMapper payRecordMapper;
    @Override
    public List<FoPayrecord> getFoPayrecordList(int currpageno, int pagesize,String user_wechat_name) throws Exception {
        int pagecurr = (currpageno-1)*pagesize;
        return payRecordMapper.getFoPayrecordList(pagecurr,pagesize,user_wechat_name);
    }

    @Override
    public int getPayRecordCount() throws Exception {
        return payRecordMapper.getPayRecordCount();
    }

    @Override
    public int addPayRecord(FoPayrecord foPayrecord) throws Exception {
        return payRecordMapper.addPayRecord(foPayrecord);
    }
}
