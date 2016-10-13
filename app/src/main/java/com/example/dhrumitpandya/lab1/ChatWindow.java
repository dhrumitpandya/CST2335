package com.example.dhrumitpandya.lab1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
    protected final static String ACTIVITY_NAME = "ChatWindow";


    private ListView LV;
    private EditText ET;
    private Button BT;
    private ArrayList<String> chatList;
    private ChatAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        LV = (ListView) findViewById(R.id.listView);
        ET = (EditText) findViewById(R.id.chatText);
        BT = (Button) findViewById(R.id.send_btn);

        chatList = new ArrayList<String>();
        adapter = new ChatAdapter(this, chatList);
        LV.setAdapter(adapter);


        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the text from the edit text, and add it to the
                if (ET.getText().toString().length() > 0) {
                    chatList.add(ET.getText().toString());
                    adapter.notifyDataSetChanged();
                    ET.setText("");
                }
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    //Inner class
    private class ChatAdapter extends ArrayAdapter<String> {

        ArrayList<String> list;

        public ChatAdapter(Context context, ArrayList<String> data) {
            super(context, 0, data);
            list = data;
        }

        @Override
        public String getItem(int position) {
            if (position < list.size()) {
                return list.get(position);
            } else {
                return "";
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;
            if (position % 2 == 0) {
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            } else {
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }
            TextView message = (TextView) result.findViewById(R.id.message_text);
            message.setText(getItem(position)); // get the string at position
            return result;
        }
    }
}
