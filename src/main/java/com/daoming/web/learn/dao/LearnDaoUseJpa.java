package com.daoming.web.learn.dao;

import com.daoming.web.learn.domain.LearnResourceUseJpa;
import org.apache.ibatis.annotations.Delete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface LearnDaoUseJpa extends JpaRepository<LearnResourceUseJpa, Long> {
    List<LearnResourceUseJpa> findByAuthor(String name);

    @Override
    Page<LearnResourceUseJpa> findAll(Pageable pageable);

    @Transactional
    @Modifying
    @Delete("delete from learn_resource_use_jpa where author = ?1")
    void deleteByAuthor(String author);

}
