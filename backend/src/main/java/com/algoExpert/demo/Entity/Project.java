package com.algoExpert.demo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer project_id;
    private String title;
    private String description;

    //    relationships
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Table> tables;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> memberList;

    @ManyToOne
    private User user;

    public Project() {
    }

    public Project(Integer project_id, String title, String description, List<Table> tables, List<Member> memberList, User user) {
        this.project_id = project_id;
        this.title = title;
        this.description = description;
        this.tables = tables;
        this.memberList = memberList;
        this.user = user;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Member> getMembersList() {
        return memberList;
    }

    public void setMembersList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
