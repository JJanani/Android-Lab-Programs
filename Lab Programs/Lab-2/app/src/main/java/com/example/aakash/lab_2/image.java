package com.example.aakash.lab_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class image extends AppCompatActivity {

    ListView simplelist;
    String names[] = {"image1", "image2", "image3", "image4"};
    Integer img[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backpage2(v);
            }
        });

        List_Adapter adap = new List_Adapter(this, names,img);
        simplelist = (ListView) findViewById(R.id.List);
        simplelist.setAdapter(adap);

        simplelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = names[+position];
                String no = Integer.toString(+position);
                Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(image.this,imagepage.class);
                Bundle b = new Bundle();
                b.putInt("Name",position);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
    public void backpage2(View v)
    {
        Intent intent = new Intent(image.this,MainActivity
                .class);
        startActivity(intent);
    }
}