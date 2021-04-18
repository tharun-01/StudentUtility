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

public class MainActivity2 extends AppCompatActivity {
    Button regist,login;
    EditText tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        regist=findViewById(R.id.register);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),Registration.class);
                startActivity(in);
            }
        });

        login=findViewById(R.id.hey);
        tv1=findViewById(R.id.uname);
        tv2=findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity3.class);
                SharedPreferences sp=getApplicationContext().getSharedPreferences("Myuser", Context.MODE_PRIVATE);
                if(tv1.getText().toString().equals(sp.getString("name","")) && tv1.getText().toString().equals(sp.getString("name","")))
                {
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"REGISTER PLEASE",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}