package com.charles.hrm.controller;

import com.charles.hrm.domain.User;
import com.charles.hrm.service.HrmService;
import com.charles.hrm.util.common.HrmConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    @Qualifier("hrmService")
    private HrmService hrmService;

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam("loginname") String loginname,
                              @RequestParam("password") String password,
                              HttpSession session, ModelAndView mv) {
        User user = hrmService.login(loginname,password);
        if (user != null) {
            session.setAttribute(HrmConstants.USER_SESSION,user);
            mv.setViewName("redirect:/mainForm");
        }else {
            mv.addObject("message","登录名或密码错误！请重新输入");
            mv.setViewName("forward:/loginForm");
        }
        return mv;
    }
}





















