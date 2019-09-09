package com.hz.service;

import com.hz.pojo.FoAdmin;

public interface AdminLoginService {
    public FoAdmin adminLogin(String adminName,String adminPassword) throws Exception;
    public int enrollAdmin(FoAdmin foAdmin) throws  Exception;
    public FoAdmin panduanName(String adminEmail) throws Exception;
}
