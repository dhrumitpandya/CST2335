package com.example.dhrumitpandya.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;



import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ListItemActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(ACTIVITY_NAME, "In onCreate()");
        setContentView(R.layout.activity_list_items);
        final ImageButton img_button = (ImageButton) findViewById(R.id.imageButton);
        Switch swtch = (Switch) findViewById(R.id.switch1);
        CheckBox chkbox = (CheckBox) findViewById(R.id.checkBox);
        img_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }

            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    img_button.setImageBitmap(imageBitmap);
                }
            }

        });

        swtch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CharSequence text1 = "Switch is On";// "Switch is Off"
                CharSequence text2 = "Switch is Off";
                int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off
                Toast toast;
                if (isChecked) {
                    toast = Toast.makeText(ListItemsActivity.this, text1, duration); //this is the ListActivity
                    // toast.show(); //display your message box
                } else {
                    duration = Toast.LENGTH_LONG;
                    toast = Toast.makeText(ListItemsActivity.this, text2, duration);
                }

                toast.show(); //display your message box

            }
        });
        chkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                        // .setTitle(R.string.dialog_title)
                        .setTitle("Make A choice")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                                Intent resultIntent = new Intent();
                                resultIntent.putExtra("Response", "Information to Share");
                                setResult(Activity.RESULT_OK, resultIntent);
                                finish();
                            }
                        })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog

                            }
                        })
                        .show();

            }
        });
    }

    @Override
    protected  void onResume(){
        super.onResume();

        Log.i(ACTIVITY_NAME, "In onResume()");

    }
    @Override
    protected  void onStart(){
        super.onStart();

        Log.i(ACTIVITY_NAME, "In onStart()");
    }
    @Override
    protected  void onPause(){
        super.onPause();

        Log.i(ACTIVITY_NAME, "In onPause()");
    }
    @Override
    protected  void onStop(){
        super.onStop();

        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();

        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}
