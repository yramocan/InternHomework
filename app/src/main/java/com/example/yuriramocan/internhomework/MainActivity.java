package com.example.yuriramocan.internhomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/*
 * Creator Name: Yuri Ramocan
 *
 * APP DESCRIPTION:
 * - This app tells you that your favorite NBA team sucks if it's not the Pistons.
 */
public class MainActivity extends AppCompatActivity {
    public void submitTeam (View view) {
        Boolean arePistons;

        // Get user's favorite team.
        EditText teamField = (EditText) findViewById(R.id.favorite_team);
        Editable teamEditable = teamField.getText();

        // Assign user input to team as string.
        String team = teamEditable.toString();

        // RegEx check if (down-cased) user input includes "pistons".
        if (team.toLowerCase().matches("(the)?\\s?(detroit)?\\s?(pistons)$")) {
            arePistons = true;
            openTeamActivity(team, arePistons);
        } else {
            arePistons = false;
            openTeamActivity(team, arePistons);
        }
    }

    private void openTeamActivity(String team, boolean check) {
        Intent intentTeamActivity = new Intent(MainActivity.this, TeamActivity.class);
        if (check) {
            // If check returns true (Pistons are favorite team) then pass string to TeamActivity.
            intentTeamActivity.putExtra("response", "DEEEEETROOIIIIT\nBAASKETBAAALL");
        } else {
            // If check returns false then tell user their team sucks.
            intentTeamActivity.putExtra("response", "Sorry, but\n\n" + team.toUpperCase()
                                        + "\n\nSuck.");
        }
        startActivity(intentTeamActivity);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}