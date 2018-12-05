package com.daoming.web.dao;

import com.daoming.web.domain.LearnResourceUseJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearnDaoUseJpa extends JpaRepository<LearnResourceUseJpa, Long> {
    List<LearnResourceUseJpa> findByAuthor(String name);

    @Override
    Page<LearnResourceUseJpa> findAll(Pageable pageable);
}
