package com.example.taskify.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.taskify.data.local.entity.TaskEntity;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    public void insertTask(TaskEntity task);

    @Delete
    public void deleteTask(TaskEntity task);

    @Update
    public void updateTask(TaskEntity task);

    @Query("SELECT * FROM tasks ORDER BY createdAt DESC")
    LiveData<List<TaskEntity>> getAllTasks();

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    TaskEntity getTaskById(int taskId);

    @Query("SELECT * FROM tasks WHERE isDone = 1")
    LiveData<List<TaskEntity>> getCompleatedTask();

}
