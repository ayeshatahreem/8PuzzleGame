package com.ayesha.hp.a8_puzzle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;

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

    private void clear(){
        ViewGroup view = (ViewGroup) findViewById(R.id.game);
        view.removeAllViews();
    }

    public void newGame(View view){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                    {
                        clear();
                        setContentView(R.layout.activity_main);
                        drawBoard();
                        break;
                    }
                    case DialogInterface.BUTTON_NEGATIVE: {
                        dialog.cancel();
                        break;
                    }
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to play a new game ?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    public void exitGame(View view){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                    {
                        finish();
                        break;
                    }
                    case DialogInterface.BUTTON_NEGATIVE: {
                        dialog.cancel();
                        break;
                    }
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit the game ?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    public void help(View view){
        Intent intent = new Intent(getApplicationContext(), Help.class);
        startActivity(intent);
    }

    public void setMessage(String message){
        TextView v = (TextView) findViewById(R.id.textView);
        v.setText(Html.fromHtml(message));
    }

    private void drawBoard(){
        ViewGroup v = (ViewGroup) findViewById(R.id.game);
        View puzzleView = new PuzzleView(this,null,listener);
        v.addView(puzzleView);
        TextView text=(TextView) findViewById(R.id.textView);
        text.setText(R.string.gameStart);
    }
}
