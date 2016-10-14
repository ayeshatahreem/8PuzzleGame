package com.ayesha.hp.a8_puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    PuzzleView.TilesViewActionListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createListener();
        drawBoard();
    }

    private void createListener(){
        listener = new PuzzleView.TilesViewActionListener() {
            @Override
            public void showMessage(String message) {
                setMessage(message);
            }
        };
    }

    public void setMessage(String message){
        TextView v = (TextView) findViewById(R.id.textView);
        v.setText(Html.fromHtml(message));
    }

    private void drawBoard(){
        ViewGroup v = (ViewGroup) findViewById(R.id.game);
        View puzzleView = new PuzzleView(this,null,listener);
        v.addView(puzzleView);
    }
}
