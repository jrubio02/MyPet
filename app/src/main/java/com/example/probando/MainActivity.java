package com.example.probando;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import com.example.probando.db.DbHelper;

public class MainActivity extends AppCompatActivity {
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btnadoptar);
        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db != null){
            //Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BBDD", Toast.LENGTH_LONG).show();

        }
        button.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(MainActivity.this,FLogin.class);
                startActivity(intent);
            }
        });
        }
    }
