package com.algoExpert.demo.Dto;

import com.algoExpert.demo.Entity.Comment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class TaskDto {

    private Integer task_id;
    private String title;
    private String description;
    private int owner;
    private String start_date;
    private String end_date;
    private String status;
    private String priority;
    List<Comment> comments;

    public TaskDto() {
    }

    public TaskDto(Integer task_id, String title, String description, int owner, String start_date, String end_date, String status, String priority, List<Comment> comments) {
        this.task_id = task_id;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.priority = priority;
        this.comments = comments;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
