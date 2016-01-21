package com.tmosest.newclue;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class NewGameActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.tmosest.newclue.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NumberPicker np = (NumberPicker) findViewById(R.id.npPlayers);
        final TextView tv = (TextView) findViewById(R.id.tvPlayers);
        //Set TextView text color
        //tv.setTextColor(Color.parseColor("#ffd32b3b"));

        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        np.setMinValue(3);
        //Specify the maximum value/number of NumberPicker
        np.setMaxValue(6);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        np.setWrapSelectorWheel(true);

        //Set a value change listener for NumberPicker
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                tv.setText("How many players? " + newVal);
            }
        });
    }

    public void startPlayerNameActivity(View view) {

        //Get the number of players
        NumberPicker np = (NumberPicker) findViewById(R.id.npPlayers);
        int numPlayers = np.getValue();

        //Start a new activity
        Intent intent = new Intent(this, SubmitNamesActivity.class);
        String message = Integer.toString(numPlayers);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        //finish();
    }
}

