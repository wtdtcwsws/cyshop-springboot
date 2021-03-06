package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.Member;
import com.cy.cyshopspringboot.viewobject.CartVO;
import com.cy.cyshopspringboot.service.CartService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CartController
 * @Description:
 * @Author: 罗海
 * @Date: 2019/11/12 16:06
 **/
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public Mono<String> cart(Model model,HttpSession session) {

        Member member = (Member)session.getAttribute("loginfo");

        List<CartVO> cartMessages = cartService.cartMessageAll(member.getId());

        model.addAttribute("gouwuche", cartMessages);

        return Mono.create(indexMono -> indexMono.success("cart"));
    }




    @RequestMapping("/cart/number")
    @ResponseBody
    public Mono<String> cartNumber(@RequestParam(value = "skuId", required = false) String skuId,
                                   @RequestParam(value = "price", required = false) String price,
                                   @RequestParam(value = "number", required = false) String number,
                                   HttpSession session, HttpServletResponse response) throws IOException {

        // 创建jackson对象，用来将jackson数据转化
        ObjectMapper objectMapper = new ObjectMapper();
        // 创建cartmessage类型集合，用于存放cartmessage类型数据
        List<CartVO> cartMessages = new ArrayList<CartVO>();

        // 将获取的json数据转换成string数据
        List<String> skuids = objectMapper.readValue(skuId, new TypeReference<List<String>>() {
        });
        List<String> prices = objectMapper.readValue(price, new TypeReference<List<String>>() {
        });
        List<String> numbers = objectMapper.readValue(number, new TypeReference<List<String>>() {
        });

        // 创建变量由于记录数组长度，也就是对象的数量
        int num = skuids.size();

        // 创建循环将获取的数据分别放入cartmessage对象集合中
        for(int i = 0; i < num; i++){
            // 循环一次重新new一次cartMessage对象
            CartVO cartMessage = new CartVO();
            // 将skuid信息放入最新的cartMessage对象中
            cartMessage.setSkuId(Integer.parseInt(skuids.get(i)));
            // 将price对象转换成bigdecimal类型，然后存放到最新的cartmessage对象中
            BigDecimal priceBig = new BigDecimal(prices.get(i));
            cartMessage.setPrice(priceBig);
            // 将numbers信息放入最新的cartMessage对象中
            cartMessage.setNumber(Integer.parseInt(numbers.get(i)));
            // 最后将cartmessage对象放入集合中
            cartMessages.add(cartMessage);
        };

        System.out.println(cartMessages.isEmpty());

        session.setAttribute("cartVOs",cartMessages);

        if (cartMessages.isEmpty()){
            System.out.println("luohai");
            return Mono.create(indexMono -> indexMono.success("false"));
        }


         return Mono.create(indexMono -> indexMono.success("true"));
    }


}
