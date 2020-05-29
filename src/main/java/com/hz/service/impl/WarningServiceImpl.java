package com.hz.service.impl;

import com.hz.dao.WarningMapper;
import com.hz.pojo.FoWarning;
import com.hz.service.WarningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("warningService")
public class WarningServiceImpl implements WarningService {
    @Resource
    private WarningMapper warningMapper;
    @Override
    public int addWarning(String warning_type, String warning_pile_code, String warning_images, String warning_beizhu) throws Exception {
        return warningMapper.addWarning(warning_type,warning_pile_code,warning_images,warning_beizhu);
    }

    @Override
    public List<FoWarning> getWarningList(String station_name,Integer warning_state,int currpageno,int pagesize) throws Exception {
        int pagecurr = (currpageno-1)*pagesize;
        return warningMapper.getWarningList(station_name,warning_state,pagecurr,pagesize);
    }

    @Override
    public int updateWarningState(Integer warning_state,int warning_ID) throws Exception {
        return warningMapper.updateWarningState(warning_state,warning_ID);
    }

    @Override
    public int deleteWarning(int[] warning_ID)   {
        return warningMapper.deleteWarning(warning_ID);
    }

    @Override
    public int getWarningCount(String station_name, Integer warning_state) throws Exception {
        return warningMapper.getWarningCount(station_name,warning_state);
    }
}
