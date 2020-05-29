package com.hz.service.impl;

import com.hz.dao.PileStateMapper;
import com.hz.pojo.FoPile;
import com.hz.pojo.FoPiletype;
import com.hz.pojo.FoStation;
import com.hz.service.PileStateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("pileStateService")
public class PileStateServiceImpl implements PileStateService {
    @Resource
    private PileStateMapper pileStateMapper;
    @Override
    public List<FoPile> getFoPileList(int currpageno, int pagesize, String pile_code, Integer pile_state) throws Exception {
        //偏移量=(当前页-1) * 每页显示记录数
        int pagecurr =(currpageno-1)*pagesize;
        return pileStateMapper.getFoPileList(pagecurr,pagesize,pile_code,pile_state);
    }

    @Override
    public int getPileCount(String pile_code, Integer pile_state) throws Exception {
        return pileStateMapper.getPileCount(pile_code,pile_state);
    }

    @Override
    public FoPile getPileById(long pile_id) throws Exception {
        return pileStateMapper.getPileById(pile_id);
    }

    @Override
    public List<FoPiletype> getPiletype() throws Exception {
        return pileStateMapper.getPiletype();
    }

    @Override
    public List<FoStation> getStation() throws Exception {
        return pileStateMapper.getStation();
    }

    @Override
    public int addPileState(FoPile pile) throws Exception {
        return pileStateMapper.addPileState(pile);
    }

    @Override
    public int updPileState(FoPile pile) throws Exception {
        return pileStateMapper.updPileState(pile);
    }


}
