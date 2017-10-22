package com.charles.hrm.dao.provider;

import com.charles.hrm.domain.Employee;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.charles.hrm.util.common.HrmConstants.EMPLOYEETABLE;

public class EmployeeDynaSqlProvider {
    //分页动态查询
    public String selectWithParam(Map<String,Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(EMPLOYEETABLE);
                if (params.get("employee") != null) {
                    Employee employee = (Employee) params.get("employee");
                    if (employee.getDept() != null
                            && employee.getDept().getId() != null
                            && employee.getDept().getId() != 0) {
                        WHERE(" dept_id = #{employee.dept.id} ");
                    }
                    if (employee.getJob() != null
                            && employee.getJob().getId() != null
                            && employee.getJob().getId() !=0) {
                        WHERE(" job_id = #{employee.job.id}");
                    }
                    if (employee.getPhone() != null && !employee.getPhone().equals("")) {
                        WHERE(" phone like concat ('%',#{employee.phone},'%')");
                    }
                    if (employee.getCardId() != null && !employee.getCardId().equals("")) {
                        WHERE(" card_id like concat ('%',#{employee.cardId},'%')");
                    }
                    if (employee.getSex() != null && employee.getSex() != 0) {
                        WHERE("sex = #{employee.sex}");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
        }
        return sql;
    }
    //动态查询总数量
    public String count(Map<String,Object>params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(EMPLOYEETABLE);
                if (params.get("employee") != null) {
                    Employee employee = (Employee) params.get("employee");
                    if (employee.getDept() != null
                            && employee.getDept().getId() != null
                            && employee.getDept().getId() != 0) {
                        WHERE("dept_id = #{employee.dept.id}" );
                    }

                    if (employee.getJob() != null
                            && employee.getJob().getId() != null
                            && employee.getJob().getId() != 0) {
                        WHERE("job_id = #{employee.job.id}" );
                    }

                    if (employee.getName() != null && !employee.getName().equals("")){
                        WHERE(" name like concat ('%',#{employee.name},'%') ");
                    }

                    if (employee.getPhone() != null && !employee.getPhone().equals("")){
                        WHERE(" phone like concat ('%',#{employee.phone},'%') ");
                    }

                    if (employee.getCardId() != null && !employee.getCardId().equals("")){
                        WHERE(" card_id like concat ('%',#{employee.cardId},'%') ");
                    }

                    if (employee.getSex() != null && employee.getSex() != 0){
                        WHERE(" sex = #{employee.sex} ");
                    }
                }
            }
        }.toString();
    }
}



















