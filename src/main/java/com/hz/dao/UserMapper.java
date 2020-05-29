package com.hz.dao;

import com.hz.pojo.FoUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<FoUser> getUserList(@Param("user_wechat_name") String user_wechat_name,
                                    @Param("user_state") Integer user_state,
                                    @Param("datemin") String datemin,
                                    @Param("datemax") String datemax,
                                    @Param("pagecurr") int pagecurr,
                                    @Param("pagesize") int pagesize)throws Exception;
    public int getUserCount(@Param("user_wechat_name") String user_wechat_name,
                            @Param("datemin") String datemin,
                            @Param("datemax") String datemax,
                            @Param("user_state") Integer user_state)throws Exception;

    public int addUser(FoUser foUser)throws Exception;
    public int updatState(@Param("user_id") int user_id,
                          @Param("user_state") int user_state)throws Exception;
    public FoUser userShow(@Param("user_id") int user_id)throws Exception;
    public FoUser getUserByOpenId(@Param("user_openid") String user_openid)throws Exception;
    public int updateUserMoney(@Param("user_openid") String user_openid,
                               @Param("user_money") double user_money)throws Exception;
}
