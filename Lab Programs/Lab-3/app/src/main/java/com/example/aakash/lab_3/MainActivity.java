package com.example.aakash.lab_3;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName,etUsn;
    Button bsave,bview,bdelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName= (EditText) findViewById(R.id.name);
        etUsn= (EditText) findViewById(R.id.usn);
        bsave= (Button) findViewById(R.id.save);
        bview= (Button) findViewById(R.id.view);
        bdelete = (Button) findViewById(R.id.delete);

        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(MainActivity.this,Second.class);
                startActivity(it1);
            }
        });

        bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=etName.getText().toString();
                String usn=etUsn.getText().toString();
                if(data.equals("")||usn.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Insertion Failed-Empty Entry not Allowed", Toast.LENGTH_SHORT).show();
                }
                else {
                    DBHelper dbh = new DBHelper(MainActivity.this);
                    if (dbh.addData(data, usn)) {
                        etName.setText("");
                        etUsn.setText("");
                        Toast.makeText(MainActivity.this, "Inserted Succesful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=etName.getText().toString();
                String usn=etUsn.getText().toString();
                if(data.equals("")||usn.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Deletion Failed-Empty Entry not Allowed", Toast.LENGTH_SHORT).show();
                }
                else {
                    DBHelper dbh = new DBHelper(MainActivity.this);
                    if (dbh.deleteTitle(data, usn)) {
                        etName.setText("");
                        etUsn.setText("");
                        Toast.makeText(MainActivity.this, "Deletion Succesful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Deletion Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}