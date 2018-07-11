package com.ghc.web;

import com.ghc.exception.CustomException;
import com.ghc.model.Items;
import com.ghc.model.User;
import com.ghc.model.UserOrderWrapper;
import com.ghc.service.IOrderItemService;
import com.ghc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/items")
public class OrderItemsController {
    @Autowired
    private IOrderItemService iOrderItemService;
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/queryItems")
    public ModelAndView queryItems(ModelAndView modelAndView, HttpServletRequest req) throws Exception {
        User user = (User) req.getSession().getAttribute("user");
        int id = iUserService.queryUserIdByName(user.getName());
        List<UserOrderWrapper> userOrderWrapperList = iOrderItemService.queryOrderItems(id);
        modelAndView.addObject("userOrderWrapperList", userOrderWrapperList);
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping("/queryItemsById/{itemId}")
    /*采用 RESTful 风格编写 URL-->*/
    public ModelAndView queryItemsById(@PathVariable(value = "itemId") int id) throws Exception {
        Items items = iOrderItemService.queryItemsById(id);
        if (items == null) throw new CustomException("商品不存在");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item", items);
        modelAndView.setViewName("itemDetails");
        return modelAndView;
    }

    @RequestMapping("/editItemsById/{itemId}")
    public String editItemsById(@PathVariable("itemId") int id, Model model) throws Exception {
        Items items = iOrderItemService.queryItemsById(id);
        if (items == null) throw new CustomException("商品不存在");
        model.addAttribute("item", items);
        return "editItem";
    }

    @RequestMapping("/editItem/{itemId}")
    public String editItem(@PathVariable("itemId") int id, Items item,String pic, MultipartFile itemPic) throws Exception {
        String picPath = "E:\\images\\";
        String picOrigName = itemPic.getOriginalFilename();
        /*  if (itemPic != null && picOrigName != null && picOrigName.lastIndexOf(".") > 0) {
            //为了避免服务器中图片重名冲突，随机重新取新的名字
            picNewName = UUID.randomUUID() + picOrigName.substring(picOrigName.lastIndexOf("."));
        }*/

        // 如果这一次没选择图片，上一次也没有图片那么不用创建图片
        //这一段代码实际上永远不会因为判断itemPic是否为空被执行因为 itemPic 永远不会为 null,所以不能用itemPic做判断
        //检测 是否有图片上传......
        if (StringUtils.isEmpty(picOrigName)) {// 只要这次没有选择图片用上一次的也行 null 或者 9.jpg 但不应该再往硬盘写图片了 这种 &&StringUtils.isEmpty(lastPicName)
            String lastPicName = (item.getPic()==null)? "":item.getPic();
           // System.out.println("检测 是否有图片上传......");
            item.setPic(lastPicName);
        }
        //上次有选择图片，这次没有选择图片
       /* else if((!StringUtils.isEmpty(lastPicName))&&itemPic==null){
            item.setPic(lastPicName);
            item.setId(id);
            iOrderItemService.updateItemsById(item);
            return "redirect:/items/queryItems";
        }*/

        //如果上一次没图片，这一次有选择图片那么要创建图片，并且保存到数据库
        //上次有选择图片，这次也有选择图片,事实上这两种都要覆盖原本图片

        else if (itemPic != null && picOrigName != null && picOrigName.lastIndexOf(".") > 0) {

            //为了避免服务器中图片重名冲突，随机重新取新的名字
            String picNewName = UUID.randomUUID() + picOrigName.substring(picOrigName.lastIndexOf("."));

            File newPic = new File(picPath + picNewName);

            //删除上一次的图片，减轻图片服务器的压力
            if(pic!=null) {
                for (File file : newPic.getParentFile().listFiles()) {
                    if (pic.equalsIgnoreCase(file.getName())) {
                        file.delete();
                    }
                }
            }

            //将内存中的图片写入磁盘
            itemPic.transferTo(newPic);
            item.setPic(picNewName);
        }
        //接下来的是都要执行的代码:
        item.setId(id);
        iOrderItemService.updateItemsById(item);
        return "redirect:/items/queryItems";
    }
}
