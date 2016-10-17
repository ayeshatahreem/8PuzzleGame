package com.ayesha.hp.a8_puzzle;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
/**
 * Created by HP on 13/10/16.
 */
public class PuzzleView extends View {

        int turn;
        boolean done;
        PuzzleBoard board;
        private TilesViewActionListener listener;

        public PuzzleView(Context context, AttributeSet attrs, TilesViewActionListener l) {
            super(context, attrs);
            turn = 0;
            done = false;
            board = new PuzzleBoard();
            listener = l;
        }

        public interface TilesViewActionListener {
        public void showMessage(String message);
    }
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int size ;
            int width = getMeasuredWidth();
            int height = getMeasuredHeight();
            if (width > height) {
                size = height;
            }
            else {
                size = width;
            }
            setMeasuredDimension(size, size);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            board.setDimensions(this.getWidth(), this.getHeight());
            board.draw(canvas);

            if (done){
               listener.showMessage(getContext().getResources().getString(R.string.gameStats));
            }
        }

    private void playerTurn(float x, float y) {
        if(done ){
           TextView text=(TextView) findViewById(R.id.textView);
            text.setText(R.string.gameStats);

             }
        else
        {
          listener.showMessage(getContext().getResources().getString(R.string.gameInProcess));
            done = board.change(x,y);
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_UP:
                playerTurn(x, y);
                break;
            default:
                return false;
        }
        return true;
    }
}
