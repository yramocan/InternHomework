package com.example.yuriramocan.internhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);

        String response = getIntent().getExtras().getString("response");

        TextView response_msg = (TextView) findViewById(R.id.response_message);
        response_msg.setText(response);
    }
}
