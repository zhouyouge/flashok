package com.hz.service.impl;

import com.hz.dao.StationMapper;
import com.hz.pojo.FoStation;
import com.hz.service.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("stationService")
public class StationServiceImpl implements StationService {
    @Resource
    private StationMapper getFoStationMapper;
    @Override
    public List<FoStation> getFoStationList(int currpageno, int pagesize, String station_name, Integer station_state) throws Exception {
        //偏移量=(当前页-1) * 每页显示记录数
        int pagecurr =(currpageno-1)*pagesize;
        return getFoStationMapper.getFoStationList(pagecurr,pagesize,station_name,station_state) ;
    }

    @Override
    public int getStationCount(String station_name, Integer station_state) throws Exception {
        return getFoStationMapper.getStationCount(station_name,station_state);
    }

    @Override
    public FoStation getStationrById(long station_id) throws Exception {
        return getFoStationMapper.getStationrById(station_id);
    }

    @Override
    public int updStation(FoStation station) throws Exception {
        return getFoStationMapper.updStation(station);
    }

    @Override
    public int addStation(FoStation station) throws Exception {
        return getFoStationMapper.addStation(station);
    }

    @Override
    public int updState(int station_id, Integer station_state) throws Exception {
        return getFoStationMapper.updState(station_id,station_state);
    }

}
