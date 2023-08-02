package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String singer;
    private String author;
    private int numberLike;
    private String duration;

    @ManyToOne
    private Status status;

    public Song() {
    }

    public Song(String name, String singer, String author, int numberLike, String duration, Status status) {
        this.name = name;
        this.singer = singer;
        this.author = author;
        this.numberLike = numberLike;
        this.duration = duration;
        this.status = status;
    }

    public Song(int id, String name, String singer, String author, int numberLike, String duration, Status status) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.author = author;
        this.numberLike = numberLike;
        this.duration = duration;
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

    public int getNumberLike() {
        return numberLike;
    }

    public void setNumberLike(int numberLike) {
        this.numberLike = numberLike;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
