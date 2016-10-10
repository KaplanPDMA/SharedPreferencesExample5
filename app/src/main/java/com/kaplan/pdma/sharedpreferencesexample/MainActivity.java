package com.kaplan.pdma.sharedpreferencesexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSettings = (Button) findViewById(R.id.buttonSettings);

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        TextView textViewHighScore = (TextView) findViewById(R.id.textViewHighScore);

        //Read from SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("ptdipwt5", Context.MODE_PRIVATE);
        String username = sharedPref.getString("username", "undefined");
        int highScore = sharedPref.getInt("highscore", 0);
        textViewUsername.setText(username);
        textViewHighScore.setText("" + highScore);

    }
}
