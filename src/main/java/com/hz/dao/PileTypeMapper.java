package com.hz.dao;

import com.hz.pojo.FoPiletype;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PileTypeMapper {
    public List<FoPiletype> getPileTypeList(
            @Param("pagecurr")int pagecurr,
            @Param("pagesize") int pagesize,
            @Param("piletype_name")String piletype_name) throws Exception;

    public int getCount(@Param("piletype_name") String piletype_name)throws Exception;

    public FoPiletype getPileTypeById(long piletype_id) throws Exception;
    public int addPiletype(@Param("piletype") FoPiletype piletype) throws Exception;

    public int updPileType(@Param("piletype") FoPiletype piletype) throws Exception;
}
