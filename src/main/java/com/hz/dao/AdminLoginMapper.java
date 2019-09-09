package com.hz.dao;

import com.hz.pojo.FoAdmin;
import org.apache.ibatis.annotations.Param;

public interface AdminLoginMapper {
    public FoAdmin adminLogin(@Param("admin_name")String adminName,
                              @Param("admin_password")String adminPassword) throws Exception;
    public int enrollAdmin(FoAdmin foAdmin) throws  Exception;
    public FoAdmin panduanName(String adminEmail) throws Exception;
}
