package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.Member;
import com.cy.cyshopspringboot.mapper.MemberMapper;
import com.cy.cyshopspringboot.service.IMemberService;
import com.cy.cyshopspringboot.viewobject.Catalog1VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lz - PC
 * @date 2019/11/12 - 17:50
 */
@Controller
public class LoginController {
    @Autowired
    private IMemberService iMemberService;


    @RequestMapping("/dologin")
    public Mono<String> index(Model model, HttpSession session,
                              @RequestParam(value = "account",required = false)String account,
                              @RequestParam(value = "password",required = false)String password
                              ) {
        Member loginfo = new Member();
        loginfo.setAccount(account);
        loginfo.setPassword(password);

        List<Member> members = iMemberService.login(loginfo);

        if (members.size() == 1) {
            session.setAttribute("loginfo",members.get(0));
            return Mono.create(indexMono->indexMono.success("/index"));
        } else {
            return Mono.create(indexMono->indexMono.success("login"));
        }

    }

    @RequestMapping("/login")
    public Mono<String> login() {








        return Mono.create(indexMono->indexMono.success("login"));
    }

}
