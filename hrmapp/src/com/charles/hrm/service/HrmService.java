package com.charles.hrm.service;

import com.charles.hrm.domain.*;
import com.charles.hrm.util.tag.PageModel;
import jdk.nashorn.internal.scripts.JO;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public interface HrmService {

    /*************用户**************/
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


    /*************员工**************/

    /*
    * 获取所有员工，分页
    * */
    List<Employee> findEmployee(Employee employee, PageModel pageModel);

    /*
    * 根据id删除员工
    * */
    void removeEmployeeById(Integer id);

    /*
    * 根据id查询员工
    * */
    Employee findEmployeeById(Integer id);

    /*
    * 添加员工
    * */
    void addEmployee(Employee employee);

    /*
    * 修改员工
    * */
    void modifyEmployee(Employee employee);



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

    /*************职位**************/

    /*
    * 获取所有职位
    * */
    List<Job> findAllJob();

    /*
    * 获取所有职位，分页查询
    * */
    List<Job> findJob(Job job,PageModel pageModel);

    /*
    * 根据id删除职位
    * */
    public void removeJobById(Integer id);

    /*
    * 添加职位
    * */
    void addJob(Job job);

    /*
    * 根据id查询职位
    * */
    Job findJobById(Integer id);

    /*
    * 修改职位
    * */
    void modifyJob(Job job);

    /*************公告**************/

    /*
    * 获取所有的公告
    * */
    List<Notice> findNotice(Notice notice,PageModel pageModel);

    /*
    * 根据id查询Notice
    * */
    Notice findNoticeById(Integer id);

    /*
    * 根据id删除Notice
    * */
    void removeNoticeById(Integer id);

    /*
    * 更新Notice
    * */
    public void modifyNotice(Notice notice);

    /*
    * 添加Notice
    * */
    public void  addNotice(Notice notice);

    /*************文档**************/

    /*
    * 查找文件
    * */
    public List<Document> findDocument(Document document,PageModel pageModel);

    /*
    * 添加文件
    * */
    public void addDocument(Document document);

    /*
    * 删除文件
    * */
    public void removeDocumentById(Integer id);

    /*
    * 修改文件
    * */
    public void modifyDocument(Document document);

    /*
    * 根据id 查询文件
    * */
    public Document findDocumentById(Integer id);


}