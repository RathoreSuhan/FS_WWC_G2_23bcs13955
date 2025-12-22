package com.example.JavaMini.model;

public class Event {
    private int id;
    private String name;
    private String course;

    public Event(int id , String name , String course){
        this.id = id;
        this.name = name;
        this.course =course;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getCourse(){
        return course;
    }
    public void setId(int id){
        this.id =id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setCourse(String course){
        this.course=course;
    }

    
}
