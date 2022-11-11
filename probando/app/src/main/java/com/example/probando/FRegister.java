package com.example.probando;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.probando.db.DbContactos;

public class FRegister extends AppCompatActivity {

    EditText txtNombre, txtEmail, txtPassword, txtPhone;

    public Button button;
    public Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fregister);


        button = (Button) findViewById(R.id.enlace_registro);
        txtNombre = findViewById(R.id.txtNombre);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtPhone = findViewById(R.id.txtPhone);

        btnRegistro =  findViewById(R.id.btnRegister);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FRegister.this, FLogin.class);
                startActivity(intent);
            }


        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(FRegister.this);
                long id = dbContactos.insertarUsuario(
                        txtNombre.getText().toString(),
                        txtEmail.getText().toString(),
                        txtPhone.getText().toString(),
                        txtPassword.getText().toString());



                if (id > 0) {
                    Toast.makeText(FRegister.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    Log.d(txtNombre.getText().toString(), "");
                    limpiar();
                } else {
                    Toast.makeText(FRegister.this, "ERROR AL GUARDAR", Toast.LENGTH_LONG).show();

                }


            }
        });
    }

    private void limpiar()
    {
        txtNombre.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtPhone.setText("");
    }

}
