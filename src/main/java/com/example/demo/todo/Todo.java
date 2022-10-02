package com.example.demo.todo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Entity
@Table
public class Todo {

    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private Long id;
    private String title;
    private String content;
    private LocalDateTime date;
    private Integer remainingTime;
    @Transient
    private String place;
    //id,title,content,date,remainintime,place


    public Todo() {
    }

    public Todo(Long id, String title, String content, String place, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.place = place;
    }


    public Todo(String title, String content, String place, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setRemainingTime(Integer remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getRemainingTime() {
        return ChronoUnit.HOURS.between(date,LocalDateTime.now());
    }


}
