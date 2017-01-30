package com.example.kyle.sokoban;


public class instrument
{
    public float x;
    public float y;

    public instrument(int width, int height)
    {
        x = (float)(width*0.7);
        y = (float)(height*0.85);
    }

    public float leftbuttoncenterX()
    {
        return x + 70;
    }

    public float leftbuttoncenterY()
    {
        return y + 130;
    }

    public float rightbuttoncenterX()
    {
        return x + 220;
    }

    public float rightbuttoncenterY()
    {
        return y + 130;
    }

    public float upbuttoncenterX()
    {
        return x + 145;
    }

    public float upbuttoncenterY()
    {
        return y + 60;
    }

    public float downbuttoncenterX()
    {
        return x + 145;
    }

    public float downbuttoncenterY()
    {
        return y + 200;
    }
}
