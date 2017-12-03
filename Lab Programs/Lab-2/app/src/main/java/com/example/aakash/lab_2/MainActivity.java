package com.example.aakash.lab_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.NextButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewMenu(v);
            }
        });
        Button btn1 = findViewById(R.id.ExitButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit(v);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        TextView opt1 = findViewById(R.id.TextView2);
        switch(item.getItemId())
        {
            case R.id.Option1:
                opt1.setText("Images");
                return true;
            case R.id.Option2:
                opt1.setText("Shapes");
                return true;
            case R.id.Option3:
                opt1.setText("Background");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void NewMenu(View v)
    {
        TextView opt1 = findViewById(R.id.TextView2);
        String typ = opt1.getText().toString();
        if(typ.equals("Images"))
        {
            Intent intent = new Intent(this,image.class);
            startActivity(intent);
        }
        if(typ.equals("Shapes"))
        {
            Intent intent = new Intent(this,shape.class);
            startActivity(intent);
        }
        if(typ.equals("Background"))
        {
            Intent intent = new Intent(this,background.class);
            startActivity(intent);
        }
    }
    public void Exit(View v)
    {
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}