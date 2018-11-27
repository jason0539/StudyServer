package com.daoming.web.dao;

import com.daoming.web.domain.LearnResourceUseJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearnDaoUseJpa extends JpaRepository<LearnResourceUseJpa, Long> {
    List<LearnResourceUseJpa> findByAuthor(String name);
}
