package com.maeng.board.model;

import java.sql.Date;
import java.sql.Timestamp;

public class BoardVO {

    private String number;
    private String id;
    private String content;
    private String img;
    private Timestamp time;

    public BoardVO() {
    }

    public BoardVO(String number, String id,String content, String img, Timestamp time) {
        this.number = number;
        this.id = id;
        this.content = content;
        this.img = img;
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


}
