package com.pointnote.datastorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SimpleCounter extends AppCompatActivity {

    int counter = 0;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_counter);
        pref = getPreferences(Context.MODE_PRIVATE);
        counter = pref.getInt("counter", 0);
        TextView current = (TextView) findViewById(R.id.number);
        current.setText("" + counter);
    }

    public void advance(View view) {
        counter++;
        TextView current = (TextView) findViewById(R.id.number);
        current.setText("" + counter);
    }

    public void saveCount(View view) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("counter", counter);
        editor.commit();
    }
}
