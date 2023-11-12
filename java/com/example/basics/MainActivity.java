package com.example.basics;


import android.graphics.Color;
import android.os.Bundle;



import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(this);
        Button longbtn = findViewById(R.id.btn1);
        longbtn.setOnLongClickListener(this::onLongClick);

    }

    @Override
    public void onClick(View view) {
        TextView textView = findViewById(R.id.textView1);
        Date date1 = new Date(System.currentTimeMillis());
        if (view.getId() == R.id.btn1) {
            String desc = String.format("%s 你点了它一下%s", date1, ((Button) view).getText());
            textView.setText(desc);
            button2.setTextColor(Color.BLACK);
            button2.setEnabled(true);
        }
        if(view.getId() == R.id.btn2){
            Toast.makeText(this,"你点了它",Toast.LENGTH_SHORT).show();
        }
    }
    public boolean onLongClick(View v){
        TextView tv2 = findViewById(R.id.textView2);
        Date date2 = new Date(System.currentTimeMillis());
        if(v.getId()==R.id.btn1){
            String desc = String.format("%s 你长按了它%s",date2,((Button) v).getText());
            tv2.setText(desc);
            button2.setEnabled(false);
            button2.setTextColor(Color.WHITE);
        }
        return true;
    }

};


