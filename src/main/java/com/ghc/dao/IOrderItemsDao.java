package com.ghc.dao;

import com.ghc.model.Items;
import com.ghc.model.UserOrderWrapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOrderItemsDao {
    List<UserOrderWrapper> queryOrderItems(int id) throws Exception;
    Items queryItemsById(int id) throws Exception;
    void updateItemsById(Items items);
}
