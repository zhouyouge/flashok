package com.hz.dao;

import com.hz.pojo.FoOrder;
import com.hz.pojo.FoPile;
import com.hz.pojo.FoStation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    public List<FoOrder> getOrderList()throws Exception;
    public int addOrder(FoOrder foOrder)throws Exception;
    public FoPile getOrderCost(@Param("pile_code") String pile_code)throws Exception;
    public List<FoOrder> getUserOrderList(String openid)throws Exception;
    public List<FoOrder> getOrderListByOpenid(@Param("user_openid")String user_openid)throws Exception;
    public int updateOrderState(FoOrder foOrder)throws Exception;
}
