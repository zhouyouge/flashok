package com.hz.service.impl;

import com.hz.dao.StationAdminMapper;
import com.hz.pojo.FoAdmin;
import com.hz.pojo.FoState;
import com.hz.service.StationAdminService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service("stationAdminService")
public class StationAdminServiceImpl implements StationAdminService {
    @Resource
    private StationAdminMapper stationAdminMapper;

    @Override
    public List<FoAdmin> getStationAdminList(int currpageno, int pagesize, String station_name) throws Exception {
        //偏移量=(当前页-1) * 每页显示记录数
        int pagecurr =(currpageno-1)*pagesize;
        return stationAdminMapper.getStationAdminList(pagecurr,pagesize,station_name);
    }

    @Override
    public int getStationCount(String station_name) throws Exception {
        return stationAdminMapper.getStationCount(station_name);
    }

    @Override
    public FoState getAdminStateById(long state_id) throws Exception {
        return stationAdminMapper.getAdminStateById(state_id);
    }

    @Override
    public FoAdmin getAdminByID(long admin_id) throws Exception {
        return stationAdminMapper.getAdminByID(admin_id);
    }

    @Override
    public int updStateAdmin(String admin_name, Integer admin_state) throws Exception {
        return stationAdminMapper.updStateAdmin(admin_name,admin_state);
    }

    @Override
    public int updAdminState(String[] state_id, long admin_id) throws Exception {
        return stationAdminMapper.updAdminState(state_id,admin_id);
    }
}
