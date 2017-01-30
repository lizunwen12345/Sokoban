package com.example.kyle.sokoban;


import android.graphics.Color;
import android.graphics.Paint;

public class Box
{
    public int left;
    public int right;
    public int up;
    public int down;
    public int sidelength;
    public Paint boxc = new Paint();
    public int firstdraw = 0;

    public Box(int edge, int colorcode)
    {
        if (colorcode == 1)
        {
            boxc.setColor(Color.YELLOW);
        }
        else if (colorcode == 2)
        {
            boxc.setColor(Color.BLACK);
        }
        sidelength = edge;
    }

}
