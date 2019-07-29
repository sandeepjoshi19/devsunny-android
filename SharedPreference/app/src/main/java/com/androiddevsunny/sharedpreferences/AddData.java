package com.androiddevsunny.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddData extends AppCompatActivity implements View.OnClickListener {

    EditText name;
    EditText rollNo;
    EditText marks;

    Button saveData;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        name=findViewById(R.id.name);
        rollNo=findViewById(R.id.rollno);
        marks=findViewById(R.id.marks);

        saveData=findViewById(R.id.save_data);
        saveData.setOnClickListener(this);

        sharedPreferences=getSharedPreferences("studentData",MODE_PRIVATE);
    }


    @Override
    public void onClick(View v) {
        sharedPreferences.edit().putString("name",name.getText().toString())
                .putString("rollNo",rollNo.getText().toString())
                .putInt("marks",Integer.parseInt(marks.getText().toString()))
                .apply();
        Toast.makeText(AddData.this,"Date Saved",Toast.LENGTH_LONG).show();
    }
}
