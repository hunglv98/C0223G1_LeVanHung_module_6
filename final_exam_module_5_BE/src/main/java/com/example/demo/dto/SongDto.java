package com.example.demo.dto;

import com.example.demo.model.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    @Size(max = 40)
    private String singer;
    @NotBlank
    @Size(max = 40)
    private String author;
    @NotBlank
    private int like;
    @NotBlank
    private String time;

    private Status status;

    public SongDto() {
    }

    public SongDto(int id, String name, String singer, String author, int like, String time, Status status) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.author = author;
        this.like = like;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
