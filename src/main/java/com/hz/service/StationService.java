package com.hz.service;

import com.hz.pojo.FoStation;

import java.util.List;

public interface StationService {
    public List<FoStation> getFoStationList(int currpageno, int pagesize, String station_name, Integer station_state) throws Exception;
    public int getStationCount(String station_name, Integer station_state) throws Exception;
    public FoStation getStationrById(long station_id)throws  Exception;
    public int updStation(FoStation station) throws Exception;
    public int addStation(FoStation station) throws Exception;
    public int updState(int station_id, Integer station_state)throws Exception;
}
