package com.hz.service.impl;

import com.hz.dao.PileMapper;
import com.hz.pojo.FoPile;
import com.hz.service.PileService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service("pileService")
public class PileServiceImpl implements PileService {
    @Resource
    private PileMapper getFoPileMapper;
    @Override
    public List<FoPile> getFoPileList() throws Exception {
        return getFoPileMapper.getFoPileList();
    }

    @Override
    public List<FoPile> getPiles() throws Exception {
        return getFoPileMapper.getPiles();
    }
}
