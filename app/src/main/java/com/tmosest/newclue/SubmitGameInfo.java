package com.tmosest.newclue;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SubmitGameInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_game_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        //String names = intent.getStringExtra(SubmitNamesActivity.EXTRA_MESSAGE);
        Bundle extras = intent.getExtras();
        final String[] names = extras.getStringArray("names");
        final TextView tv = new TextView(this);
        tv.setText(Arrays.toString(names));
        LinearLayout list = (LinearLayout) findViewById(R.id.llGameInfo);
        list.addView(tv);

        String[] playerColorChoices = this.getResources().getStringArray(R.array.playerColors);

        //TODO: Java equiv of Foreach loop
        int i = 0;
        for(String name : names ) {
            LinearLayout namelayout = new LinearLayout(this);
            namelayout.setOrientation(LinearLayout.HORIZONTAL);
            list.addView(namelayout);

            TextView textView = new TextView(this);
            textView.setText(name);
            namelayout.addView(textView);

            /*TextView textView2 = new TextView(this);
            textView2.setText("Character: ");
            namelayout.addView(textView2);

            EditText et = new EditText(this);
            et.setWidth(200);
            et.setId(i);
            i++;
            namelayout.addView(et);*/

            Spinner spin = new Spinner(this);
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.playerChoices, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            spin.setAdapter(adapter);
            spin.setId(i);
            namelayout.addView(spin);
            i++;
        } //end for loop
        //TODO: Add a button
        Button next = new Button(this);
        next.setText("Next");
        list.addView(next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] playerColors = new String[names.length];
                for(int i=0; i < names.length; i++) {

                    Spinner spinner = (Spinner) findViewById(i);
                    String t = spinner.getSelectedItem().toString();

                    //Context context = getApplicationContext();
                    //CharSequence text = t;
                    //int duration = Toast.LENGTH_SHORT;

                    //Toast toast = Toast.makeText(context, text, duration);
                    //toast.show();

                    playerColors[i] = t;

                }//en for i

                //tv.setText(Arrays.toString(playerInfo));

                //String message = names.toString();
                Intent intent = new Intent(SubmitGameInfo.this, NewWeaponsAndsPlaces.class);
                Bundle extras = new Bundle();
                extras.putStringArray("playerColors", playerColors);
                extras.putStringArray("names", names);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
