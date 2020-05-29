package com.hz.service;

import com.hz.pojo.FoPile;
import com.hz.pojo.FoPiletype;
import com.hz.pojo.FoStation;

import java.util.List;

public interface PileStateService {
    public List<FoPile> getFoPileList(int pagecurr, int pagesize, String pile_code, Integer pile_state) throws Exception;
    public int getPileCount(String pile_code,Integer pile_state) throws Exception;
    public FoPile getPileById(long pile_id) throws Exception;

    public List<FoPiletype> getPiletype ()throws Exception;
    public List<FoStation> getStation()throws Exception;
    public int addPileState(FoPile pile) throws Exception;
    public int updPileState(FoPile pile)throws Exception;
}
