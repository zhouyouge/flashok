package com.hz.dao;

import com.hz.pojo.FoPile;
import java.util.List;

public interface PileMapper {
    /**
     * 获取所有充电桩
     * @return
     * @throws Exception
     */
    public List<FoPile> getFoPileList() throws Exception;

    public List<FoPile> getPiles() throws Exception;


}
