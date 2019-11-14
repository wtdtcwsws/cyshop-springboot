package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.*;
import com.cy.cyshopspringboot.service.ICheckoutService;
import com.cy.cyshopspringboot.service.ISkuImgService;
import com.cy.cyshopspringboot.service.ISkuService;
import com.cy.cyshopspringboot.viewobject.CartVO;
import com.cy.cyshopspringboot.viewobject.ConfirmOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhy
 * @version 1.0.0
 * @function TODO
 * @date 2019年9月4日下午3:01:42
 * @place 工作地点
 * @remarks TODO
 */
@Controller
public class CheckoutController {

    @Autowired
    private ICheckoutService iCheckoutService;
    @Autowired
    private ISkuImgService iSkuImgService;
    @Autowired
    private ISkuService iSkuService;

    /**
     * 订单确认页面
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/checkout")
    public Mono<String> checkout(
            @RequestParam(value = "id",required = false) String id,
            @RequestParam(value = "shuId",required = false) String skuId,
            @RequestParam(value = "count",required = false) String count,
            @RequestParam(value = "price",required = false) String price,
            HttpSession session
    ){
//        订单确认页面的获取地址
        List<MemberAddress> memberAddresses = this.findAlladdress("6");
        session.setAttribute("memberAddresses",memberAddresses);

        ConfirmOrderVO confirmOrderVO = new ConfirmOrderVO();

        System.out.println("-------------测试数据-------------");
        confirmOrderVO.setSkuImg("/img/sku-img/0.jpg");
        confirmOrderVO.setSpuName("小罗嗨");
        confirmOrderVO.setSkuName("内存:1G;颜色:死亡芭比粉");
        confirmOrderVO.setNums(new BigDecimal("2"));
        confirmOrderVO.setUnitPrice(new BigDecimal("5000"));
        BigDecimal allPrice = confirmOrderVO.getUnitPrice().multiply(confirmOrderVO.getNums());
        confirmOrderVO.setPrice(allPrice);
        confirmOrderVO.setPostPrice(new BigDecimal("0"));
        confirmOrderVO.setSkuId(6);
        confirmOrderVO.setSpuId(5);
        confirmOrderVO.setPaymentId(1);
        confirmOrderVO.setOrderPrice(allPrice.add(confirmOrderVO.getPostPrice()));
        System.out.println("--------------------------");

//        String SkuImg = iSkuImgService.selectSkuImgUrlById(skuId);
//        Sku sku = iSkuService.selectSkuById(skuId);
//        confirmOrderVO.setSkuImg(SkuImg);
//        confirmOrderVO.setSpuName(sku.getName());
//        confirmOrderVO.setSkuName(sku.getDescription());
//        confirmOrderVO.setNums(new BigDecimal("count"));
//        confirmOrderVO.setUnitPrice(new BigDecimal("price"));
////        计算商品总价
//        BigDecimal allPrice = confirmOrderVO.getUnitPrice().multiply(confirmOrderVO.getNums());
//        confirmOrderVO.setPrice(allPrice);
//        confirmOrderVO.setPostPrice(new BigDecimal("0"));
//
//        confirmOrderVO.setOrderPrice(allPrice.add(new BigDecimal("postPrice")));
//        confirmOrderVO.setSkuId(sku.getId());
//        confirmOrderVO.setSpuId(sku.getSpuId());
//        model.addAttribute(confirmOrderVO);
        session.setAttribute("confirmOrderVO",confirmOrderVO);
        return Mono.create(checkoutMono->checkoutMono.success("checkout"));
    }

    @RequestMapping("/checkout2")
    public Mono<String> checkout(
            HttpSession session
    ){
        //        订单确认页面的获取地址
        List<MemberAddress> memberAddresses = this.findAlladdress("6");
//        model.addAttribute("memberAddresses",memberAddresses);
        session.setAttribute("memberAddresses",memberAddresses);
        List<ConfirmOrderVO> confirmOrderVOs = new ArrayList<ConfirmOrderVO>();
//        看看罗海放在session里的购物车对象名是啥
        List<CartVO> cartVOs = (List<CartVO>)session.getAttribute("cartVOs");
        BigDecimal orderPrice = new BigDecimal("0");
        for (CartVO cartVO : cartVOs){
            ConfirmOrderVO confirmOrderVO = new ConfirmOrderVO();
            String skuId = String.valueOf(cartVO.getSkuId());
            String SkuImg = iSkuImgService.selectSkuImgUrlById(skuId);
            Sku sku = iSkuService.selectSkuById(skuId);
            confirmOrderVO.setSkuImg(SkuImg);
            confirmOrderVO.setSpuName(sku.getName());
            confirmOrderVO.setSkuName(sku.getDescription());
            confirmOrderVO.setNums(new BigDecimal(cartVO.getNumber()));
            String price = String.valueOf(cartVO.getPrice());
            confirmOrderVO.setUnitPrice(new BigDecimal(price));
            BigDecimal allPrice = confirmOrderVO.getUnitPrice().multiply(confirmOrderVO.getNums());
            confirmOrderVO.setPrice(allPrice);
            confirmOrderVO.setPostPrice(new BigDecimal("0"));
            // 计算订单的支付价格：商品总价+订单总价
            confirmOrderVO.setOrderPrice(allPrice.add(orderPrice));
            confirmOrderVO.setSkuId(cartVO.getSkuId());
            confirmOrderVO.setSpuId(sku.getSpuId());
            confirmOrderVO.setPaymentId(1);
            confirmOrderVOs.add(confirmOrderVO);
            orderPrice = confirmOrderVO.getOrderPrice();
        }
        session.setAttribute("orderPrice",orderPrice);
        session.setAttribute("confirmOrderVOs",confirmOrderVOs);

        return Mono.create(checkoutMono->checkoutMono.success("checkout"));
    }

    /**
     * 通过用户id查找用户的所有收货地址
     * @param id
     * @return
     */
    public List<MemberAddress> findAlladdress(String id){
        List<MemberAddress> memberAddresses = iCheckoutService.findAderessByMemberId(id);
        return memberAddresses;
    }

