package com.example.programa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button bt_texto;
        bt_texto=findViewById(R.id.texto_id);

        Button bt_fisica;
        bt_fisica=findViewById(R.id.fisica_id);

        Button btn_mate;
        btn_mate=findViewById(R.id.mate_id);
        texto=findViewById(R.id.txt);

        btn_mate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent matematicas = new Intent(MainActivity2.this,activity_matematica.class);
                startActivity(matematicas);
            }
        });

        bt_fisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fisica = new Intent(MainActivity2.this, Activity_fisica.class);
                startActivity(fisica);
            }
        });

        bt_texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent texto = new Intent(MainActivity2.this, activity_texto.class);
                startActivity(texto);
            }
        });


    }
    public void anterior(View v){
        Intent anterior = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(anterior);
    }

}