package com.hz.service.impl;

import com.hz.dao.PileParaMapper;
import com.hz.pojo.FoParameter;
import com.hz.pojo.FoPiletype;
import com.hz.service.PileParaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("pileParaService")
public class PileParaServiceImpl implements PileParaService {
    @Resource
    private PileParaMapper pileParaMapper;
    @Override
    public List<FoParameter> getParameterList(String piletype_name, String parameter_electricity,int currpageno, int pagesize) throws Exception {
        //偏移量=(当前页-1) * 每页显示记录数
        int pagecurr =(currpageno-1)*pagesize;
        return pileParaMapper.getParameterList(piletype_name,parameter_electricity,pagecurr,pagesize) ;
    }

    @Override
    public int getCount(String piletype_name, String parameter_electricity) throws Exception {
        return pileParaMapper.getCount(piletype_name,parameter_electricity);
    }

    @Override
    public FoParameter getParameterById(long parameter_id) throws Exception {
        return pileParaMapper.getParameterById(parameter_id);
    }

    @Override
    public int addType(FoParameter type) throws Exception {
        return pileParaMapper.addType(type);
    }

    public List<FoPiletype>  piletype ()throws Exception{
        return pileParaMapper.piletype();
    }

    @Override
    public int updType(FoParameter type) throws Exception {
        return pileParaMapper.updType(type);
    }
}
