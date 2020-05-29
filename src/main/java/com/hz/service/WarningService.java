package com.hz.service;

import com.hz.pojo.FoWarning;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarningService {
    public int addWarning(String warning_type,String warning_pile_code,String warning_images,String warning_beizhu)throws Exception;
    public List<FoWarning> getWarningList(String station_name,Integer warning_state,int currpageno,int pagesize)throws Exception;
    public int updateWarningState(Integer warning_state,int warning_ID)throws Exception;


    public int deleteWarning(int[] warning_ID);


    public int getWarningCount(String station_name,Integer warning_state)throws Exception;
}
