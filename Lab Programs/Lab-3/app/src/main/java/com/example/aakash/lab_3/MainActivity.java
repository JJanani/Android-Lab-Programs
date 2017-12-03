package com.example.aakash.lab_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.sp);
        btn2 = findViewById(R.id.db);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shared(v);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database(v);
            }
        });
    }
    public void shared (View v)
    {
        Intent intent = new Intent(MainActivity.this,Shared.class);
        startActivity(intent);
    }
    public void database(View v)
    {
        Intent intent = new Intent(MainActivity.this,Database.class);
        startActivity(intent);
    }
}
