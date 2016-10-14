package com.ayesha.hp.a8_puzzle;
import android.graphics.Canvas;
import java.util.Collections;
import java.util.Arrays;
/**
 * Created by HP on 13/10/16.
 */
public class PuzzleBoard {
    private Integer [] arr=new Integer[9];
    private PuzzleSolving work;
    private final int size = 3;
    public Tile [] t;
    private int width;
    private int height;

    public PuzzleBoard(){
        t = new Tile[9];
        generatePuzzle();
        for(int x=0,y=0,z=0;x<9;x++,y++) {
            if(y>2) {
                y=0;
                z++;
            }
            t[x]=new Tile(y,z);
        }
        for(int i=0;i<9;i++) {
            t[i].setPlayMode(arr[i]);
        }
    }

    //While generating a 8-puzzle, it needs to be checked if the game is solvable.
    public void generatePuzzle(){
        for(int i=0;i<9;i++)
            arr[i] = i;
        Collections.shuffle(Arrays.asList(arr));
        if(find()==false)
            generatePuzzle();
    }

    public boolean find(){
        int count=0;
        for(int i=0;i<9;i++) {
            for(int j=i+1;j<9;j++) {
                if(arr[i]<arr[j])
                    count++;
            }
        }
        if(count % 2== 0)
            return true;
        else
            return false;
    }

    private int getTileWidth(){
        return width / size;
    }

    private int getTileHeight(){
        return height / size;
    }

    public void setDimensions(int w, int h){
        width = w;
        height = h;
        for(int i=0; i < 9; i++){
            t[i].setDimensions(getTileWidth(),getTileHeight());
        }
    }

    public void draw(Canvas canvas){
        for(int i=0; i < 9; i++){
            t[i].draw(canvas);
        }
    }

    public boolean change(float x, float y) {
        int a,b;
        a = (int) x / getTileWidth();           //subconversion from float to int
        b = (int) y / getTileHeight();
        work=new PuzzleSolving(this);
        return work.move(a,b);
    }
}
