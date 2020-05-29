package com.hz.service;

import com.hz.pojo.FoOrder;
import com.hz.pojo.FoPile;
import com.hz.pojo.FoStation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    public List<FoOrder> getOrderList()throws Exception;
    public int addOrder(FoOrder foOrder)throws Exception;
    public FoPile getOrderCost(String pile_code)throws Exception;
    public List<FoOrder> getUserOrderList(String openid)throws Exception;
    public List<FoOrder> getOrderListByOpenid(String user_openid)throws Exception;
    public int updateOrderState(FoOrder foOrder)throws Exception;
}
