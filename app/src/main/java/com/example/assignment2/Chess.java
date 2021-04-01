package com.example.assignment2;
import java.util.Random;

public class Chess {

    public static final int SIDE = 8;
    private int [][] game;

    public Chess()
    {
        game = new int[SIDE][SIDE];
        resetGame();
    }

    public void resetGame()
    {
        for(int row = 0; row < SIDE; row++)
        {
            for (int col = 0; col < SIDE; col++)
                game[row][col] = 0;
        }
    }

    public void play()
    {

    }
}
