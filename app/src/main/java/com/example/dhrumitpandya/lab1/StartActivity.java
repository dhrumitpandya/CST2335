package com.example.dhrumitpandya.lab1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class StartActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    protected  static  final String ACTIVITY_NAME = "StartActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        setContentView(R.layout.activity_start);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
                // startActivity(intent);
                startActivityForResult(intent,5);

            }

            public void onActivityResult(int requestCode, int resultCode, Intent data){

                if(requestCode==5)
                {
                    Log.i(ACTIVITY_NAME,"Returnes to StartActivity.onActivityResult");
                }
                if(resultCode== Activity.RESULT_OK){
                    String messgPassed = data.getStringExtra("Response");
                    Toast toast = Toast.makeText(StartActivity.this,messgPassed,Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });

    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i(ACTIVITY_NAME, "In onStart()");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i(ACTIVITY_NAME, "In onStop()");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }
    @Override
    protected  void onResume(){
        super.onResume();

        Log.i(ACTIVITY_NAME, "In onResume()");

    }

    /*  protected  void onStart(){
          super.onStart();
          final String ACTIVITY_NAME = "LoginActivity";
          Log.i(ACTIVITY_NAME, "In onStart()");
      }*/
    @Override
    protected  void onPause(){
        super.onPause();

        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    /* protected  void onStop(){
         super.onStop();
         final String ACTIVITY_NAME = "LoginActivity";
         Log.i(ACTIVITY_NAME, "In onStop()");
     }*/
    @Override
    protected  void onDestroy(){
        super.onDestroy();

        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}