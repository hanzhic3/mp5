package com.example.mp5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /* the right result. */
    private int rightResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean result(int userResult) {
        if (userResult == rightResult) {
            return true;
        }
        return false;
    }
}
