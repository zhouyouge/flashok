package com.hz.service;

import com.hz.pojo.FoPiletype;
import java.util.List;

public interface PileTypeService {
        public List<FoPiletype> getPileTypeList(int pagecurr,int pagesize,String piletype_name) throws Exception;

        public int getCount(String piletype_name)throws Exception;

        public FoPiletype getPileTypeById(long piletype_id) throws Exception;
        public int addPiletype(FoPiletype piletype) throws Exception;

        public int updPileType(FoPiletype piletype) throws Exception;

}
