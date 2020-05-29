package com.hz.service.impl;

import com.hz.dao.OrderMapper;
import com.hz.pojo.FoOrder;
import com.hz.pojo.FoPile;
import com.hz.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public List<FoOrder> getOrderList() throws Exception {
        return orderMapper.getOrderList();
    }

    @Override
    public int addOrder(FoOrder foOrder) throws Exception {
        return orderMapper.addOrder(foOrder);
    }

    @Override
    public FoPile getOrderCost(String pile_code) throws Exception {
        return orderMapper.getOrderCost(pile_code);
    }

    @Override
    public List<FoOrder> getUserOrderList(String openid) throws Exception {
        return orderMapper.getUserOrderList(openid);
    }

    @Override
    public List<FoOrder> getOrderListByOpenid(String user_openid) throws Exception {
        return orderMapper.getOrderListByOpenid(user_openid);
    }

    @Override
    public int updateOrderState(FoOrder foOrder) throws Exception {
        return orderMapper.updateOrderState(foOrder);
    }


}
