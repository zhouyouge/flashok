package com.hz.dao;


import com.hz.pojo.FoPayrecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayRecordMapper {
    public List<FoPayrecord> getFoPayrecordList(@Param("pagecurr") int pagecurr,
                                                @Param("pagesize") int pagesize,
                                                @Param("user_wechat_name")String user_wechat_name) throws Exception;
    public int getPayRecordCount() throws Exception;
    public int addPayRecord(FoPayrecord foPayrecord)throws Exception;
}