    /**
     * 进入页面时获取默认的快递费用
     * @param session
     * @return
     */
    @RequestMapping("/confirmExpress")
    public Mono<String> confirmExpress(HttpSession session){
        session.setAttribute("postPrice",0);
        List<ConfirmOrderVO> confirmOrderVOS = (List<ConfirmOrderVO>)session.getAttribute("confirmOrderVOs");
        List<ConfirmOrderVO> confirmOrderVOs = new ArrayList<>();
        for (ConfirmOrderVO confirmOrderVO:confirmOrderVOS){
            confirmOrderVO.setPostPrice(new BigDecimal("0"));
        }
        session.setAttribute("confirmOrderVOs",confirmOrderVOs);
        return Mono.create(checkoutMono->checkoutMono.success("checkout-form"));
    }

    /**
     * 获取选择的快递费用
     * @param expressVal
     * @param session
     * @return
     */
    @RequestMapping("/confirmExpressChange")
    public Mono<String> confirmExpress(@RequestParam(value = "expressVal",required = false) String expressVal,HttpSession session){
        String postPrice = expressVal;
        session.setAttribute("postPrice",postPrice);
//        ConfirmOrderVO confirmOrderVO = (ConfirmOrderVO)session.getAttribute("confirmOrderVOs");
        List<ConfirmOrderVO> confirmOrderVOS = (List<ConfirmOrderVO>)session.getAttribute("confirmOrderVOs");
        List<ConfirmOrderVO> confirmOrderVOs = new ArrayList<>();
        for (ConfirmOrderVO confirmOrderVO:confirmOrderVOS){
            confirmOrderVO.setPostPrice(new BigDecimal(postPrice));
            if("10".equals(postPrice)){
                confirmOrderVO.setOrderPrice(confirmOrderVO.getPrice().add(new BigDecimal("10")));
            }
            if("0".equals(postPrice)){
                confirmOrderVO.setOrderPrice(confirmOrderVO.getPrice());
            }
            confirmOrderVOs.add(confirmOrderVO);
        }
        session.setAttribute("confirmOrderVOs",confirmOrderVOs);
        return Mono.create(checkoutMono->checkoutMono.success("checkout-form"));
    }

    /**
     * 进入页面时获取默认的支付方式
     * 待检验-----------------------------------------
     * @param paymentVal
     * @param session
     * @return
     */
    @RequestMapping("/confirmPayment")
    public Mono<String> confirmPayment(@RequestParam(value = "paymentVal",required = false) String paymentVal,HttpSession session){
        System.out.println("paymentVal:"+paymentVal);
        String paymentId = paymentVal;
        session.setAttribute("paymentId",paymentId);
        List<ConfirmOrderVO> confirmOrderVOS = (List<ConfirmOrderVO>)session.getAttribute("confirmOrderVOs");
        List<ConfirmOrderVO> confirmOrderVOs = new ArrayList<>();
        for(ConfirmOrderVO confirmOrderVO : confirmOrderVOS){
            confirmOrderVO.setPaymentId(Integer.parseInt(paymentId));
            confirmOrderVOs.add(confirmOrderVO);
        }
        session.setAttribute("confirmOrderVOs",confirmOrderVOs);
        return Mono.create(checkoutMono->checkoutMono.success("checkout-form"));
    }

