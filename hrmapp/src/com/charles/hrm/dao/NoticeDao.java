package com.charles.hrm.dao;

import com.charles.hrm.dao.provider.NoticeDynaSqlProvider;
import com.charles.hrm.domain.Notice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.aspectj.weaver.ast.Not;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.charles.hrm.util.common.HrmConstants.NOTICETABLE;

public interface NoticeDao {
    //动态查询
    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "selectWithParam")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "create_date",property = "createDate",javaType = Date.class),
            @Result(column = "user_id",property = "user",one = @One(select = "com.charles.hrm.dao.UserDao.selectById",
            fetchType = FetchType.EAGER))
    })
    List<Notice> selectByPage(Map<String,Object>params);

    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object>params);

    @Select("select * from "+NOTICETABLE+" where id = #{id}")
    Notice selectById(int id);

    @Delete(" delete from "+NOTICETABLE+" where id = #{id} ")
    void  deleteById(Integer id);

    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "insertNotice")
    void save(Notice notice);

    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "updateNotice")
    void update(Notice notice);

}
