package com.ayesha.hp.a8_puzzle;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Color;
import android.graphics.Paint.Style;
/**
 * Created by HP on 13/10/16.
 */
public class Tile {
    protected Paint paint;
    private int x;
    private int y;
    private int width;
    private int height;
    private int playMode;

    public Tile(int a,int b){
        paint = new Paint();
        x = a;
        y = b;
        playMode = -1;
    }

    public void setDimensions(int w,int h){
        width = w;
        height = h;
    }

    public int getPlayMode(){
        return playMode;
    }

    public void setPlayMode(int p){
        playMode=p;
    }

    public boolean match(int a,int b){
        if(x==a && y==b)
            return true;
        else
            return false;
    }

    public void draw(Canvas canvas) {
        if(playMode==0)
        {
            paint.setStyle(Style.FILL_AND_STROKE);
            paint.setColor(Color.WHITE);
        }
        else
            paint.setStyle(Style.STROKE);
        Rect r = new Rect(x*width,y*height,((x+1)*width - 1),((y+1)*height - 1));
        canvas.drawRect(r, paint);
        paint.setTextSize(100f);
        paint.setColor(Color.WHITE);
        String s=Integer.toString(playMode);
        canvas.drawText(s,(x*width)+110,(y*height)+145,paint);
    }
}