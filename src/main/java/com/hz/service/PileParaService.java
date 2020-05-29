package com.hz.service;

import com.hz.pojo.FoParameter;
import com.hz.pojo.FoPiletype;

import java.util.List;

public interface PileParaService {
    public List<FoParameter> getParameterList(String piletype_name,String parameter_electricity,int pagecurr, int pagesize) throws Exception;

    public int getCount(String piletype_name,String parameter_electricity)throws Exception;

    public FoParameter getParameterById(long parameter_id) throws Exception;

    public int addType(FoParameter type) throws Exception;

    public List<FoPiletype>  piletype ()throws Exception;

    public int updType(FoParameter type) throws Exception;
}
