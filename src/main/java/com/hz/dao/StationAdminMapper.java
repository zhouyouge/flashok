package com.hz.dao;

import com.hz.pojo.FoAdmin;
import com.hz.pojo.FoState;
import com.hz.pojo.FoStation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StationAdminMapper {

    public List<FoAdmin> getStationAdminList(@Param("pagecurr") int pagecurr,
                                             @Param("pagesize") int pagesize,
                                             @Param("station_name") String station_name) throws Exception;

    public int getStationCount(@Param("station_name") String station_name) throws Exception;

    public FoState getAdminStateById(long state_id)throws  Exception;
    public FoAdmin getAdminByID(long admin_id)throws Exception;

    public int updStateAdmin(@Param("admin_name") String admin_name,
                             @Param("admin_state") Integer admin_state)throws Exception;
    public int updAdminState(@Param("state_id") String[] state_id,
                             @Param("admin_id") long admin_id)throws Exception;
}
