package com.example.taskify.data.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.taskify.data.local.TaskDatabase;
import com.example.taskify.data.local.dao.TaskDao;
import com.example.taskify.data.local.entity.TaskEntity;
import java.util.List;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<TaskEntity>> allTasks;
    private LiveData<List<TaskEntity>> completedTasks;

    public TaskRepository(Application application){
        TaskDatabase database = TaskDatabase.getInstance(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getAllTasks();
        completedTasks = taskDao.getCompleatedTasks();
    }

    public LiveData<List<TaskEntity>> getAllTasks(){
        return allTasks;
    }

    public LiveData<List<TaskEntity>> getCompletedTasks() {
        return completedTasks;
    }

    public void insert(TaskEntity task){
        new Thread(() -> taskDao.insertTask(task)).start();
    }

    public void update(TaskEntity task){
        new Thread(() -> taskDao.updateTask(task)).start();
    }

    public void delete(TaskEntity task){
        new Thread(() -> taskDao.deleteTask(task)).start();
    }
}
