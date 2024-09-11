package com.example.ac1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView feedbackText, notaText;
    private RadioGroup Questão1, Questão2, Questão3;
    private Button validarButton, resetButton;
    private int nota = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        feedbackText = findViewById(R.id.feedbackText);
        notaText = findViewById(R.id.notaText);
        Questão1 = findViewById(R.id.radioGroupQuestion1);
        Questão2 = findViewById(R.id.radioGroupQuestion2);
        Questão3 = findViewById(R.id.radioGroupQuestion3);
        validarButton = findViewById(R.id.validarButton);
        resetButton = findViewById(R.id.resetarButton);


        validarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaQuestão();
            }
        });


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetar();
            }
        });
    }

    private void validaQuestão() {

        nota = 0;


        feedbackText.setText("");


        int selectedId1 = Questão1.getCheckedRadioButtonId();
        if (selectedId1 == R.id.respostaCerta) {
            nota++;
            feedbackText.append("Questão 1: Resposta certa!\n");
        } else {
            feedbackText.append("Questão 1: Errou\n");
        }


        int selectedId2 = Questão2.getCheckedRadioButtonId();
        if (selectedId2 == R.id.respostaCerta2) {
            nota++;
            feedbackText.append("Questão 2: Resposta certa!\n");
        } else {
            feedbackText.append("Questão 2: Errou\n");
        }


        int selectedId3 = Questão3.getCheckedRadioButtonId();
        if (selectedId3 == R.id.respostaCerta3) {
            nota++;
            feedbackText.append("Questão 3: Resposta certa!\n");
        } else {
            feedbackText.append("Questão 3: Errou.\n");
        }


        notaText.setText("Acertou: " + nota + "/3");
    }


    private void resetar() {

        Questão1.clearCheck();
        Questão2.clearCheck();
        Questão3.clearCheck();


        feedbackText.setText("");
        notaText.setText("Nota: 0");
    }
}
