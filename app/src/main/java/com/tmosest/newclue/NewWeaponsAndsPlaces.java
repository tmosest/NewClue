package com.tmosest.newclue;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewWeaponsAndsPlaces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_weapons_ands_places);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String[] playerInfo = extras.getStringArray("playerColors");
        final String[] names = extras.getStringArray("names");

        LinearLayout list = (LinearLayout) findViewById(R.id.llNames);

        for(int i = 0; i < names.length; i++) {
            LinearLayout namelayout = new LinearLayout(this);
            namelayout.setOrientation(LinearLayout.HORIZONTAL);
            list.addView(namelayout);

            TextView textView = new TextView(this);
            textView.setText(names[i] + " as " + playerInfo[i]);
            namelayout.addView(textView);
        }
    }

}
