package com.lulu.room.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.lulu.room.database.entitas.User;

import java.util.List;

@Dao
public interface UserDao {
    //mengambil data
    @Query("SELECT * FROM user")
    List<User> getAll();

    //menaambahkan data
    @Query("INSERT INTO user(name,email) VALUES(:name,:email)")
    void insertAll(String name, String email);

    //Menghapus data
    @Delete
    void delete(User user);


}
