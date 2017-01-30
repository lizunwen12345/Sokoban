package com.example.kyle.sokoban;


public class Player
{
    int x;
    int y;
    public int centerX;
    public int centerY;
    int playerheight;
    int playerwidth;

    public Player(int xx, int yy, int height, int width)
    {
        playerheight = height;
        playerwidth = width;
        x = xx;
        y = yy;
        centerX = xx+20;
        centerY = yy+20;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void movement(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.centerX=x+20;
        this.centerY=y+20;
    }

}
