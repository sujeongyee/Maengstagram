package com.maeng.board.model;

import java.sql.Date;

public class BoardVO {

    private int number;
    private String content;
    private String img;
    private Date time;

    public BoardVO() {
    }

    public BoardVO(int number, String content, String img, Date time) {
        this.number = number;
        this.content = content;
        this.img = img;
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}
