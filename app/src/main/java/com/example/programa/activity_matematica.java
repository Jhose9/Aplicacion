package com.example.programa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_matematica extends AppCompatActivity {


     EditText editTextA;
     EditText editTextB;
     EditText editTextC;
    TextView resultTextView;
    private Button calculateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematica);
        ImageButton btn_mate_back;

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.valor_id);


        registerForContextMenu(editTextA);
        registerForContextMenu(editTextB);
        registerForContextMenu(editTextC);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateRoots();
            }
        });



    }
    private void calculateRoots() {
        try {
            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());
            double c = Double.parseDouble(editTextC.getText().toString());

            double discriminant = b * b - 4 * a * c;

            if (discriminant < 0) {
                resultTextView.setText("La función no tiene raíces reales.");
            } else {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

                String result = "Raíz 1: " + root1 + "\nRaíz 2: " + root2;
                resultTextView.setText(result);
            }
        } catch (NumberFormatException e) {
            resultTextView.setText("Ingrese valores válidos para a, b y c.");
        }
    }

}