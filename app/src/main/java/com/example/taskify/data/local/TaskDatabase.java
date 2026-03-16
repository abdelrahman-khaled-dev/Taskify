package com.example.taskify.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.taskify.data.local.dao.TaskDao;
import com.example.taskify.data.local.entity.TaskEntity;

@Database(entities = {TaskEntity.class},version = 1)
public abstract class TaskDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();

    private static TaskDatabase instance;

    public static synchronized TaskDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), TaskDatabase.class, "task_database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
