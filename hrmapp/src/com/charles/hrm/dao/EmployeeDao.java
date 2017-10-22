package com.charles.hrm.dao;

import com.charles.hrm.dao.provider.EmployeeDynaSqlProvider;
import com.charles.hrm.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static com.charles.hrm.util.common.HrmConstants.EMPLOYEETABLE;

public interface EmployeeDao {
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "selectWithParam")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "card_id",property = "carId"),
            @Result(column = "post_code",property = "post_code"),
            @Result(column = "qq_num",property = "qqNum"),
            @Result(column = "birthday",property = "birthday",javaType = java.util.Date.class),
            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "dept_id",property = "dept",
                    one=@One(select = "com.charles.hrm.dao.DeptDao.selectById",fetchType = FetchType.EAGER)),

            @Result(column = "job_id",property = "job",
                    one=@One(select = "com.charles.hrm.dao.JobDao.selectById",fetchType = FetchType.EAGER))
    })
    List<Employee> selectByPage(Map<String,Object>params);

//    //动态插入员工
//    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "insertEmployee")
//    void save(Employee employee);
//
//    //根据id 删除员工
//    @Delete(" delete from"+EMPLOYEETABLE+" where id = #{id} ")
//    void deleteById(Integer id);
//
//    //根据id查询员工
//    @Select("select * from "+EMPLOYEETABLE+" where id = #{id}")
//    @Results({
//            @Result(id=true,column = "id",property = "id"),
//            @Result(column = "card_id",property = "cardId"),
//            @Result(column = "post_code",property = "postCode"),
//            @Result(column = "qq_num",property = "qqNum"),
//            @Result(column = "birthday",property = "birthday",javaType = java.util.Date.class),
//            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class),
//            @Result(column = "dept_id",property = "dept",
//                    one=@One(select = "com.charles.hrm.dao.JobDao.selectById",fetchType = FetchType.EAGER)),
//            @Result(column = "job_id",property = "job",
//                    one=@One(select = "com.charles.hrm.dao.JobDao.selectById",fetchType = FetchType.EAGER))
//    })
//    Employee selectById(Integer id);
}




















