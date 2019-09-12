package com.hz.dao;

import com.hz.pojo.FoAdmin;
import com.hz.pojo.FoRole;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.List;

public interface StatisticsMapper {
    public List<FoRole> getRoleList(@Param("pagecurr") int pagecurr,
                                    @Param("pagesize") int pagesize)throws Exception;
    public int deleteRole(FoRole foRole)throws Exception;
    public int insertRole(FoRole foRole)throws Exception;
    public int deleteRoles(String[] array)throws Exception;
}
