package com.hello.board.dto;

import java.sql.Date;

import com.hello.board.entity.Board;

public class BoardDto{
    private Long id;

    private String title;

    private String writer;

    private String date;

    private String mainText;



    public BoardDto(){

    }

    public BoardDto(Long id, String title, String writer, String date, String mainText){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.mainText  = mainText;
        
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getWriter() {
        return writer;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
    public void setMainText(String mainText) {
        this.mainText = mainText;
    }
    public String getMainText() {
        return mainText;
    }



    
}
