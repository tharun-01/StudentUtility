package com.example.ca3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    Button regist;
    EditText tv1,tv2;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        regist=findViewById(R.id.textButton);
        tv1=findViewById(R.id.uname);
        tv2=findViewById(R.id.password);
        sp=getSharedPreferences("Myuser", Context.MODE_PRIVATE);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("name",tv1.getText().toString());
                editor.putString("pass",tv2.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(),"REGISTERED",Toast.LENGTH_SHORT).show();
                Intent in=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(in);
            }
        });
    }
}