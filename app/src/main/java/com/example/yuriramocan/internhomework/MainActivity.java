package com.example.yuriramocan.internhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
 * Creator Name: Yuri Ramocan
 *
 * APP DESCRIPTION:
 * - This app tells you that your favorite NBA team sucks if it's not the Pistons.
 */
public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.yuriramocan.internhomework.MESSAGE";

    public void submitTeam (View view) {
        Boolean arePistons;

        // Get user's favorite team.
        EditText teamField = (EditText) findViewById(R.id.favorite_team);
        Editable teamEditable = teamField.getText();

        // Assign user input to team as string.
        String team = teamEditable.toString();

        // Regex check if (down-cased) user input includes "pistons".
        if (team.toLowerCase().matches("(the)?\\s?(detroit)?\\s?(pistons)$")) {
            arePistons = true;
            display(arePistons);
        } else {
            arePistons = false;
            display(arePistons);
        }
    }

    private void display(boolean check) {
        TextView welcome = (TextView) findViewById(R.id.welcome_message);
        if (check) {
            welcome.setText("TRUE");
        } else {
            welcome.setText("FALSE");
        }
    }

//    public void enterHome(View view) {
//        Intent intent = new Intent(this, DisplayHomeActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}