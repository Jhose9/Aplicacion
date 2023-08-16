package com.example.programa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText txtname;
    EditText txtpassword;

    ProgressBar pro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncancelar;
        btncancelar=findViewById(R.id.btn_cancelar);

        CheckBox checkBox;
        checkBox=findViewById(R.id.cb_login);

        Button btnLogin;
        btnLogin=findViewById(R.id.btn_login);

        txtname=findViewById(R.id.txt_name);
        txtpassword=findViewById(R.id.txtpassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pro = findViewById(R.id.progressBar);

                String name=txtname.getText().toString();
                String password=txtpassword.getText().toString();
                boolean isChecked = checkBox.isChecked();

                Intent siguiente = new Intent(MainActivity.this, MainActivity2.class);
                if (isChecked) {
                    if (name.equals("Admin") && password.equals("admin123")) {
                        pro.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "Está correcto", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                pro.setVisibility(View.GONE);
                                startActivity(siguiente);
                            }
                        }, 2000);
                    }else{
                        Toast.makeText(MainActivity.this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "tiene que aceptar los terminos", Toast.LENGTH_SHORT).show();
                }



            }
        });

        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtname.setText("");
                txtpassword.setText("");
            }
        });

    }
}