package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Chess game;
    private ButtonGridAndTextView chessView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Chess();
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x / Chess.SIDE;
        ButtonHandler bh = new ButtonHandler();
        chessView = new ButtonGridAndTextView(this, w, Chess.SIDE, bh);

        setContentView(chessView);
    }

    private class ButtonHandler implements View.OnClickListener
    {
        public void onClick(View v)
        {
            for(int row = 0; row < Chess.SIDE; row++)
            {
                for(int col = 0; col < Chess.SIDE; col++)
                {
                    if(chessView.isButton((Button)v, row, col))
                    {
                        chessView.play(row, col);
                    }
                }
            }
        }
    }
}
