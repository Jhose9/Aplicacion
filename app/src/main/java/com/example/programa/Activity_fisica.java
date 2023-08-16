package com.example.programa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_fisica extends AppCompatActivity {
    EditText editTextVelocity;
    EditText editTextTime;
    Button calculateDistanceButton;
    TextView resultDistanceTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);


        editTextVelocity = findViewById(R.id.editTextVelocity);
        editTextTime = findViewById(R.id.editTextTime);
        calculateDistanceButton = findViewById(R.id.calculateDistanceButton);
        resultDistanceTextView = findViewById(R.id.resultDistanceTextView);


        calculateDistanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateDistance();
            }
        });
    }
    private void calculateDistance() {
        try {
            double velocity = Double.parseDouble(editTextVelocity.getText().toString());
            double time = Double.parseDouble(editTextTime.getText().toString());

            double distance = velocity * time;

            String result = "Distancia recorrida: " + distance + " metros";
            resultDistanceTextView.setText(result);
        } catch (NumberFormatException e) {
            resultDistanceTextView.setText("Ingresa valores válidos");
        }




    }
}