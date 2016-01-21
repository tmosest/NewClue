package com.tmosest.newclue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SubmitNamesActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.tmosest.newclue.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_names);
        //TODO: Set the layout with code.
        Intent intent = getIntent();
        String message = intent.getStringExtra(NewGameActivity.EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        textView.setId(R.id.name_space_1);
        LinearLayout layout = (LinearLayout) findViewById(R.id.llNameList);
        layout.addView(textView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int numplayers = Integer.parseInt(message);
        for(int i=0; i<numplayers; i++) {
            LinearLayout namelayout = new LinearLayout(this);
            namelayout.setOrientation(LinearLayout.HORIZONTAL);
            layout.addView(namelayout);
            TextView name = new TextView(this);
            name.setText("Name:");
            name.setTextSize(15);
            namelayout.addView(name);

            EditText et = new EditText(this);
            et.setId(i);
            et.setWidth(200);
            et.setText("Tyler"); //TODO: Remove this code
            namelayout.addView(et);

            et.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == 66) {
                        int id = v.getId();
                        if(id+1 >= numplayers) id= -1;
                        EditText et = (EditText) findViewById(id+1);
                        et.requestFocus();
                    }
                    return false;
                }
            });

        }

        final Button submit = new Button(this);
        submit.setText("Next");
        layout.addView(submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] names = new String[numplayers];
                String message = "";
                for(int i = 0; i<numplayers; i++) {
                    EditText e = (EditText) findViewById(i);
                    String name = e.getText().toString();
                    names[i] = name;

                    /*Context context = getApplicationContext();
                    CharSequence text = name;
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();*/
                    //message += name + " ";
                }
                //String message = names.toString();
                Intent intent = new Intent(SubmitNamesActivity.this, SubmitGameInfo.class);
                //intent.putExtra(EXTRA_MESSAGE, message);
                intent.putExtra("names", names);
                startActivity(intent);
            }
        });
    }

}
