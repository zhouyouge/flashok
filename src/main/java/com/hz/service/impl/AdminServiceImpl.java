package com.hz.service.impl;

import com.hz.dao.AdminMapper;
import com.hz.pojo.FoAdmin;
import com.hz.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public List<FoAdmin> getAdminList(int currpageno, int pagesize, String admin_name, Integer admin_state) throws Exception {
        int pagecurr = (currpageno-1)*pagesize;
        return adminMapper.getAdminList(pagecurr,pagesize,admin_name,admin_state);
    }

    @Override
    public int getAdminCount(String admin_name, Integer admin_state) throws Exception {
        return adminMapper.getAdminCount(admin_name,admin_state);
    }

    @Override
    public int deleteAdmin(FoAdmin foAdmin) throws Exception {
        return adminMapper.deleteAdmin(foAdmin);
    }

    @Override
    public int insertAdmin(FoAdmin foAdmin) throws Exception {
        return adminMapper.insertAdmin(foAdmin);
    }

    @Override
    public int deleteAdmins(String[] array) throws Exception {
        return adminMapper.deleteAdmins(array);
    }
}
