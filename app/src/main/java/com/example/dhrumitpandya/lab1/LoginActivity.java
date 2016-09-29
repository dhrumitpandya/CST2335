package com.example.dhrumitpandya.lab1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(ACTIVITY_NAME, "In onCreate()");
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
        @Override
        protected void onResume(){
            super.onResume();

            Log.i(ACTIVITY_NAME,"In onResume()");
        }


        protected  void onStart(){
            super.onStart();

            Log.i(ACTIVITY_NAME, "In onStart()");
            final SharedPreferences prefs = getSharedPreferences("Default", Context.MODE_PRIVATE);
            prefs.getString("DefaultEmail","dhrumitpandya26@gmail.com");
            Button login_button = (Button) findViewById(R.id.button2);
            login_button.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {

                                                    EditText name = (EditText)findViewById(R.id.textView2);
                                                    SharedPreferences.Editor editor = prefs.edit();
                                                    String x =  name.getText().toString() ;
                                                    editor.putString("loginname" ,x );
                                                    editor.commit();
                                                    Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                                                    startActivity(intent);
                                                }
                                            }
            );

        }


        protected  void onPause(){
            super.onPause();

            Log.i(ACTIVITY_NAME, "In onPause()");
        }


        protected  void onStop(){
            super.onStop();

            Log.i(ACTIVITY_NAME, "In onStop()");
        }


        protected  void onDestroy(){
            super.onDestroy();

            Log.i(ACTIVITY_NAME, "In onDestroy()");
        }
    }
