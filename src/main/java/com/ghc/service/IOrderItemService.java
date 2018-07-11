package com.ghc.service;

import com.ghc.model.Items;
import com.ghc.model.UserOrderWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface IOrderItemService {
    List<UserOrderWrapper> queryOrderItems(int id) throws Exception;
    Items queryItemsById(int id) throws Exception;
    void updateItemsById(Items items) throws Exception;
}
