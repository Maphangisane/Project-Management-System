package com.algoExpert.demo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Member {
    //member entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer member_id;

    private Integer user_id;

    private Integer project_id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> taskList;

    public Member() {
    }

    public Member(Integer member_id, Integer user_id, Integer project_id, List<Task> taskList) {
        this.member_id = member_id;
        this.user_id = user_id;
        this.project_id = project_id;
        this.taskList = taskList;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
