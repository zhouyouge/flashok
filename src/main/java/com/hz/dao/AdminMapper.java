package com.hz.dao;

import com.hz.pojo.FoAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    public List<FoAdmin> getAdminList(@Param("pagecurr") int pagecurr,
                                      @Param("pagesize") int pagesize,
                                      @Param("admin_name")String admin_name,
                                      @Param("admin_state")Integer admin_state)throws Exception;
    public int getAdminCount(@Param("admin_name")String admin_name,
                             @Param("admin_state")Integer admin_state)throws Exception;
    public int deleteAdmin(FoAdmin foAdmin)throws Exception;
    public int insertAdmin(FoAdmin foAdmin)throws Exception;
    public int deleteAdmins(String[] array)throws Exception;
}
