package com.example.mp5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class launchAcitivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);

        Button start = findViewById(R.id.start);
        start.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }

}

