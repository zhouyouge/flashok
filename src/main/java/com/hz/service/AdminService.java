package com.hz.service;

import com.hz.pojo.FoAdmin;

import java.util.List;

public interface AdminService {
    public List<FoAdmin> getAdminList(int pagecurr,int pagesize, String admin_name, Integer admin_state)throws Exception;
    public int getAdminCount(String admin_name,Integer admin_state)throws Exception;
    public int deleteAdmin(FoAdmin foAdmin)throws Exception;
    public int insertAdmin(FoAdmin foAdmin)throws Exception;
    public int deleteAdmins(String[] array)throws Exception;
}
