package com.charles.hrm.service.impl;

import com.charles.hrm.dao.DeptDao;
import com.charles.hrm.dao.UserDao;
import com.charles.hrm.domain.User;
import com.charles.hrm.service.HrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService {

    @Autowired
    private UserDao userDao;


    /*************用户服务实现**************/
    @Transactional(readOnly=true)
    @Override
    public User login(String loginname, String password) {
        System.out.println("HrmServiceImpl login -->>");
        return userDao.selectByLoginnameAndPassword(loginname,password);
    }

//    @Override
//    public User findUserById(Integer id) {
//        return null;
//    }
}

