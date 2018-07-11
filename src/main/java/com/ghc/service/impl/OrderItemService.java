package com.ghc.service.impl;

import com.ghc.dao.IOrderItemsDao;
import com.ghc.model.*;
import com.ghc.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    private IOrderItemsDao iOrderItemsDao;
    @Override
    public List<UserOrderWrapper> queryOrderItems(int id) throws Exception {
        return iOrderItemsDao.queryOrderItems(id);
    }

    @Override
    public Items queryItemsById(int id) throws Exception {
        return iOrderItemsDao.queryItemsById(id);
    }

    @Override
    public void updateItemsById(Items items) throws Exception {
       iOrderItemsDao.updateItemsById(items);
    }

}
