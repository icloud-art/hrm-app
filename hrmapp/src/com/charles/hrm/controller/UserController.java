package com.charles.hrm.controller;

import com.charles.hrm.domain.User;
import com.charles.hrm.service.HrmService;
import com.charles.hrm.util.common.HrmConstants;
import com.charles.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping(value = "/user/selectUser")
    public String selectUser(Integer pageIndex, @ModelAttribute User user, Model model) {
        System.out.println("user = " + user);
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }

        List<User> users = hrmService.findUser(user,pageModel);
        model.addAttribute("users", users);
        model.addAttribute("pageModel",pageModel);
        return "user/user";
    }

    @RequestMapping(value = "/user/removeUser")
    public ModelAndView removeUser(String ids, ModelAndView mv) {
        String[] idArray = ids.split(",");
        for (String id :
                idArray) {
            hrmService.removeUserById(Integer.parseInt(id));
        }
        mv.setViewName("redirect:/user/selectUser");
        return mv;
    }

    @RequestMapping(value = "/user/updateUser")
    public ModelAndView updateUser(String flag,@ModelAttribute User user,ModelAndView mv) {
        if (flag.equals("1")) {
            User target = hrmService.findUserById(user.getId());
            mv.addObject("user",target);
            mv.setViewName("user/showUpdateUser");
        }else  {
            hrmService.modifyUser(user);
            mv.setViewName("redirect:/user/selectUser");
        }
        return mv;
    }

    @RequestMapping(value="/user/addUser")
    public ModelAndView addUser(
            String flag,
            @ModelAttribute User user,
            ModelAndView mv){
        if(flag.equals("1")){
            // 设置跳转到添加页面
            mv.setViewName("user/showAddUser");
        }else{
            // 执行添加操作
            hrmService.addUser(user);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/user/selectUser");
        }
        // 返回
        return mv;
    }
}





















