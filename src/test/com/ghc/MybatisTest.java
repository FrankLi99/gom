package com.ghc;

import com.ghc.common.Utils;
import com.ghc.dao.IOrderItemsDao;
import com.ghc.dao.IUserDao;
import com.ghc.model.*;
import com.ghc.service.IUserService;
import com.ghc.service.impl.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mybatis/spring-mybatis.xml")
public class MybatisTest {
    // 注入 sqlSessionFactory 对象
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Test
    public void testIUserDao() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IOrderItemsDao iOrderItemsDao = sqlSession.getMapper(IOrderItemsDao.class);
        List<UserOrderWrapper> userOrderWrapperList = iOrderItemsDao.queryOrderItems(1);

        for(UserOrderWrapper userOrderWrapper:userOrderWrapperList){
            User user = userOrderWrapper.getUser();
            List<Orders> ordersList = userOrderWrapper.getOrdersList();
            for(Orders order:ordersList){
                List<OrderDetail> orderDetailsList = order.getOrderDetailList();
                for(OrderDetail orderDetail:orderDetailsList){
                    Items item = orderDetail.getItem();
                    System.out.println(user.getName()+"|"+order.getId()+"|"+orderDetail.getId()+"|"+item.getName()+"|"+item.getPrice()+"|"+item.getDetail());
                }
            }
        }

        IUserDao iuserDao = (IUserDao) sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setName("frank");
        user.setPassword("123");

       UserService iUserService = new UserService();
        iUserService.setiUserDao(iuserDao);
       /*  iUserService.addUser(user);*/

        System.out.println("psw: "+user.getPassword());
       // System.out.println(Utils.digestPassword("123"));
        User user2 = iUserService.findUserByNameAndPassword(user.getName(),"123");

        System.out.println(user2.getName()+"<----------->"+user2.getPassword());

    }
}
