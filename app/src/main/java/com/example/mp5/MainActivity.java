package com.example.mp5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* the right result. */
    private double rightResult;

    /* the user result. */
    private double userResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    private void getpractice() {
        Random randomnumber = new Random();
        DecimalFormat form = new DecimalFormat("0.00");
        int number1 = randomnumber.nextInt(100);
        int number2 = randomnumber.nextInt(100);
        String numbera = String.valueOf(number1);
        String numberb = String.valueOf(number2);
        int number = randomnumber.nextInt(4);
        TextView question = findViewById(R.id.question);
        switch (number) {
            case 0:
                rightResult = number1 + number2;
                question.setText(numbera + "+" + numberb + "=");
            case 1:
                rightResult = number1 - number2;
                question.setText(numbera + "-" + numberb + "=");
            case 2:
                rightResult = number1 * number2;
                question.setText(numbera + "*" + numberb + "=");
            case 3:
                rightResult = Double.parseDouble(form.format(number1 / number2));
                question.setText(numbera + "/" + numberb + "=");
        }
    }

    public void afterDone() {
        if (userResult == rightResult) {
            findViewById(R.id.right).setVisibility(View.VISIBLE);
            findViewById(R.id.practice).setVisibility(View.VISIBLE);
            findViewById(R.id.end).setVisibility(View.VISIBLE);
        } else if (userResult != rightResult) {
            findViewById(R.id.wrong).setVisibility(View.VISIBLE);
            findViewById(R.id.practice).setVisibility(View.VISIBLE);
            findViewById(R.id.end).setVisibility(View.VISIBLE);
        }

    }

    public void getResult() {
        Button done = findViewById(R.id.done);
        done.setOnClickListener(v -> {
            afterDone();
        });

        Button practice = findViewById(R.id.practice);
        practice.setOnClickListener(v -> {
            getpractice();
        });

        Button end = findViewById(R.id.end);
        end.setOnClickListener(v -> {
            finish();
        });
    }
}
