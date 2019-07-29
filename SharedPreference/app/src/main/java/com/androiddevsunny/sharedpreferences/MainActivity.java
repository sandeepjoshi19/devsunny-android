package com.androiddevsunny.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView name;
    TextView rollNo;
    TextView marks;

    Button refreshData;
    Button addData;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.saved_name);
        rollNo=findViewById(R.id.saved_rollno);
        marks=findViewById(R.id.saved_marks);

        refreshData=findViewById(R.id.refresh_data);
        addData=findViewById(R.id.add_data);

        sharedPreferences=getSharedPreferences("studentData",MODE_PRIVATE);

        if (sharedPreferences.contains("name")){
            name.setText(sharedPreferences.getString("name","ABC"));
        }
        if (sharedPreferences.contains("rollNo")){
            rollNo.setText(sharedPreferences.getString("rollNo","20"));
        }
        if(sharedPreferences.contains("marks")){
            marks.setText(sharedPreferences.getInt("marks",33)+" ");
        }

        refreshData.setOnClickListener(this);
        addData.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.add_data){
            Intent intent=new Intent(MainActivity.this,AddData.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.refresh_data){
            name.setText(sharedPreferences.getString("name","ABC"));
            rollNo.setText(sharedPreferences.getString("rollNo","20"));
            marks.setText(sharedPreferences.getInt("marks",33)+" ");
        }
    }
}