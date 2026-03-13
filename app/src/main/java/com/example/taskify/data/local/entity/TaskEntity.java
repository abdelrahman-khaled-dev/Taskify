package com.example.taskify.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class TaskEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "priority")
    private int priority;

    @ColumnInfo(name = "isDone")
    private boolean isDone;

    @ColumnInfo(name = "createdAt")
    private boolean createdAt;

    public TaskEntity(String title, String description, int priority, boolean isDone, boolean createdAt) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isDone = isDone;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(boolean createdAt) {
        this.createdAt = createdAt;
    }
}
