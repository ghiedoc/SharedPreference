package com.appdev.gillian.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvWelcome;
    EditText etName;
    Button submitBtn;

    public static final String Pref_Name = "com.appdev.gillian.sharedpreference.Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = (TextView)findViewById(R.id.tvWelcome);
        etName = (EditText)findViewById(R.id.etName);
        submitBtn = (Button)findViewById(R.id.submitBtn);

        SharedPreferences pref = getSharedPreferences(Pref_Name,MODE_PRIVATE);
        String user= pref.getString("user","");
        tvWelcome.setText("Welcome to my App " +user+  "!");


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                tvWelcome.setText("Welcome to my app " +name+ "!");

                SharedPreferences.Editor editor = getSharedPreferences(Pref_Name,MODE_PRIVATE).edit();
                editor.putString("user",name);
                editor.commit();

            }
        });
    }
}
