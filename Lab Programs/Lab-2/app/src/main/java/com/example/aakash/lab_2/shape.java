package com.example.aakash.lab_2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class shape extends AppCompatActivity {

    EditText et,et1;
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);

        et = findViewById(R.id.tw2);
        et1 = findViewById(R.id.tw3);

        registerForContextMenu(et);
        registerForContextMenu(et1);

        Button btn1 = findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });
        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert(v);
            }
        });
    }
    public void back(View v)
    {
        Intent intent = new Intent(shape.this,MainActivity.class);
        startActivity(intent);
    }
    public void alert(final View v)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(shape.this);
        builder1.setMessage("Selected Options Correct?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        progressBar=new ProgressDialog(v.getContext());
                        progressBar.setCancelable(true);
                        progressBar.setMessage("Creating...");
                        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progressBar.setProgress(0);
                        progressBar.setMax(100);
                        progressBar.show();
                        progressBarStatus = 0;
                        new Thread(new Runnable() {
                            public void run() {
                                while (progressBarStatus < 100) {
                                    progressBarStatus = doOperation();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    progressBarHandler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            progressBar.setProgress(progressBarStatus);
                                        }
                                    });
                                }
                                if (progressBarStatus >= 100)
                                {   try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    progressBar.dismiss();
                                    Intent intent = new Intent(shape.this,draw.class);
                                    Bundle b = new Bundle();
                                    b.putString("Shape",et.getText().toString());
                                    b.putString("Color",et1.getText().toString());
                                    intent.putExtras(b);
                                    startActivity(intent);
                                }
                        }
                        }).start();
                    }
                    int doOperation()
                    {
                        return 100;
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu,v,menuInfo);
        if(v.getId() == R.id.tw2)
        {
            menu.setHeaderTitle("Select Shape");
            menu.add(0,v.getId(),0,"Square");
            menu.add(0,v.getId(),0,"Rectangle");
        }
        else if(v.getId() == R.id.tw3)
        {
            menu.setHeaderTitle("Select Color");
            menu.add(0,v.getId(),0,"Black");
            menu.add(0,v.getId(),0,"Blue");
            menu.add(0,v.getId(),0,"Green");
            menu.add(0,v.getId(),0,"Yellow");
            menu.add(0,v.getId(),0,"Red");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        if(item.getTitle()=="Square")
        {
            et.setText("Square", TextView.BufferType.EDITABLE);
        }
        else if(item.getTitle() == "Rectangle")
        {
            et.setText("Rectangle", TextView.BufferType.EDITABLE);
        }

        else if(item.getTitle() == "Black")
        {
            et1.setText("Black");
        }
        else if(item.getTitle() == "Blue")
        {
            et1.setText("Blue");
        }
        else if(item.getTitle() == "Green")
        {
            et1.setText("Green");
        }
        else if(item.getTitle() == "Yellow")
        {
            et1.setText("Yellow");
        }
        else if(item.getTitle() == "Red")
        {
            et1.setText("Red");
        }
        else
        {
            return false;
        }
        return true;
    }

}