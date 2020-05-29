package com.hz.dao;

import com.hz.pojo.FoPile;
import com.hz.pojo.FoPiletype;
import com.hz.pojo.FoStation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PileStateMapper {
    public List<FoPile> getFoPileList(@Param("pagecurr") int pagecurr,
                                         @Param("pagesize") int pagesize,
                                         @Param("pile_code") String pile_code,
                                         @Param("pile_state") Integer pile_state) throws Exception;
    /**
     * 统计总记录数
     * @return
     */
    public int getPileCount(@Param("pile_code") String pile_code, @Param("pile_state") Integer pile_state) throws Exception;

    public List<FoPiletype> getPiletype ()throws Exception;
    public List<FoStation> getStation()throws Exception;

    public FoPile getPileById(long pile_id) throws Exception;

    public int addPileState(@Param("pile") FoPile pile) throws Exception;

    public int updPileState(@Param("pile")FoPile pile)throws Exception;
}
