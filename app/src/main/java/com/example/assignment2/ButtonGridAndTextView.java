package com.example.assignment2;

import android.content.Context;
import android.widget.Button;
import android.widget.GridLayout;
import java.util.Random;

public class ButtonGridAndTextView extends GridLayout {
    private int side;
    private Button [][] buttons;
    //private TextView status;
    Random rand = new Random();

    public ButtonGridAndTextView( Context context, int width, int newSide,
                                  OnClickListener listener ) {
        super( context );
        side = newSide;
        // Set # of rows and columns of this GridLayout
        setColumnCount( side );
        setRowCount( side + 1 );

        // Create the buttons and add them to this GridLayout
        buttons = new Button[side][side];
        for( int row = 0; row < side; row++ ) {
            for( int col = 0; col < side; col++ ) {
                buttons[row][col] = new Button( context );
                buttons[row][col].setTextSize( ( int ) ( width * .2 ) );
                buttons[row][col].setOnClickListener( listener );
                addView( buttons[row][col], width, width );
            }
        }

        colorButtons();


        setPieces();
    }

    private void colorButtons()
    {
        for (int row = 0; row < side; row++)
        {
            for (int col = 0; col < side; col++)
            {
                if ((row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 == 1))
                    buttons[row][col].setBackgroundColor(getResources().getColor(R.color.chessLight));
                else
                    buttons[row][col].setBackgroundColor(getResources().getColor(R.color.chessDark));
            }
        }
    }


    public boolean isButton( Button b, int row, int column ) {
        return ( b == buttons[row][column] );
    }

