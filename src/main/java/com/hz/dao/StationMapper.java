package com.hz.dao;

import com.hz.pojo.FoStation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StationMapper {
    /**
     * 获得集合
     * @param pagecurr
     * @param pagesize
     * @param station_name
     * @param station_state
     * @return
     * @throws Exception
     */
    public List<FoStation> getFoStationList(@Param("pagecurr") int pagecurr,
                                            @Param("pagesize") int pagesize,
                                            @Param("station_name") String station_name,
                                            @Param("station_state") Integer station_state) throws Exception;
    /**
     * 统计总记录数
     * @return
     */
    public int getStationCount(@Param("station_name") String station_name, @Param("station_state") Integer station_state) throws Exception;
    public FoStation getStationrById(long station_id)throws  Exception;
    /**
     * 修改用户信息
     * @param station  要修改的对象
     * @return  受影响行数
     */
    public int updStation(@Param("station") FoStation station) throws Exception;

    /**
     * 添加电站
     * @param station
     * @return
     * @throws Exception
     */
    public int addStation(@Param("station") FoStation station) throws Exception;

    public int updState(@Param("station_id") int station_id,
                        @Param("station_state") Integer station_state)throws Exception;
}
