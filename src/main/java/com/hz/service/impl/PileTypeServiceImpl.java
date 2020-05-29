package com.hz.service.impl;

import com.hz.dao.PileTypeMapper;
import com.hz.pojo.FoPiletype;
import com.hz.service.PileTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("piletypeService")
public class PileTypeServiceImpl implements PileTypeService {
    @Resource
    private PileTypeMapper pileTypeMapper;

    @Override
    public List<FoPiletype> getPileTypeList(int currpageno, int pagesize, String piletype_name)throws Exception {
        //偏移量=(当前页-1) * 每页显示记录数
        int pagecurr =(currpageno-1)*pagesize;
        return pileTypeMapper.getPileTypeList(pagecurr,pagesize,piletype_name);
    }

    @Override
    public int getCount(String piletype_name) throws Exception {
        return pileTypeMapper.getCount(piletype_name);
    }

    @Override
    public FoPiletype getPileTypeById(long piletype_id) throws Exception {
        return pileTypeMapper.getPileTypeById(piletype_id);
    }

    @Override
    public int addPiletype(FoPiletype piletype) throws Exception {
        return pileTypeMapper.addPiletype(piletype);
    }

    @Override
    public int updPileType(FoPiletype piletype) throws Exception {
        return pileTypeMapper.updPileType(piletype);
    }


}
