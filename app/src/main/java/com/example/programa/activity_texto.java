package com.example.programa;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_texto extends AppCompatActivity {

    EditText editText;
    CheckBox checkBoxBold;
    CheckBox checkBoxItalic;
    Button buttonDecrease;
    Button buttonIncrease;
    TextView text;

    Button trans;
    float size=16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);
        editText=findViewById(R.id.editTextMultiline);
        text=findViewById(R.id.textViewDisplay);

        checkBoxBold=findViewById(R.id.checkBoxBold);
        checkBoxItalic=findViewById(R.id.checkBoxItalic);


        trans=findViewById(R.id.btn_transformar);

        buttonDecrease=findViewById(R.id.buttonDecreaseTextSize);
        buttonIncrease=findViewById(R.id.buttonIncreaseTextSize);
        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size += 2;
                text.setTextSize(size);
            }
        });

        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (size > 2) {
                    size -= 2;
                    text.setTextSize(size);
                }
            }
        });

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isCheckedBold = checkBoxBold.isChecked();
                boolean isCheckedItalic = checkBoxItalic.isChecked();

                if (isCheckedBold && !isCheckedItalic) {
                    String inputText = editText.getText().toString();
                    SpannableString spannableString = new SpannableString(inputText);
                    StyleSpan boldSpan = new StyleSpan(android.graphics.Typeface.BOLD);
                    spannableString.setSpan(boldSpan, 0, spannableString.length(), SpannableString.SPAN_INCLUSIVE_INCLUSIVE);

                    text.setText(spannableString);
                }else{
                    Toast.makeText(activity_texto.this, "solo puedes escoger uno", Toast.LENGTH_SHORT).show();
                }
                if (isCheckedItalic && !isCheckedBold) {
                    String inputText = editText.getText().toString();

                    SpannableString spannableString = new SpannableString(inputText);
                    StyleSpan italicSpan = new StyleSpan(android.graphics.Typeface.ITALIC);
                    spannableString.setSpan(italicSpan, 0, spannableString.length(), SpannableString.SPAN_INCLUSIVE_INCLUSIVE);

                    text.setText(spannableString);
                }else{
                    Toast.makeText(activity_texto.this, "solo puedes escoger uno", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}