package com.charles.hrm.dao.provider;

import com.charles.hrm.domain.Document;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.charles.hrm.util.common.HrmConstants.DOCUMENTTABLE;

public class DocumentDynaSqlProvider {
    public String selectWithParam(Map<String,Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")){
                        WHERE(" title like concat ('%',#{document.title},'%') ");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitPara} ,#{pageModel.pageSize} ";
        }
        return sql;
    }

    public String count(Map<String,Object>params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")) {
                        WHERE(" title like concat('%',#{document.title},'%')");
                    }
                }
            }
        }.toString();
    }

    public String insertDocument(Document document) {
        return new SQL() {
            {
                INSERT_INTO(DOCUMENTTABLE);
                if (document.getTitle()!= null && !document.getTitle().equals("")) {
                    VALUES("title","#{title}");
                }
                if (document.getFileName()!= null && !document.getFileName().equals("")) {
                    VALUES("filename","#{fileName}");
                }
                if (document.getRemark()!= null && !document.getRemark().equals("")) {
                    VALUES("remark","#{remark}");
                }
                if (document.getUser()!= null && document.getUser().getId()!= null) {
                    VALUES("user_id","#{user.id}");
                }
            }
        }.toString();
    }

    public String updateDocument(Document document) {
        return new SQL() {
            {
                UPDATE(DOCUMENTTABLE);
                if (document.getTitle() != null && !document.getTitle().equals("")) {
                    SET(" title = #{title} ");
                }
                if (document.getFileName() != null && !document.getFileName().equals("")) {
                    SET(" filename = #{fileName} ");
                }
                if (document.getRemark() != null && !document.getRemark().equals("")) {
                    SET(" remark = #{remark} ");
                }
                if (document.getUser() != null && document.getUser().getId() != null) {
                    SET(" user_id = #{user.id} ");
                }
                WHERE(" id = #{id}");
            }
        }.toString();
    }
}