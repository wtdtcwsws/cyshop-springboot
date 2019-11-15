package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.Member;
import com.cy.cyshopspringboot.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lz - PC
 * @date 2019/11/13 - 12:15
 */
@Controller
public class RegisteredController {
    @Autowired
    private IRegisterService iRegisterService;

    @RequestMapping("/register")
    public Mono<String> register(){
        return Mono.create(indexMono->indexMono.success("registered"));
    }

    @RequestMapping(value = "/registerCreate",method = RequestMethod.POST)
    @ResponseBody
    public String registerCreate(
            Member member
    ) throws IOException {
        System.out.println("进来了");
        System.out.println(member);
        System.out.println("账号"+member.getAccount());
        int valid = iRegisterService.findMemberByAccount(member.getAccount());
        if (valid<1){
            member.setStatus(1);
            member.setLevelId(1);
            int createMember = iRegisterService.registerMember(member);
            return "账号创建成功";
        }
        return "账号已存在";
    }
}
