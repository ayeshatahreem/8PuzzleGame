package com.ayesha.hp.a8_puzzle;

/**
 * Created by HP on 17/10/16.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Help extends  AppCompatActivity  {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
    }

    public void goBack(View v) {
        // onDestroy();
        finish();
    }
}