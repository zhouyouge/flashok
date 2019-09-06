package com.hz.service;

import com.hz.pojo.FoAdmin;

public interface AdminLoginService {
    public FoAdmin adminLogin() throws Exception;
    public int enrollAdmin(FoAdmin foAdmin) throws  Exception;
}
