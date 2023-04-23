package com.hello.board.entity;

import java.sql.Date;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@EnableJpaRepositories
@Table(name ="board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String title;

    private String writer;

    private String date;

    private String mainText;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getDate() {
        return date;
    }
    
    public String getMainText() {
        return mainText;
    }
    
}
