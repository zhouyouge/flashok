package com.hz.dao;

import com.hz.pojo.FoAdmin;
import com.hz.pojo.FoRole;

import java.lang.reflect.Array;
import java.util.List;

public interface StatisticsMapper {
    public List<FoRole> getRoleList()throws Exception;
    public int deleteRole(FoRole foRole)throws Exception;
    public int insertRole(FoRole foRole)throws Exception;
    public int deleteRoles(String[] array)throws Exception;
}
