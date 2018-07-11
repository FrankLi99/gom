package com.ghc.model;

import java.util.List;

public class UserOrderWrapper {
    private User user;
    private List<Orders> ordersList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
