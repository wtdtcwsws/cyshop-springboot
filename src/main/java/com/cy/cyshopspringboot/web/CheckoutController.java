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

    @RequestMapping("/checkout")
    public Mono<String> checkout(
            HttpSession session
    ){

        System.out.println("----------------到时候删除------------------");
        List<CartVO> cartVOs = new ArrayList<>();
        for (int i=1;i<3;i++){
            CartVO cartVO = new CartVO();
            cartVO.setSkuId(6);
            cartVO.setNumber(2);
            cartVO.setPrice(new BigDecimal("5789.00"));
            cartVOs.add(cartVO);
        }
        Member member = new Member();
        member.setId(6);
        System.out.println("------------------------------------------");

//        Member member = (Member)session.getAttribute("loginfo");
//        //        看看罗海放在session里的购物车对象名是啥
//        List<CartVO> cartVOs = (List<CartVO>)session.getAttribute("cartVOs");
        //        订单确认页面的获取地址
        List<MemberAddress> memberAddresses = this.findAlladdress(String.valueOf(member.getId()));
        session.setAttribute("postPrice","0");
        session.setAttribute("paymentId","1");
        session.setAttribute("memberAddresses",memberAddresses);
        List<ConfirmOrderVO> confirmOrderVOs = new ArrayList<ConfirmOrderVO>();
        BigDecimal orderPrice = new BigDecimal("0");
        for (CartVO cartVO : cartVOs){
            ConfirmOrderVO confirmOrderVO = new ConfirmOrderVO();
            String skuId = String.valueOf(cartVO.getSkuId());
            String SkuImg = iSkuImgService.selectSkuImgUrlById(skuId);
            Sku sku = iSkuService.selectSkuById(skuId);
            confirmOrderVO.setSkuImg(SkuImg);
//            confirmOrderVO.setSkuImg("/img/sku-img/0.jpg");
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
        session.setAttribute("postPrice","0");
        List<ConfirmOrderVO> confirmOrderVOS = (List<ConfirmOrderVO>)session.getAttribute("confirmOrderVOs");
        List<ConfirmOrderVO> confirmOrderVOs = new ArrayList<>();
        for (ConfirmOrderVO confirmOrderVO:confirmOrderVOS){
            confirmOrderVO.setPostPrice(new BigDecimal("0"));
            confirmOrderVOs.add(confirmOrderVO);
        }
        session.setAttribute("confirmOrderVOs",confirmOrderVOs);
        return Mono.create(confirmExpressMono->confirmExpressMono.success("checkout-form"));
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
        BigDecimal oP = (BigDecimal)session.getAttribute("orderPrice");
        if ("10".equals(postPrice)){
            BigDecimal op = oP.add(new BigDecimal("10"));
            session.setAttribute("orderPrice",op);
        }else{
            BigDecimal op = oP.subtract(new BigDecimal("10"));
            session.setAttribute("orderPrice",op);
        }
        return Mono.create(confirmExpressMono->confirmExpressMono.success("checkout-form"));
    }

    /**
     * 进入页面时获取默认的支付方式
     * @param paymentVal
     * @param session
     * @return
     */
    @RequestMapping("/confirmPaymentId")
    public Mono<String> confirmPaymentId(@RequestParam(value = "paymentVal",required = false) String paymentVal,HttpSession session){
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
        return Mono.create(confirmPaymentIdMono->confirmPaymentIdMono.success("checkout-form"));
    }

    /**
     * 更改订单的收货地址
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
        return Mono.create(confirmAddressMono->confirmAddressMono.success("checkout-form"));
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
//        Member member = (Member)session.getAttribute("loginfo");
        MemberAddress memberAddress = new MemberAddress();

        Member member = new Member();
        member.setId(6);

        memberAddress.setMemberId(member.getId());
        memberAddress.setSpecificAddress(address);
        memberAddress.setConsigneeName(name);
        memberAddress.setPhone(phone);
        int valid = iCheckoutService.addAddress(memberAddress);
        if(valid>0){
            List<MemberAddress> memberAddresses = this.findAlladdress(String.valueOf(member.getId()));
            session.setAttribute("memberAddresses",memberAddresses);
            return Mono.create(addAddressMono->addAddressMono.success("checkout-form"));
        }
        return Mono.create(addAddressMono->addAddressMono.success("checkout-form"));
    }

    @RequestMapping("/updateAddress")
    public Mono<String> updateAddress(
            @RequestParam(value = "id",required = false) String id,
            @RequestParam(value = "address",required = false) String address,
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "phone",required = false) String phone,
            HttpSession session
    ){
//        Member member = (Member)session.getAttribute("loginfo");

        Member member = new Member();
        member.setId(6);

        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setId(Integer.parseInt(id));
        memberAddress.setMemberId(member.getId());
        memberAddress.setSpecificAddress(address);
        memberAddress.setConsigneeName(name);
        memberAddress.setPhone(phone);
        int valid = iCheckoutService.updateAddress(memberAddress);
        if(valid>0){
            List<MemberAddress> memberAddresses = this.findAlladdress(String.valueOf(member.getId()));
            session.setAttribute("memberAddresses",memberAddresses);
            return Mono.create(updateAddressMono->updateAddressMono.success("checkout-form"));
        }
        return Mono.create(updateAddressMono->updateAddressMono.success("checkout-form"));
    }

    /**
     * 创建订单
     * @param session
     */
    @RequestMapping("/createOrder")
    public Mono<String> createOrder(HttpSession session){
        System.out.println("进来创建订单了");
        List<ConfirmOrderVO> confirmOrderVOs = (List<ConfirmOrderVO>)session.getAttribute("confirmOrderVOs");
//        Member member = (Member)session.getAttribute("loginfo");
        Member member = new Member();
        member.setId(6);

        String addressId = (String)session.getAttribute("addressId");
        OrderItem orderItem = new OrderItem();
        Order order = new Order();
        order.setMemberId(member.getId());
        order.setMemberAddressId(Integer.parseInt(addressId));
        order.setCreatTime(new Date());
        BigDecimal orderPrice = (BigDecimal)session.getAttribute("orderPrice");
        String postPrice = (String)session.getAttribute("postPrice");
        order.setTotalPrice(orderPrice.subtract(new BigDecimal(postPrice)));
        order.setPostPrice(new BigDecimal(postPrice));
        order.setPayment(orderPrice);
        order.setStatus(1);
        String paymentId = (String)session.getAttribute("paymentId");
        order.setPaymentWayId(Integer.parseInt(paymentId));
        order.setDeletestatus(0);
        order.setDiscounts(new BigDecimal("0.00"));
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
        session.setAttribute("orderId",order.getId());
        System.out.println("orderId:"+session.getAttribute("orderId"));
        return Mono.create(createOrderMono->createOrderMono.success("payment"));
    }
}