    /**
     * 获取收货地址
     * @param addressId
     * @param session
     */
    @RequestMapping("/confirmAddress")
    public Mono<String> confirmAddress(
            @RequestParam(value = "addressId",required = false) String addressId,
            HttpSession session
    ){
        session.setAttribute("addressId",addressId);
        System.out.println(addressId);
        return Mono.create(checkoutMono->checkoutMono.success("checkout-form"));
    }

    /**
     * 新增收货地址
     * @param address
     * @param name
     * @param phone
     * @param session
     * @return
     */
    @RequestMapping("/addAddress")
    public Mono<String> addAddress(
            @RequestParam(value = "address",required = false) String address,
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "phone",required = false) String phone,
            HttpSession session
    ){
        Member member = (Member)session.getAttribute("loginfo");
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setMemberId(member.getId());
        memberAddress.setSpecificAddress(address);
        memberAddress.setConsigneeName(name);
        memberAddress.setPhone(phone);
        int valid = iCheckoutService.addAddress(memberAddress);
        if(valid>0){
            List<MemberAddress> memberAddresses = this.findAlladdress(String.valueOf(member.getId()));
//            List<MemberAddress> memberAddresses = this.findAlladdress("6");
            session.setAttribute("memberAddresses",memberAddresses);
            return Mono.create(checkoutMono->checkoutMono.success("checkout-form"));
        }
        return Mono.create(checkoutMono->checkoutMono.success("checkout-form"));
    }

    @RequestMapping("/updateAddress")
    public Mono<String> updateAddress(
            @RequestParam(value = "id",required = false) String id,
            @RequestParam(value = "address",required = false) String address,
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "phone",required = false) String phone,
            HttpSession session
    ){
        Member member = (Member)session.getAttribute("loginfo");
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setId(Integer.parseInt(id));
        memberAddress.setMemberId(member.getId());
//        memberAddress.setMemberId(6);
        memberAddress.setSpecificAddress(address);
        memberAddress.setConsigneeName(name);
        memberAddress.setPhone(phone);
        int valid = iCheckoutService.updateAddress(memberAddress);
        if(valid>0){
            List<MemberAddress> memberAddresses = this.findAlladdress(String.valueOf(member.getId()));
//            List<MemberAddress> memberAddresses = this.findAlladdress("6");
            session.setAttribute("memberAddresses",memberAddresses);
            return Mono.create(checkoutMono->checkoutMono.success("checkout-form"));
        }
        return Mono.create(checkoutMono->checkoutMono.success("checkout-form"));
    }

    /**
     * 创建订单
     * @param session
     */
    @RequestMapping("/createOrder")
    public Mono<String> createOrder(HttpSession session){
        List<ConfirmOrderVO> confirmOrderVOs = (List<ConfirmOrderVO>)session.getAttribute("confirmOrderVOs");
        Member member = (Member)session.getAttribute("loginfo");
        int addressId = (int)session.getAttribute("addressId");
        OrderItem orderItem = new OrderItem();
        Order order = new Order();

        order.setMemberId(member.getId());
        order.setMemberAddressId(addressId);
        order.setCreatTime(new Date());
        BigDecimal orderPrice = (BigDecimal)session.getAttribute("orderPrice");
        BigDecimal postPrice = (BigDecimal)session.getAttribute("postPrice");
        order.setTotalPrice(orderPrice.subtract(postPrice));
        order.setPostPrice(postPrice);
        order.setPayment(orderPrice);
        order.setStatus(1);
        int paymentId = (int)session.getAttribute("paymentId");
        order.setPaymentWayId(paymentId);
        int OrderCreatevalid = iCheckoutService.insertOrder(order);
        session.removeAttribute("postPrice");
        session.removeAttribute("orderPrice");
        session.removeAttribute("addressId");
        for (ConfirmOrderVO confirmOrderVO:confirmOrderVOs){
            orderItem.setOrderId(order.getId());
            orderItem.setSkuId(confirmOrderVO.getSkuId());
            orderItem.setNums(confirmOrderVO.getNums());
            int OrderItemCreatevalid = iCheckoutService.insertOrderItem(orderItem);
        }
//        return Mono.create(checkoutMono->checkoutMono.success("checkout-form"));
        return Mono.create(checkoutMono->checkoutMono.success("payment"));
    }
}
