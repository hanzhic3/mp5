package com.example.mp5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* the right result. */
    private float rightResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getpractice();
        Button done = findViewById(R.id.done);
        done.setOnClickListener(v -> afterDone());
        Button rightanswer = findViewById(R.id.rightanswer);
        rightanswer.setOnClickListener(v -> {
            TextView result = findViewById(R.id.result);
            result.setVisibility(View.VISIBLE);
            result.setText(String.valueOf(rightResult));
            result.setTextColor(Color.GREEN);
        });
        Button practice = findViewById(R.id.practice);
        practice.setOnClickListener(v -> {
            findViewById(R.id.result).setVisibility(View.INVISIBLE);
            findViewById(R.id.result).setVisibility(View.INVISIBLE);
            findViewById(R.id.end).setVisibility(View.INVISIBLE);
            findViewById(R.id.practice).setVisibility(View.INVISIBLE);
            findViewById(R.id.rightanswer).setVisibility(View.INVISIBLE);
            EditText answer = findViewById(R.id.answer);
            answer.setText("");
            getpractice();
        });

        Button end = findViewById(R.id.end);
        end.setOnClickListener(v -> finish());
    }

    @SuppressLint("SetTextI18n")
    private void getpractice() {
        Random randomnumber = new Random();
        DecimalFormat form = new DecimalFormat("0.00");
        int number1 = randomnumber.nextInt(100);
        int number2 = randomnumber.nextInt(99) + 1;
        String numbera = String.valueOf(number1);
        String numberb = String.valueOf(number2);
        int number = randomnumber.nextInt(4);
        TextView question = findViewById(R.id.question);
        switch (number) {
            case 0:
                rightResult = number1 + number2;
                question.setText(numbera + "+" + numberb + "=");
                break;
            case 1:
                rightResult = number1 - number2;
                question.setText(numbera + "-" + numberb + "=");
                break;
            case 2:
                rightResult = number1 * number2;
                question.setText(numbera + "*" + numberb + "=");
                break;
            case 3:
                rightResult = Float.parseFloat(form.format((float) number1 / number2));
                question.setText(numbera + "/" + numberb + "=");
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void afterDone() {
        TextView result = findViewById(R.id.result);
        EditText answer = findViewById(R.id.answer);
        if (answer.getText().toString().equals("")) {
            result.setText("Please give us a number");
            result.setTextColor(Color.RED);
            result.setVisibility(View.VISIBLE);
            return;
        }

        result.setVisibility(View.VISIBLE);
        findViewById(R.id.practice).setVisibility(View.VISIBLE);
        findViewById(R.id.end).setVisibility(View.VISIBLE);
        findViewById(R.id.rightanswer).setVisibility(View.VISIBLE);
        float userResult = Float.parseFloat(answer.getText().toString());
        if (userResult == rightResult) {
            result.setText("Right");
            result.setTextColor(Color.GREEN);
        } else if (userResult != rightResult) {
            result.setText("Wrong");
            result.setTextColor(Color.RED);
        }

    }
}