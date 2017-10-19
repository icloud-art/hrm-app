package com.charles.hrm.dao.provider;

import com.charles.hrm.domain.User;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.charles.hrm.util.common.HrmConstants.USERTABLE;

public class UserDynaSqlProvider {
    public String selectWithParam(Map<String,Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User)params.get("user");
                    if (user.getUsername() != null && !user.getUsername().equals("")){
                        WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
                    }
                    if (user.getStatus() != null && !user.getStatus().equals("")) {
                        WHERE(" status LIKE CONCAT ('%',#{user.status},'%'");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam},#{pageModel.pageSize} ";
        }
        return sql;
    }

    //动态查询总数量
    public String count(Map<String,Object>params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getUsername() != null && !user.getUsername().equals("")){
                        WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
                    }
                    if (user.getStatus() != null && !user.getStatus().equals("")) {
                        WHERE(" status LIKE CONCAT ('%',#{user.status},'%') ");
                    }
                }
            }
        }.toString();
    }
}
