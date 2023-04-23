package com.hello.board.domain;

import java.util.Date;

public class Board {
    private Long id;

    private String boardName;

    private Date date;

    private String memberName;

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setMemberName(String memberName){
        this.memberName = memberName;
    }

    public String getMemberName(){
        return memberName;
    }
    
}
