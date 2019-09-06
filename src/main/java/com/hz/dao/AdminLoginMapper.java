package com.hz.dao;

import com.hz.pojo.FoAdmin;
import org.apache.ibatis.annotations.Param;

public interface AdminLoginMapper {
    public FoAdmin adminLogin() throws Exception;
    public int enrollAdmin(FoAdmin foAdmin) throws  Exception;
}
