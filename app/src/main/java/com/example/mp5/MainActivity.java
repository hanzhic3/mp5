package com.example.mp5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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
        if (userResult == rightResult) {
            return true;
        }
        return false;
    }

    private String getpractice() {
        Random randomnumber = new Random();
        DecimalFormat form = new DecimalFormat("0.0");
        String number1 = form.format(randomnumber.nextDouble() * 100);
        String number2 = form.format(randomnumber.nextDouble() * 100);
        double numbera = Double.parseDouble(number1);
        double numberb = Double.parseDouble(number2);
        int number = randomnumber.nextInt(4);
        switch (number) {
            case 0:
                rightResult = numbera + numberb;
                return number1 + "+" + number2 + "=";
            case 1:
                rightResult = numbera - numberb;
                return number1 + "-" + number2 + "=";
            case 2:
                rightResult = numbera * numberb;
                return number1 + "*" + number2 + "=";
            case 3:
                /*需要完善除法小数点问题*/
                rightResult = numbera / numberb;
                return number1 + "/" + number2 + "=";
        }
        return "Wrong";
    }
}
