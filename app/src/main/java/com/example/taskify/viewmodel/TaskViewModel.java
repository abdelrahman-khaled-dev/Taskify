package com.example.taskify.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.taskify.data.local.entity.TaskEntity;
import com.example.taskify.data.repository.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository repository;
    private LiveData<List<TaskEntity>> allTasks;
    private LiveData<List<TaskEntity>> compleatedTasks;
    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
        compleatedTasks = repository.getCompletedTasks();
    }

    public LiveData<List<TaskEntity>> getAllTasks() {
        return allTasks;
    }

    public LiveData<List<TaskEntity>> getCompleatedTasks() {
        return compleatedTasks;
    }

    public void insert(TaskEntity task){
        repository.insert(task);
    }

    public void update(TaskEntity task){
        repository.update(task);
    }

    public void delete(TaskEntity task){
        repository.delete(task);
    }
}
