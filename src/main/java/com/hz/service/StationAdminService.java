package com.hz.service;

import com.hz.pojo.FoAdmin;
import com.hz.pojo.FoState;
import java.util.List;

public interface StationAdminService {

    public List<FoAdmin> getStationAdminList(int pagecurr, int pagesize, String station_name) throws Exception;
    public int getStationCount(String station_name) throws Exception;
    public FoState getAdminStateById(long state_id)throws  Exception;
    public FoAdmin getAdminByID(long admin_id)throws Exception;
    public int updStateAdmin(String admin_name,Integer admin_state)throws Exception;
    public int updAdminState(String[] state_id, long admin_id)throws Exception;
}
