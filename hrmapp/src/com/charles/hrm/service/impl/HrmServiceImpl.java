package com.charles.hrm.service.impl;

import com.charles.hrm.dao.DeptDao;
import com.charles.hrm.dao.JobDao;
import com.charles.hrm.dao.UserDao;
import com.charles.hrm.domain.Dept;
import com.charles.hrm.domain.Job;
import com.charles.hrm.domain.User;
import com.charles.hrm.service.HrmService;
import com.charles.hrm.util.tag.PageModel;
import jdk.nashorn.internal.scripts.JO;
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

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private JobDao jobDao;

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



    /*************部门服务实现**************/

    @Transactional(readOnly=true)
    @Override
    public List<Dept> findAllDept() {
        return deptDao.selectAllDept();
    }

    /**
     * HrmServiceImpl接口findDept方法实现
     * */
    @Transactional(readOnly=true)
    @Override
    public List<Dept> findDept(Dept dept,PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        params.put("dept", dept);
        int recordCount = deptDao.count(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }

        List<Dept> depts = deptDao.selectByPage(params);

        return depts;
    }

    /**
     * HrmServiceImpl接口removeUserById方法实现
     * @see { HrmService }
     * */
    @Override
    public void removeDeptById(Integer id) {
        deptDao.deleteById(id);

    }

    /**
     * HrmServiceImpl接口addDept方法实现
     * @see { HrmService }
     * */
    @Override
    public void addDept(Dept dept) {
        deptDao.save(dept);

    }

    /**
     * HrmServiceImpl接口findDeptById方法实现
     * @see { HrmService }
     * */
    @Override
    public Dept findDeptById(Integer id) {

        return deptDao.selectById(id);
    }

    /**
     * HrmServiceImpl接口modifyDept方法实现
     * @see { HrmService }
     * */
    @Override
    public void modifyDept(Dept dept) {
        deptDao.update(dept);

    }

    /*************职位服务实现**************/
    @Transactional(readOnly = true)
    @Override
    public List<Job> findAllJob(){
        return jobDao.selectAllJob();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Job>findJob(Job job,PageModel pageModel) {
        Map<String,Object> params = new HashMap<>();
        params.put("job",job);
        int recordCount = jobDao.count(params);

        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel",pageModel);
        }
        List<Job> jobs = jobDao.selectByPage(params);
        return jobs;
    }

    @Transactional(readOnly = true)
    @Override
    public void removeJobById(Integer id) {
        jobDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public void addJob(Job job) {
        jobDao.save(job);
    }

    @Transactional(readOnly = true)
    @Override
    public Job findJobById(Integer id) {
        return jobDao.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public void modifyJob(Job job) {
        jobDao.update(job);
    }

}

