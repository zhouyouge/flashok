package com.hz.service;

import com.hz.pojo.FoUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public List<FoUser> getUserList(String user_wechat_name,
                                    Integer user_state,
                                    String datemin,
                                    String datemax,
                                    int currpageno,
                                    int pagesize)throws Exception;
    public int getUserCount(String user_wechat_name,
                            String datemin,
                            String datemax,
                            Integer user_state)throws Exception;
    public int addUser(FoUser foUser)throws Exception;
    public int updatState(int user_id,int user_state)throws Exception;
    public FoUser userShow(int user_id)throws Exception;
    public FoUser getUserByOpenId(String user_openid)throws Exception;
    public int updateUserMoney(String user_openid,double user_money)throws Exception;
}
