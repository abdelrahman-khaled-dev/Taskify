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

    public TaskRepository(Application application){
        TaskDatabase database = TaskDatabase.getInstance(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getAllTasks();
    }

    public LiveData<List<TaskEntity>> getAllTasks(){
        return allTasks;
    }
}
