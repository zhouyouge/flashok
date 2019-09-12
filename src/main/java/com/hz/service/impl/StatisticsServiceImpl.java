package com.hz.service.impl;

import com.hz.dao.StatisticsMapper;
import com.hz.pojo.FoAdmin;
import com.hz.pojo.FoRole;
import com.hz.service.StatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.List;

@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {
    @Resource
    private StatisticsMapper statisticsMapper;

    @Override
    public List<FoRole> getRoleList(int currpageno,int pagesize) throws Exception {
        int pagecurr = (currpageno-1)*pagesize;
        return statisticsMapper.getRoleList(pagecurr,pagesize); //pagecurr 偏移量
    }

    @Override
    public int deleteRole(FoRole foRole) throws Exception {
        return statisticsMapper.deleteRole(foRole);
    }

    @Override
    public int insertRole(FoRole foRole) throws Exception {
        return statisticsMapper.insertRole(foRole);
    }

    @Override
    public int deleteRoles(String[] array) throws Exception {
        return statisticsMapper.deleteRoles(array);
    }


}
