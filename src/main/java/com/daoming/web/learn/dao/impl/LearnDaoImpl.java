package com.daoming.web.learn.dao.impl;

import com.daoming.web.learn.dao.LearnDao;
import com.daoming.web.learn.domain.LearnResource;
import com.daoming.web.tools.Page;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LearnDaoImpl implements LearnDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(LearnResource learnResource) {
        return jdbcTemplate.update("insert into learn_resource(author,title,url) values(?,?,?)",
                learnResource.getAuthor(), learnResource.getTitle(), learnResource.getUrl());
    }

    @Override
    public int update(LearnResource learnResource) {
        return jdbcTemplate.update("update learn_resource set author=?,title=?,url=? where id = ?"
                , new Object[]{learnResource.getAuthor(), learnResource.getTitle(), learnResource.getUrl()});
    }

    @Override
    public int deleteById(String id) {
        return jdbcTemplate.update("delete from learn_resource where id in(" + id + ")");
    }

    @Override
    public LearnResource queryLearnResourceById(Long id) {
        List<LearnResource> list = jdbcTemplate.query("select * from learn_resource where id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(LearnResource.class));
        if (list != null && list.size() > 0) {
            LearnResource learnResource = list.get(0);
            return learnResource;
        }
        return null;
    }

    @Override
    public Page queryLearnResourceList(Map<String, Object> params) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from learn_resource where 1=1");
        if (!StringUtils.isNullOrEmpty((String) params.get("author"))) {
            sql.append(" and author like '%").append(params.get("author")).append("'%");
        }
        if (!StringUtils.isNullOrEmpty((String) params.get("title"))) {
            sql.append(" and title like '%").append(params.get("title")).append("'%");
        }
        Page page = new Page(sql.toString(), Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()), jdbcTemplate);
        return page;
    }
}
