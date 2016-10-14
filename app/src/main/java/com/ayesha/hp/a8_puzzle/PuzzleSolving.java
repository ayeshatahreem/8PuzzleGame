package com.ayesha.hp.a8_puzzle;

/**
 * Created by HP on 13/10/16.
 */
public class PuzzleSolving {

    PuzzleBoard board;
    public PuzzleSolving(PuzzleBoard b){
        board=b;
    }

    public boolean find(){
        boolean p=true;
        for(int i=0;i<8;i++) {
            if ((board.t[i].getPlayMode())!=(i+1)){
                p=false;
            }
        }
        return p;
    }

    public boolean move(int x, int y){
        int occupy=0,free=0,swap=0;
        boolean get;
        for(int i=0;i<9;i++)
        {
            if(board.t[i].match(x,y))
                occupy=i;
            if(board.t[i].getPlayMode()==0)
                free=i;
        }
        if((occupy-1)==free||(occupy+1)==free||(occupy-3)==free||(occupy+3)==free)
        {
            swap=board.t[free].getPlayMode();
            board.t[free].setPlayMode(board.t[occupy].getPlayMode());
            board.t[occupy].setPlayMode(swap);
        }
        get = find();
        return get;
    }
}