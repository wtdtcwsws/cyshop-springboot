package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.Member;
import com.cy.cyshopspringboot.domain.Sku;
import com.cy.cyshopspringboot.domain.SkuImg;
import com.cy.cyshopspringboot.mapper.RefundOrReturnOrderMapper;
import com.cy.cyshopspringboot.service.ISkuImgService;
import com.cy.cyshopspringboot.service.ISkuService;
import com.cy.cyshopspringboot.service.RefundOrReturnOrderService;
import com.cy.cyshopspringboot.viewobject.OrderInfoVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpRequest;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ReturnController
 * @Description:
 * @Author: 罗海
 * @Date: 2019/11/12 16:52
 **/
@Controller
public class ReturnController {

    @Autowired
    private ISkuService iSkuService;

    @Autowired
    private ISkuImgService iSkuImgService;

    @Autowired
    private RefundOrReturnOrderService refundOrReturnOrderService;

    @RequestMapping("/return")
    public Mono<String> returnLogin(@RequestParam(value = "nums",required = false) Integer nums,
                                    @RequestParam(value = "skuid",required = false) Integer skuid,
                                    @RequestParam(value = "orderid",required = false) Integer orderid,
                                    Model model) {
        OrderInfoVO orderInfoVO = new OrderInfoVO();

        orderInfoVO.setNums(nums);
        orderInfoVO.setOid(orderid);
        orderInfoVO.setSid(skuid);

        String skuidString = String.valueOf(skuid);
        // sku数据传输
        Sku skus = iSkuService.selectSkuById(skuidString);
        model.addAttribute("skuMessage",skus);
        // sku图片传输
        String url = iSkuImgService.selectSkuImgUrlById("1");
        model.addAttribute("skuURL",url);
        model.addAttribute("order",orderInfoVO);
        model.addAttribute("skuAll",skus);

        return Mono.create(returnMono -> returnMono.success("return"));
    }
    @ResponseBody
    @RequestMapping("/return/transfer")
    public Mono<String> returnTransfer(@RequestParam(value = "option",required = false) String type,
                                       @RequestParam(value = "options",required = false) String reason,
                                       @RequestParam(value = "textarea",required = false) String describe,
                                       @RequestParam(value = "number",required = false) String number,
                                       @RequestParam(value = "price",required = false) String price,
                                       @RequestParam(value = "orderid",required = false) String orderId,
                                       @RequestParam(value = "skuid",required = false) String skuid,
                                       @RequestParam(value = "numbers",required = false) String count) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(option);
//        System.out.println(options);
//        System.out.println(textarea);
//        System.out.println(number);
//        System.out.println(price);
//        System.out.println(orderid);
//        System.out.println(skuid);
//        System.out.println(numbers);

        String types = objectMapper.readValue(type, new TypeReference<String>(){});
        String reasons = objectMapper.readValue(reason, new TypeReference<String>(){});
        String describes = objectMapper.readValue(describe, new TypeReference<String>(){});
        Integer orderIds = objectMapper.readValue(orderId, new TypeReference<Integer>(){});
        Integer counts = objectMapper.readValue(count, new TypeReference<Integer>(){});

        boolean num = refundOrReturnOrderService.insertAll(counts,orderIds,reasons,describes,types);

        if (num){
            return Mono.create(returnMono -> returnMono.success("true"));
        }
        return Mono.create(returnMono -> returnMono.success("false"));
    }


}


