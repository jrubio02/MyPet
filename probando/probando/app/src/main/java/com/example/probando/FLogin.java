package com.example.probando;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.probando.db.DbContactos;
import com.example.probando.db.DbHelper;

public class FLogin extends AppCompatActivity {
    public Button button;
    public Button btnLogin;
    EditText txtEmailLogin, txtPasswordLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flogin);

        button = (Button) findViewById(R.id.enlace_registro);

        txtEmailLogin = findViewById(R.id.txtEmailLogin);
        txtPasswordLogin = findViewById(R.id.txtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FLogin.this,FRegister.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(FLogin.this);
                SQLiteDatabase db = dbContactos.getWritableDatabase();
                String email =  txtEmailLogin.getText().toString();
                String password = txtPasswordLogin.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                    Cursor fila = db.rawQuery("Select email, password from t_usuarios where email= '" + email + "' and password='" + password + "'",null);

                    if (fila.moveToFirst()){
                        Intent login = new Intent(FLogin.this, MainActivity.class);
                        startActivity(login);
                        db.close();
                    }
                    else{

                        Toast.makeText( FLogin.this, "No se encontraron datos del usuario", Toast.LENGTH_SHORT ).show();
                        db.close();
                    }
                }else{
                    Toast.makeText( FLogin.this, "Debes introducir un correo y una contraseña", Toast.LENGTH_SHORT).show();
                }
                }

        });
    }
}
