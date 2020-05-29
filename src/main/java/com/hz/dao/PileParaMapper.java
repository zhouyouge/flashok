package com.hz.dao;

import com.hz.pojo.FoParameter;
import com.hz.pojo.FoPiletype;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PileParaMapper {
    public List<FoParameter> getParameterList(
                                            @Param("piletype_name")String piletype_name,
                                            @Param("parameter_electricity") String parameter_electricity,
                                            @Param("pagecurr")int pagecurr,
                                            @Param("pagesize") int pagesize) throws Exception;

    public int getCount(@Param("piletype_name") String piletype_name,@Param("parameter_electricity") String parameter_electricity)throws Exception;

    public FoParameter getParameterById(long parameter_id) throws Exception;

    public List<FoPiletype>  piletype ()throws Exception;
    public int addType(@Param("type") FoParameter type) throws Exception;

    public int updType(@Param("type") FoParameter type) throws Exception;
}
