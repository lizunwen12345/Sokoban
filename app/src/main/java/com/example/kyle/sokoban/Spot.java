package com.example.kyle.sokoban;


import android.graphics.Color;
import android.graphics.Paint;

public class Spot {
    int radius;
    public Paint spotc= new Paint();
    public int x;
    public int y;
    public boolean filled = false;

    public Spot(int r)
    {
        radius = r;
        spotc.setColor(Color.GREEN);
    }
}
