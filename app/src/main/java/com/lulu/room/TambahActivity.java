package com.lulu.room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.lulu.room.database.AppDatabase;

public class TambahActivity extends AppCompatActivity {
    //inisialisasi
    private EditText editName, editEmail;
    public Button btnSave;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        editName = findViewById(R.id.full_Name);
        editEmail = findViewById(R.id.email);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        btnSave.setOnClickListener(view -> {
            //mengambil entitas user

            database.userDao().insertAll(editName.getText().toString(), editEmail.getText().toString());

            //menutup aktivity setelah di simpan
            finish();



        });
    }
}