    public void play(int row, int col)
    {
        colorButtons(); // reset buttons colors every time a piece is clicked
        if(buttons[row][col].getText().equals("K")) // if a knight is clicked
        {
            if((row - 2 >= 0)&&(row - 2 <= 7)) // outside ifs: make sure not move is not out of bounds
            {
                if((col - 1 >= 0) && (col - 1 <= 7))
                {
                    // is space taken?
                    if (buttons[row - 2][col - 1].getText().equals("")) // no
                        buttons[row - 2][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
                    else if(buttons[row - 2][col - 1].getCurrentTextColor()==buttons[row][col].getCurrentTextColor()) // yes and is color
                        buttons[row - 2][col - 1].setBackgroundColor(getResources().getColor(R.color.red));
                    else // yes and is other color
                        buttons[row - 2][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
                }
                if((col + 1 >= 0)&&(col + 1<= 7))
                {
                    if (buttons[row - 2][col + 1].getText().equals(""))
                        buttons[row - 2][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
                    else if(buttons[row - 2][col + 1].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row - 2][col + 1].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row - 2][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
            if((row - 1 >= 0)&&(row - 1 <= 7))
            {
                if((col - 2 >= 0)&&(col - 2 <= 7))
                {
                    if(buttons[row - 1][col - 2].getText().equals(""))
                        buttons[row - 1][col - 2].setBackgroundColor(getResources().getColor(R.color.green));
                    else if(buttons[row - 1][col - 2].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row - 1][col - 2].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row - 1][col - 2].setBackgroundColor(getResources().getColor(R.color.green));
                }
                if((col + 2 >= 0)&&(col + 2 <= 7))
                {
                    if(buttons[row - 1][col + 2].getText().equals(""))
                        buttons[row - 1][col + 2].setBackgroundColor(getResources().getColor(R.color.green));
                    else if (buttons[row - 1][col + 2].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row - 1][col + 2].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row - 1][col + 2].setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
            if((row + 1 >= 0)&&(row + 1 <= 7))
            {
                if((col - 2 >= 0)&&(col - 2 <= 7))
                {
                    if(buttons[row + 1][col - 2].getText().equals(""))
                        buttons[row + 1][col - 2].setBackgroundColor(getResources().getColor(R.color.green));
                    else if (buttons[row +1 ][col - 2].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row + 1][col - 2].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row + 1][col - 2].setBackgroundColor(getResources().getColor(R.color.green));
                }
                if((col + 2 >=0)&&(col + 2 <= 7))
                {
                    if(buttons[row + 1][col + 2].getText().equals(""))
                        buttons[row + 1][col + 2].setBackgroundColor(getResources().getColor(R.color.green));
                    else if (buttons[row + 1][col + 2].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row + 1][col + 2].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row + 1][col + 2].setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
            if((row + 2 >= 0)&&(row + 2 <= 7))
            {
                if((col - 1 >= 0)&&(col - 1 <= 7))
                {
                    if(buttons[row + 2][col - 1].getText().equals(""))
                        buttons[row + 2][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
                    else if(buttons[row + 2][col - 1].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row + 2][col - 1].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row + 2][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
                }
                if((col + 1 >= 0)&&(col + 1 <= 7))
                {
                    if(buttons[row + 2][col + 1].getText().equals(""))
                        buttons[row + 2][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
                    else if (buttons[row + 2][col + 1].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row + 2][col + 1].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row + 2][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        }
        else if (buttons[row][col].getText().equals("R")) // if rook is clicked
        {
            for(int i = 1; row + i <= 7; i++)
            {
                if(buttons[row + i][col].getText().equals(""))
                    buttons[row + i][col].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row + i][col].getCurrentTextColor() == buttons[row][col].getCurrentTextColor()) {
                    buttons[row + i][col].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else {
                    buttons[row + i][col].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int j = 1; row - j >= 0; j++)
            {
                if(buttons[row - j][col].getText().equals(""))
                    buttons[row - j][col].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row - j][col].getCurrentTextColor() == buttons[row][col].getCurrentTextColor()) {
                    buttons[row - j][col].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else {
                    buttons[row - j][col].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int k = 1; col + k <= 7; k++)
            {
                if (buttons[row][col + k].getText().equals(""))
                    buttons[row][col + k].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row][col+k].getCurrentTextColor() == buttons[row][col].getCurrentTextColor()) {
                    buttons[row][col + k].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else {
                    buttons[row][col + k].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int l = 1; col - l >= 0; l++)
            {
                if (buttons[row][col - l].getText().equals(""))
                    buttons[row][col - l].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row][col - l].getCurrentTextColor() == buttons[row][col].getCurrentTextColor()) {
                    buttons[row][col - l].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else{
                    buttons[row][col - l].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
        }
        else if (buttons[row][col].getText().equals("B")) // if bishop is selected
        {
            for (int i = 1; row + i <= 7 && col + i <= 7; i++)
            {
                if (buttons[row + i][col + i].getText().equals(""))
                    buttons[row + i][col + i].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row + i][col + i].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                {
                    buttons[row + i][col + i].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else
                {
                    buttons[row + i][col + i].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int j = 1; row + j <= 7 && col - j >= 0; j++)
            {
                if (buttons[row + j][col - j].getText().equals(""))
                    buttons[row + j][col - j].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row + j][col - j].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                {
                    buttons[row + j][col - j].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else
                {
                    buttons[row + j][col - j].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int k = 1; row - k >= 0 && col - k >= 0; k++)
            {
                if (buttons[row - k][col - k].getText().equals(""))
                    buttons[row - k][col - k].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row - k][col - k].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                {
                    buttons[row - k][col - k].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else
                {
                    buttons[row - k][col - k].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int l = 1; row - l >= 0 && col + l <= 7; l++)
            {
                if (buttons[row - l][col + l].getText().equals(""))
                    buttons[row - l][col + l].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row - l][col + l].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                {
                    buttons[row - l][col + l].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else
                {
                    buttons[row - l][col + l].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
        }
        else if (buttons[row][col].getText().equals("Q")) // if queen is selected
        {
            for(int i = 1; row + i <= 7; i++)
            {
                if(buttons[row + i][col].getText().equals(""))
                    buttons[row + i][col].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row + i][col].getCurrentTextColor() == buttons[row][col].getCurrentTextColor()) {
                    buttons[row + i][col].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else {
                    buttons[row + i][col].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int j = 1; row - j >= 0; j++)
            {
                if(buttons[row - j][col].getText().equals(""))
                    buttons[row - j][col].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row - j][col].getCurrentTextColor() == buttons[row][col].getCurrentTextColor()) {
                    buttons[row - j][col].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else {
                    buttons[row - j][col].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int k = 1; col + k <= 7; k++)
            {
                if (buttons[row][col + k].getText().equals(""))
                    buttons[row][col + k].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row][col+k].getCurrentTextColor() == buttons[row][col].getCurrentTextColor()) {
                    buttons[row][col + k].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else {
                    buttons[row][col + k].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int l = 1; col - l >= 0; l++)
            {
                if (buttons[row][col - l].getText().equals(""))
                    buttons[row][col - l].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row][col - l].getCurrentTextColor() == buttons[row][col].getCurrentTextColor()) {
                    buttons[row][col - l].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else{
                    buttons[row][col - l].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int i = 1; row + i <= 7 && col + i <= 7; i++)
            {
                if (buttons[row + i][col + i].getText().equals(""))
                    buttons[row + i][col + i].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row + i][col + i].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                {
                    buttons[row + i][col + i].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else
                {
                    buttons[row + i][col + i].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int j = 1; row + j <= 7 && col - j >= 0; j++)
            {
                if (buttons[row + j][col - j].getText().equals(""))
                    buttons[row + j][col - j].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row + j][col - j].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                {
                    buttons[row + j][col - j].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else
                {
                    buttons[row + j][col - j].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int k = 1; row - k >= 0 && col - k >= 0; k++)
            {
                if (buttons[row - k][col - k].getText().equals(""))
                    buttons[row - k][col - k].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row - k][col - k].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                {
                    buttons[row - k][col - k].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else
                {
                    buttons[row - k][col - k].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            for (int l = 1; row - l >= 0 && col + l <= 7; l++)
            {
                if (buttons[row - l][col + l].getText().equals(""))
                    buttons[row - l][col + l].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row - l][col + l].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                {
                    buttons[row - l][col + l].setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                }
                else
                {
                    buttons[row - l][col + l].setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
        }
        else if (buttons[row][col].getText().equals("KG")) // if king is selected
        {
            if (row - 1 >= 0) {
                if (buttons[row - 1][col].getText().equals(""))
                    buttons[row - 1][col].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row - 1][col].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                    buttons[row - 1][col].setBackgroundColor(getResources().getColor(R.color.red));
                else
                    buttons[row - 1][col].setBackgroundColor(getResources().getColor(R.color.green));
                if (col - 1 >= 0)
                {
                    if (buttons[row - 1][col - 1].getText().equals(""))
                        buttons[row - 1][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
                    else if (buttons[row - 1][col - 1].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row - 1][col - 1].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row - 1][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (col + 1 <= 7)
                {
                    if (buttons[row - 1][col + 1].getText().equals(""))
                        buttons[row - 1][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
                    else if (buttons[row - 1][col + 1].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row - 1][col + 1].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row - 1][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
            if (row + 1 <= 7)
            {
                if (buttons[row + 1][col].getText().equals(""))
                    buttons[row + 1][col].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row + 1][col].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                    buttons[row + 1][col].setBackgroundColor(getResources().getColor(R.color.red));
                else
                    buttons[row + 1][col].setBackgroundColor(getResources().getColor(R.color.green));
                if (col - 1 >= 0)
                {
                    if (buttons[row + 1][col - 1].getText().equals(""))
                        buttons[row + 1][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
                    else if (buttons[row + 1][col - 1].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row + 1][col - 1].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row + 1][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
                }
                if (col + 1 <= 7)
                {
                    if (buttons[row + 1][col + 1].getText().equals(""))
                        buttons[row + 1][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
                    else if (buttons[row + 1][col + 1].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                        buttons[row + 1][col + 1].setBackgroundColor(getResources().getColor(R.color.red));
                    else
                        buttons[row + 1][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
            if (col - 1 >= 0)
            {
                if(buttons[row][col - 1].getText().equals(""))
                    buttons[row][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row][col - 1].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                    buttons[row][col - 1].setBackgroundColor(getResources().getColor(R.color.red));
                else
                    buttons[row][col - 1].setBackgroundColor(getResources().getColor(R.color.green));
            }
            if (col + 1 <= 7)
            {
                if(buttons[row][col + 1].getText().equals(""))
                    buttons[row][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
                else if (buttons[row][col + 1].getCurrentTextColor() == buttons[row][col].getCurrentTextColor())
                    buttons[row][col + 1].setBackgroundColor(getResources().getColor(R.color.red));
                else
                    buttons[row][col + 1].setBackgroundColor(getResources().getColor(R.color.green));
            }
        }
    }

    public void setPieces()
    {
        setBlackBishop();
        setBlackBishop();
        setBlackKing();
        setBlackKnight();
        setBlackKnight();
        setBlackQueen();
        setBlackRook();
        setBlackRook();

        setWhiteBishop();
        setWhiteBishop();
        setWhiteKing();
        setWhiteKnight();
        setWhiteKnight();
        setWhiteQueen();
        setWhiteRook();
        setWhiteRook();
    }

    public void setBlackRook()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("R");
            buttons[row][col].setTextColor(getResources().getColor(R.color.black));
        }
        else
            setBlackRook();
    }

    public void setWhiteRook()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("R");
            buttons[row][col].setTextColor(getResources().getColor(R.color.white));
        }
        else
            setWhiteRook();
    }

    public void setBlackKnight()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("K");
            buttons[row][col].setTextColor(getResources().getColor(R.color.black));
        }
        else
            setBlackKnight();
    }

    public void setWhiteKnight()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("K");
            buttons[row][col].setTextColor(getResources().getColor(R.color.white));
        }
        else
            setWhiteKnight();
    }

    public void setBlackBishop()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("B");
            buttons[row][col].setTextColor(getResources().getColor(R.color.black));
        }
        else
            setBlackBishop();
    }

    public void setWhiteBishop()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("B");
            buttons[row][col].setTextColor(getResources().getColor(R.color.white));
        }
        else
            setWhiteBishop();
    }

    public void setBlackKing()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("KG");
            buttons[row][col].setTextColor(getResources().getColor(R.color.black));
        }
        else
            setBlackKing();
    }

    public void setWhiteKing()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("KG");
            buttons[row][col].setTextColor(getResources().getColor(R.color.white));
        }
        else
            setWhiteKing();
    }

    public void setBlackQueen()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("Q");
            buttons[row][col].setTextColor(getResources().getColor(R.color.black));
        }
        else
            setBlackQueen();
    }

    public void setWhiteQueen()
    {
        int row = rand.nextInt(7);
        int col = rand.nextInt(7);
        if (buttons[row][col].getText().equals(""))
        {
            buttons[row][col].setText("Q");
            buttons[row][col].setTextColor(getResources().getColor(R.color.white));
        }
        else
            setWhiteQueen();
    }
}
