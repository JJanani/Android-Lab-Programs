package com.example.aakash.lab_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variable Declarations

    EditText fn,ln;
    RadioGroup rg;
    RadioButton btn;
    Button con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Display Notification for OnCreate
        Toast.makeText(this,"Activity-1-Create",Toast.LENGTH_SHORT).show();

        //Finding the locations of the XML Parts
        fn = findViewById(R.id.FirstName);
        ln = findViewById(R.id.LastName);
        con = findViewById(R.id.Button1);

        //Button Event and Event Listener
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newpage(v);
            }
        });
    }
    //Life Cycle Events of Activity - 1
    @Override
    public void onStart()
    {
        super.onStart();
        Toast.makeText(this,"Activity-1-Start",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onResume()
    {
        super.onResume();
        Toast.makeText(this,"Activity-1-Resume",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause()
    {
        super.onPause();
        Toast.makeText(this,"Activity-1-Pause",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        Toast.makeText(this,"Activity-1-Restart",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"Activity-1-Destroy",Toast.LENGTH_SHORT).show();
    }


    //Response to Clicking the Button
    public void newpage(View v)
    {
        //Intent
        Intent intent = new Intent(MainActivity.this,SecondPage.class);

        //Retrieving fromEditText
        String first = fn.getText().toString();
        String last = ln.getText().toString();
        int selected;

        //Finding RadioGroup
        rg = findViewById(R.id.RadioGender);

        //Getting Selected Radio Button Value
        selected = rg.getCheckedRadioButtonId();
        btn = findViewById(selected);
        String choice = (String)btn.getText();

        //Bundle Intent for multiple data transfer
        Bundle b = new Bundle();
        b.putString("FirstName",first);
        b.putString("LastName",last);
        b.putString("Gender",choice);
        intent.putExtras(b);
        startActivity(intent);

    }
}