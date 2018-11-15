package com.daoming.web.dao;

import com.daoming.web.domain.LearnResource;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//http://tengj.top/2017/04/23/springboot9/
@Component
@Mapper
public interface LearnMapper {
    @Insert("insert into learn_resource(author,title,url) values(#{author},#{title},#{url})")
    int add(LearnResource learnResource);

    @Update("update learn_resource set author=#{author},title=#{title},url=#{url} where id = #{id}")
    int update(LearnResource learnResource);

    @DeleteProvider(type = LearnSqlBuilder.class, method = "deleteByIds")
    int deleteByIds(@Param("ids") String[] ids);

    @SelectProvider(type = LearnSqlBuilder.class, method = "queryLearnResourceByParams")
    List<LearnResource> queryLearnResourceList(Map<String, Object> params);

    @Select("select * from learn_resource where id = #{id}")
    @Results(
            id = "learnMap", value = {
            @Result(property = "id", column = "id", javaType = Long.class),
            @Result(property = "author", column = "author", javaType = String.class),
            @Result(property = "title", column = "title", javaType = String.class)
    }
    )
    LearnResource queryLearnResourceById(@Param("id") Long id);

    class LearnSqlBuilder {
        public String queryLearnResourceByParams(final Map<String, Object> params) {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from learn_resource where 1=1");
            if (!StringUtils.isNullOrEmpty((String) params.get("author"))) {
                sql.append(" and author like '%").append((String) params.get("author")).append("%'");
            }
            if (!StringUtils.isNullOrEmpty((String) params.get("title"))) {
                sql.append(" and title like '%").append((String) params.get("title")).append("%'");
            }
            System.out.println("查询sql==" + sql.toString());
            return sql.toString();
        }

        //删除的方法
        public String deleteByIds(@Param("ids") final String[] ids) {
            StringBuffer sql = new StringBuffer();
            sql.append("DELETE FROM learn_resource WHERE id in(");
            for (int i = 0; i < ids.length; i++) {
                if (i == ids.length - 1) {
                    sql.append(ids[i]);
                } else {
                    sql.append(ids[i]).append(",");
                }
            }
            sql.append(")");
            return sql.toString();
        }
    }
}
