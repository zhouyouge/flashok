package com.hz.service;

import com.hz.pojo.FoRole;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.List;

public interface StatisticsService {
    public List<FoRole> getRoleList(int pagecurr,int pagesize)throws Exception;
    public int getRoleCount()throws Exception;
    public int deleteRole(FoRole foRole)throws Exception;
    public int insertRole(FoRole foRole)throws Exception;
    /**
     * service 层批量删除接口
     * @param
     * @return
     * @throws Exception
     */
    public int deleteRoles(String[] array);
}
