package com.charles.hrm.service;

import com.charles.hrm.domain.Dept;
import com.charles.hrm.domain.Employee;
import com.charles.hrm.domain.User;
import com.charles.hrm.util.tag.PageModel;

import java.util.List;

public interface HrmService {
    /*
    * 用户登录
    * */
    User login(String loginname, String password);

    /*
    * 根据id查询用户
    * */
    User findUserById(Integer id);

    /*
    * 查询所有用户
    * */
    List<User> findUser(User user, PageModel pageModel);

    /*
    * 删除用户
    * */
    public void removeUserById(Integer id);

    /*
    * 修改用户
    * */
    public void modifyUser(User user);

    /*
    * 添加用户
    * */
    public void addUser(User user);


    /*************部门**************/
    /**
     * 获得所有部门，分页查询
     * */
    List<Dept> findDept(Dept dept,PageModel pageModel);

    /**
     * 获得所有部门
     */
    List<Dept> findAllDept();

    /**
     * 根据id删除部门
     */
    public void removeDeptById(Integer id);

    /**
     * 添加部门
     */
    void addDept(Dept dept);

    /**
     * 根据id查询部门
     */
    Dept findDeptById(Integer id);

    /**
     * 修改部门
     * *
     */
    void modifyDept(Dept dept);

}