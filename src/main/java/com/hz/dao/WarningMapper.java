package com.hz.dao;

import com.hz.pojo.FoPile;
import com.hz.pojo.FoWarning;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarningMapper {
    public int addWarning(@Param("warning_type")String warning_type,
                          @Param("warning_pile_code")String warning_pile_code,
                          @Param("warning_images")String warning_images,
                          @Param("warning_beizhu")String warning_beizhu)throws Exception;
    public List<FoWarning> getWarningList(@Param("station_name") String station_name,
                                          @Param("warning_state") Integer warning_state,
                                          @Param("pagecurr") int pagecurr,
                                          @Param("pagesize") int pagesize)throws Exception;
    public int updateWarningState(@Param("warning_state") Integer warning_state,
                                  @Param("warning_ID") int warning_ID)throws Exception;
    public int deleteWarning(int[] warning_ID)throws  Exception;
    public int getWarningCount(@Param("station_name") String station_name,
                            @Param("warning_state") Integer warning_state)throws Exception;
}
