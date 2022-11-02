package com.example.probando.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper{

    Context context;
    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarUsuario(String nombre, String email, String telefono, String password)
    {
        long id = 0;
        try {


            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("nombre", nombre);
            values.put("email", email);
            values.put("telefono", telefono);
            values.put("password", password);

            id = db.insert(TABLE_USUARIOS, null, values);
        } catch(Exception ex)
        {
            ex.toString();
        }
        return id;

    }
}
