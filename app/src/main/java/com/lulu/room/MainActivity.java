package com.lulu.room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lulu.room.adapter.UserAdapter;
import com.lulu.room.database.AppDatabase;
import com.lulu.room.database.entitas.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppDatabase database;
    private UserAdapter userAdapter;
    private final List<User>list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inisialisasi
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Button btnTambah = findViewById(R.id.btn_tambah);

        database = AppDatabase.getInstance(getApplicationContext());
        list.clear();
        list.addAll(database.userDao().getAll());
        userAdapter = new UserAdapter(getApplicationContext(), list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);

        btnTambah.setOnClickListener(view -> {
            // mengarahkan ke akivity tambah
            startActivity(new Intent(MainActivity.this, TambahActivity.class));
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    protected void onStart(){
        super.onStart();
        list.clear();
        list.addAll(database.userDao().getAll());
        userAdapter.notifyDataSetChanged();
    }
}