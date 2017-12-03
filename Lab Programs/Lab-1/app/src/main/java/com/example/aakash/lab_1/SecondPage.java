package com.example.aakash.lab_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondPage extends AppCompatActivity {

    //Variable Declarations
    TextView text;
    Button btn1,btn2;
    String fn,ln,g;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        Toast.makeText(this,"Activity-2-Create",Toast.LENGTH_SHORT).show();

        btn1=findViewById(R.id.Previous);
        btn2=findViewById(R.id.Exit);
        text = findViewById(R.id.Submission);

        //Getting complete intent bundle from the other activity
        Bundle b = getIntent().getExtras();
        fn = b.getString("FirstName");
        ln = b.getString("LastName");
        g = b.getString("Gender");

        //Assigning the TextView text
        text.setText("First Name: "+fn+"\n"+"Last Name: "+ln+"\n"+"Gender: "+g);

        //To go to Previous Page Button Listener
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous(v);
            }
        });

        //To Exit Application Button Listener
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end(v);
            }
        });

    }

    //Previous Page Function Intent
    public void previous(View v)
    {
        Intent intent = new Intent(SecondPage.this,MainActivity.class);
        startActivity(intent);
    }

    //Exit Application Function Intent
    public void end(View v)
    {
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //Life Cycle Events Activity - 2
    @Override
    public void onStart()
    {
        super.onStart();
        Toast.makeText(this,"Activity-2-Start",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onResume()
    {
        super.onResume();
        Toast.makeText(this,"Activity-2-Resume",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause()
    {
        super.onPause();
        Toast.makeText(this,"Activity-2-Pause",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        Toast.makeText(this,"Activity-2-Restart",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"Activity-2-Destroy",Toast.LENGTH_SHORT).show();
    }
}