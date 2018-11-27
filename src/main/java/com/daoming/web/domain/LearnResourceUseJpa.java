package com.daoming.web.domain;

import com.daoming.web.dao.LearnDaoUseJpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LearnResourceUseJpa implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = false)
    private String url;

    @Transient
    private String temp;

    public LearnResourceUseJpa(){

    }

    public LearnResourceUseJpa(Long id, String author, String title, String url,String temp) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.url = url;
        this.temp = temp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
