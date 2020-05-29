package com.hz.service.impl;

import com.hz.dao.CountAllMapper;
import com.hz.service.CountAllService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("countAllService")
public class CountAllServiceImpl implements CountAllService {
    @Resource
    private CountAllMapper countAllMapper;
    @Override
    public int getStationAll() throws Exception {
        return countAllMapper.getStationAll();
    }

    @Override
    public int getgetStationActive() throws Exception {
        return countAllMapper.getgetStationActive();
    }

    @Override
    public int getgetStationBuild() throws Exception {
        return countAllMapper.getgetStationBuild();
    }

    @Override
    public int getPileAll() throws Exception {
        return countAllMapper.getPileAll();
    }

    @Override
    public int getPileActive() throws Exception {
        return countAllMapper.getPileActive();
    }

    @Override
    public int getPileRun() throws Exception {
        return countAllMapper.getPileRun();
    }

    @Override
    public int getPileOut() throws Exception {
        return countAllMapper.getPileOut();
    }

    @Override
    public int getPileRepair() throws Exception {
        return countAllMapper.getPileRepair();
    }

    @Override
    public double getPayrecordMoney() throws Exception {
        return countAllMapper.getPayrecordMoney();
    }

    @Override
    public int getUserAll() throws Exception {
        return countAllMapper.getUserAll();
    }

}
