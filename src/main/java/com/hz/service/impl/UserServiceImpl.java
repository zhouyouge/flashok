package com.hz.service.impl;

import com.hz.dao.UserMapper;
import com.hz.pojo.FoUser;
import com.hz.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<FoUser> getUserList(String user_wechat_name, Integer user_state, int currpageno, int pagesize) throws Exception {
        int pagecurr = (currpageno-1)*pagesize;
        return userMapper.getUserList(user_wechat_name,user_state,pagecurr,pagesize);
    }


    @Override
    public int getUserCount(String user_wechat_name,Integer user_state) throws Exception {
        return userMapper.getUserCount(user_wechat_name,user_state);
    }

    @Override
    public int addUser(FoUser foUser) throws Exception {
        return userMapper.addUser(foUser);
    }

    @Override
    public int updatState(int user_id, int user_state) throws Exception {
        return userMapper.updatState(user_id,user_state);
    }

    @Override
    public FoUser userShow(int user_id) throws Exception {
        return userMapper.userShow(user_id);
    }
}
