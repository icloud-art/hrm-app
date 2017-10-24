package com.charles.hrm.service.impl;

import com.charles.hrm.dao.DeptDao;
import com.charles.hrm.dao.UserDao;
import com.charles.hrm.domain.User;
import com.charles.hrm.service.HrmService;
import com.charles.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Transactional(readOnly = true)
    @Override
    public List<User> findUser(User user, PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("user",user);
        int recordCount = userDao.count(params);
        System.out.println("recordCount -->>" + recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel",pageModel);
        }
        List<User> users = userDao.selectByPage(params);
        return users;
    }
    @Transactional(readOnly = true)
    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public void removeUserById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.update(user);
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }
}

