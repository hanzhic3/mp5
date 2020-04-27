package com.example.mp5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* the right result. */
    private double rightResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean result(double userResult) {
        return userResult == rightResult;
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
}
