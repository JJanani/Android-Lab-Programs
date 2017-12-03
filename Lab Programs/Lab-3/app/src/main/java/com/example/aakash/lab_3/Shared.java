package com.example.aakash.lab_3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Shared extends AppCompatActivity {

    TextView tv;
    EditText etName,etUsn;
    Button bsave,bview,bdelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        tv = findViewById(R.id.tevi);
        etName= (EditText) findViewById(R.id.name);
        etUsn= (EditText) findViewById(R.id.usn);
        bsave= (Button) findViewById(R.id.save);
        bview= (Button) findViewById(R.id.view);

        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

                String name = sharedpref.getString("name","");
                String usn = sharedpref.getString("usn","");

                tv.setText(name + "\n" + usn);

            }
        });
        bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpref.edit();
                editor.putString("name",etName.getText().toString());
                editor.putString("usn",etUsn.getText().toString());
                editor.apply();

                Toast.makeText(Shared.this,"Saved",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
