package com.example.kyle.sokoban;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Draw {
    Player player;
    //Box box;
    instrument ins;
    int screenheight;
    int screenwidth;
    ArrayList<Box> boxes = new ArrayList<Box>();
    ArrayList<Box> holes = new ArrayList<Box>();
    ArrayList<Spot> spots = new ArrayList<Spot>();


    public Draw(int height, int width) {
        screenheight = height;
        screenwidth = width;
        player = new Player(screenwidth/2, screenheight/2, height, width);
        //box = new Box(80, 1);
        ins = new instrument(screenwidth, screenheight);
    }


    public void draw1(Canvas c, Bitmap Player, Bitmap inst) {
        c.drawBitmap(Player, player.getX(), player.getY(), null);
        //c.drawRect(screenwidth / 2, screenheight / 2, screenwidth / 2 + box.sidelength, screenheight / 2 + box.sidelength, box.boxc);
        c.drawBitmap(inst, ins.x, ins.y, null);
    }

    int i;
    int j;
    boolean levelfirst = true;
    //boolean level2first = true;
    //boolean level3first = true;
    //boolean level4first = true;
    public void draw2(Canvas c, int level) {
        if (level == 1) {
            // draw holes
            drawholecolumn(c, 0, 4, screenwidth / 2 - 80, screenheight / 2, true, levelfirst);
            drawholeline(c, 4, 8, screenwidth / 2 - 320, screenheight / 2 - 560, true, levelfirst);
            drawholeline(c, 12, 8, screenwidth / 2 - 320, screenheight / 2 + 560, true, levelfirst);
            drawholecolumn(c, 20, 15, screenwidth / 2 - 320, screenheight / 2 - 560, false, levelfirst);
            drawholecolumn(c, 35, 15, screenwidth / 2 + 320, screenheight / 2 - 560, false, levelfirst);


            // draw boxes
            if (levelfirst) {
                boxes.add(new Box(80, 1));
                boxes.get(0).left = screenwidth / 2;
                boxes.get(0).up = screenheight / 2 - boxes.get(0).sidelength;
                boxes.get(0).right = screenwidth / 2 + boxes.get(0).sidelength;
                boxes.get(0).down = screenheight / 2;
                boxes.get(0).firstdraw = 1;
            }
            c.drawRect(boxes.get(0).left, boxes.get(0).up, boxes.get(0).right, boxes.get(0).down, boxes.get(0).boxc);

            // draw spots
            if (levelfirst) {
                spots.add(new Spot(33));
                spots.get(0).x = screenwidth / 2 + 40;
                spots.get(0).y = screenheight / 2 - 200;
            }
            c.drawCircle(spots.get(0).x, spots.get(0).y, spots.get(0).radius, spots.get(0).spotc);

            levelfirst = false;
        }
        else if (level == 2){
            // draw holes
            drawholeline(c, 0, 8, screenwidth/2-240, screenheight/2+80, true, levelfirst);
            drawholecolumn(c, 8, 4, screenwidth / 2 + 320, screenheight / 2 + 80, true, levelfirst);
            drawholeline(c, 12, 2, screenwidth / 2 + 320, screenheight / 2 - 160, false, levelfirst);
            drawholecolumn(c, 14, 3, screenwidth / 2 + 240, screenheight / 2 - 160, true, levelfirst);
            drawholeline(c, 17, 2, screenwidth / 2 + 240, screenheight / 2 - 320, false, levelfirst);
            drawholecolumn(c, 19, 3, screenwidth / 2 + 160, screenheight / 2 - 320, true, levelfirst);
            drawholeline(c, 22, 4, screenwidth / 2 + 160, screenheight / 2 - 480, false, levelfirst);
            drawholecolumn(c, 26, 3, screenwidth / 2 - 80, screenheight / 2 - 480, false, levelfirst);
            drawholeline(c, 29, 2, screenwidth / 2 - 80, screenheight / 2 - 320, false, levelfirst);
            drawholecolumn(c, 31, 3, screenwidth / 2 - 160, screenheight / 2 - 320, false, levelfirst);
            drawholeline(c, 34, 2, screenwidth / 2 - 160, screenheight / 2 - 160, false, levelfirst);
            drawholecolumn(c, 36, 4, screenwidth / 2 - 240, screenheight / 2 - 160, false, levelfirst);
            drawholeline(c, 40, 1, screenwidth/2, screenheight/2-80, true, levelfirst);

            //draw boxes
            if (levelfirst) {
                boxes.add(new Box(80, 1));
                boxes.get(0).left = screenwidth / 2;
                boxes.get(0).up = screenheight / 2 - 2*boxes.get(0).sidelength;
                boxes.get(0).right = screenwidth / 2 + boxes.get(0).sidelength;
                boxes.get(0).down = screenheight / 2 - boxes.get(0).sidelength;
                boxes.get(0).firstdraw = 1;

                boxes.add(new Box(80, 1));
                boxes.get(1).left = screenwidth / 2 + boxes.get(1).sidelength;
                boxes.get(1).up = screenheight / 2 - boxes.get(1).sidelength;
                boxes.get(1).right = screenwidth / 2 + 2*boxes.get(0).sidelength;
                boxes.get(1).down = screenheight / 2;
                boxes.get(1).firstdraw = 1;

                boxes.add(new Box(80, 1));
                boxes.get(2).left = screenwidth / 2 + boxes.get(2).sidelength;
                boxes.get(2).up = screenheight / 2 - 3*boxes.get(2).sidelength;
                boxes.get(2).right = screenwidth / 2 + 2*boxes.get(2).sidelength;
                boxes.get(2).down = screenheight / 2 - 2*boxes.get(2).sidelength;
                boxes.get(2).firstdraw = 1;

                boxes.add(new Box(80, 1));
                boxes.get(3).left = screenwidth / 2 + 2*boxes.get(3).sidelength;
                boxes.get(3).up = screenheight / 2 - boxes.get(3).sidelength;
                boxes.get(3).right = screenwidth / 2 + 3*boxes.get(3).sidelength;
                boxes.get(3).down = screenheight / 2;
                boxes.get(3).firstdraw = 1;
            }
            c.drawRect(boxes.get(0).left, boxes.get(0).up, boxes.get(0).right, boxes.get(0).down, boxes.get(0).boxc);
            c.drawRect(boxes.get(1).left, boxes.get(1).up, boxes.get(1).right, boxes.get(1).down, boxes.get(1).boxc);
            c.drawRect(boxes.get(2).left, boxes.get(2).up, boxes.get(2).right, boxes.get(2).down, boxes.get(2).boxc);
            c.drawRect(boxes.get(3).left, boxes.get(3).up, boxes.get(3).right, boxes.get(3).down, boxes.get(3).boxc);

            //draw spots
            if (levelfirst) {
                spots.add(new Spot(33));
                spots.get(0).x = screenwidth / 2 + 40;
                spots.get(0).y = screenheight / 2 - 360;

                spots.add(new Spot(33));
                spots.get(1).x = screenwidth / 2 + 120;
                spots.get(1).y = screenheight / 2 - 360;

                spots.add(new Spot(33));
                spots.get(2).x = screenwidth / 2 + 120;
                spots.get(2).y = screenheight / 2 - 280;

                spots.add(new Spot(33));
                spots.get(3).x = screenwidth / 2 + 200;
                spots.get(3).y = screenheight / 2 - 200;
            }
            c.drawCircle(spots.get(0).x, spots.get(0).y, spots.get(0).radius, spots.get(0).spotc);
            c.drawCircle(spots.get(1).x, spots.get(1).y, spots.get(1).radius, spots.get(1).spotc);
            c.drawCircle(spots.get(2).x, spots.get(2).y, spots.get(2).radius, spots.get(2).spotc);
            c.drawCircle(spots.get(3).x, spots.get(3).y, spots.get(3).radius, spots.get(3).spotc);
            levelfirst = false;
        }
        else if (level == 3)
        {
            // draw holes
            drawholeline(c, 0, 4, screenwidth/2-240, screenheight/2-320, true, levelfirst);
            drawholecolumn(c, 4, 3, screenwidth / 2 - 240, screenheight / 2 - 320, false, levelfirst);
            drawholeline(c, 7, 2, screenwidth / 2 - 240, screenheight / 2 - 160, false, levelfirst);
            drawholecolumn(c, 9, 4, screenwidth / 2 - 320, screenheight / 2 - 160, false, levelfirst);
            drawholeline(c, 13, 2, screenwidth / 2 - 320, screenheight / 2 + 80, true, levelfirst);
            drawholecolumn(c, 15, 3, screenwidth / 2 - 240, screenheight / 2 + 80, false, levelfirst);
            drawholeline(c, 18, 5, screenwidth / 2 - 240, screenheight / 2 + 240, true, levelfirst);
            drawholecolumn(c, 23, 5, screenwidth / 2 + 80, screenheight / 2 + 240, true, levelfirst);
            drawholeline(c, 28, 2, screenwidth / 2 + 80, screenheight / 2 - 80, false, levelfirst);
            drawholecolumn(c, 30, 4, screenwidth/2, screenheight/2-80, true, levelfirst);

            //draw boxes
            if (levelfirst) {
                boxes.add(new Box(80, 1));
                boxes.get(0).left = screenwidth / 2 - boxes.get(0).sidelength;
                boxes.get(0).up = screenheight / 2;
                boxes.get(0).right = screenwidth / 2 ;
                boxes.get(0).down = screenheight / 2 + boxes.get(0).sidelength;
                boxes.get(0).firstdraw = 1;

                boxes.add(new Box(80, 1));
                boxes.get(1).left = screenwidth / 2 - boxes.get(1).sidelength;
                boxes.get(1).up = screenheight / 2 - boxes.get(1).sidelength;
                boxes.get(1).right = screenwidth / 2;
                boxes.get(1).down = screenheight / 2;
                boxes.get(1).firstdraw = 1;

                boxes.add(new Box(80, 1));
                boxes.get(2).left = screenwidth / 2 - 2*boxes.get(2).sidelength;
                boxes.get(2).up = screenheight / 2 + boxes.get(2).sidelength;
                boxes.get(2).right = screenwidth / 2 - boxes.get(2).sidelength;
                boxes.get(2).down = screenheight / 2 + 2*boxes.get(2).sidelength;
                boxes.get(2).firstdraw = 1;
            }
            c.drawRect(boxes.get(0).left, boxes.get(0).up, boxes.get(0).right, boxes.get(0).down, boxes.get(0).boxc);
            c.drawRect(boxes.get(1).left, boxes.get(1).up, boxes.get(1).right, boxes.get(1).down, boxes.get(1).boxc);
            c.drawRect(boxes.get(2).left, boxes.get(2).up, boxes.get(2).right, boxes.get(2).down, boxes.get(2).boxc);

            //draw spots
            if (levelfirst) {
                spots.add(new Spot(33));
                spots.get(0).x = screenwidth / 2 - 120;
                spots.get(0).y = screenheight / 2 + 40;

                spots.add(new Spot(33));
                spots.get(1).x = screenwidth / 2 - 120;
                spots.get(1).y = screenheight / 2 + 200;

                spots.add(new Spot(33));
                spots.get(2).x = screenwidth / 2 - 120;
                spots.get(2).y = screenheight / 2 - 120;
            }
            c.drawCircle(spots.get(0).x, spots.get(0).y, spots.get(0).radius, spots.get(0).spotc);
            c.drawCircle(spots.get(1).x, spots.get(1).y, spots.get(1).radius, spots.get(1).spotc);
            c.drawCircle(spots.get(2).x, spots.get(2).y, spots.get(2).radius, spots.get(2).spotc);
            levelfirst = false;
        }
        else if (level == 4)
        {
            //draw holes
            drawholeline(c, 0, 4, screenwidth/2-240, screenheight/2-160, true, levelfirst);
            drawholecolumn(c, 4, 2, screenwidth / 2, screenheight / 2 - 160, false, levelfirst);
            drawholeline(c, 6, 2, screenwidth / 2, screenheight / 2 - 80, true, levelfirst);
            drawholecolumn(c, 8, 3, screenwidth / 2 + 80, screenheight / 2 - 80, false, levelfirst);
            drawholeline(c, 11, 2, screenwidth / 2 + 80, screenheight / 2 + 80, false, levelfirst);
            drawholecolumn(c, 13, 2, screenwidth / 2, screenheight / 2 + 80, false, levelfirst);
            drawholeline(c, 15, 2, screenwidth / 2, screenheight / 2 + 160, true, levelfirst);
            drawholecolumn(c, 17, 4, screenwidth / 2 + 80, screenheight / 2 + 160, false, levelfirst);
            drawholeline(c, 21, 6, screenwidth / 2 + 80, screenheight / 2 + 400, false, levelfirst);
            drawholecolumn(c, 27, 5, screenwidth/2-320, screenheight/2+400, true,levelfirst);
            drawholeline(c, 32, 2, screenwidth/2-320, screenheight/2+80, true, levelfirst);
            drawholecolumn(c, 34, 4, screenwidth/2-240, screenheight/2+80, true,levelfirst);

            //draw boxes
            if (levelfirst) {
                boxes.add(new Box(80, 1));
                boxes.get(0).left = screenwidth / 2 - boxes.get(0).sidelength;
                boxes.get(0).up = screenheight / 2;
                boxes.get(0).right = screenwidth / 2 ;
                boxes.get(0).down = screenheight / 2 + boxes.get(0).sidelength;
                boxes.get(0).firstdraw = 1;

                boxes.add(new Box(80, 1));
                boxes.get(1).left = screenwidth / 2 - boxes.get(1).sidelength;
                boxes.get(1).up = screenheight / 2 + boxes.get(1).sidelength;
                boxes.get(1).right = screenwidth / 2;
                boxes.get(1).down = screenheight / 2 + 2*boxes.get(1).sidelength;
                boxes.get(1).firstdraw = 1;

                boxes.add(new Box(80, 1));
                boxes.get(2).left = screenwidth / 2 - 2*boxes.get(2).sidelength;
                boxes.get(2).up = screenheight / 2 + 2*boxes.get(2).sidelength;
                boxes.get(2).right = screenwidth / 2 - boxes.get(2).sidelength;
                boxes.get(2).down = screenheight / 2 + 3*boxes.get(2).sidelength;
                boxes.get(2).firstdraw = 1;

                boxes.add(new Box(80, 1));
                boxes.get(3).left = screenwidth / 2 - 2*boxes.get(3).sidelength;
                boxes.get(3).up = screenheight / 2 + 4*boxes.get(3).sidelength;
                boxes.get(3).right = screenwidth / 2 - boxes.get(3).sidelength;
                boxes.get(3).down = screenheight / 2 + 5*boxes.get(3).sidelength;
                boxes.get(3).firstdraw = 1;
            }
            c.drawRect(boxes.get(0).left, boxes.get(0).up, boxes.get(0).right, boxes.get(0).down, boxes.get(0).boxc);
            c.drawRect(boxes.get(1).left, boxes.get(1).up, boxes.get(1).right, boxes.get(1).down, boxes.get(1).boxc);
            c.drawRect(boxes.get(2).left, boxes.get(2).up, boxes.get(2).right, boxes.get(2).down, boxes.get(2).boxc);
            c.drawRect(boxes.get(3).left, boxes.get(3).up, boxes.get(3).right, boxes.get(3).down, boxes.get(3).boxc);

            //draw spots
            if (levelfirst) {
                spots.add(new Spot(33));
                spots.get(0).x = screenwidth / 2 + 40;
                spots.get(0).y = screenheight / 2 + 280;

                spots.add(new Spot(33));
                spots.get(1).x = screenwidth / 2 + 40;
                spots.get(1).y = screenheight / 2 + 360;

                spots.add(new Spot(33));
                spots.get(2).x = screenwidth / 2 - 40;
                spots.get(2).y = screenheight / 2 + 360;

                spots.add(new Spot(33));
                spots.get(3).x = screenwidth / 2 - 200;
                spots.get(3).y = screenheight / 2 + 360;
            }
            c.drawCircle(spots.get(0).x, spots.get(0).y, spots.get(0).radius, spots.get(0).spotc);
            c.drawCircle(spots.get(1).x, spots.get(1).y, spots.get(1).radius, spots.get(1).spotc);
            c.drawCircle(spots.get(2).x, spots.get(2).y, spots.get(2).radius, spots.get(2).spotc);
            c.drawCircle(spots.get(3).x, spots.get(3).y, spots.get(3).radius, spots.get(3).spotc);
            levelfirst = false;
        }

    }

    public void drawtext(Canvas c, int levela){
        //draw text
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
        c.drawText("Level " + levela, screenwidth/10*2, screenheight/30, paint);
        paint.setTextSize(50);
        c.drawText("Restart the level", screenwidth/10*2, screenheight/30*29, paint);
    }

    // this function is going to write a line of wall to make level make easily
    public void drawholeline(Canvas c, int cn, int n, int x, int y, boolean dir, boolean first){
        // cn represents current hole numbers
        if (first) {
            for (i = cn; i < cn + n; i++) {
                holes.add(new Box(80, 2));
            }
        }
        if (dir) {
            // write the line to right direction if dir == true
            j = 0;
            for (i = cn; i < cn+n; i++) {
                holes.get(i).left = x + j * holes.get(i).sidelength;
                holes.get(i).up = y;
                holes.get(i).right = x + (j + 1) * holes.get(i).sidelength;
                holes.get(i).down = y + holes.get(i).sidelength;
                j++;
                c.drawRect(holes.get(i).left, holes.get(i).up, holes.get(i).right, holes.get(i).down, holes.get(i).boxc);
            }
        }
        else
        {
            j = 0;
            for (i = cn; i < cn+n; i++) {
                holes.get(i).left = x - j * holes.get(i).sidelength;
                holes.get(i).up = y;
                holes.get(i).right = x - (j-1) * holes.get(i).sidelength;
                holes.get(i).down = y + holes.get(i).sidelength;
                j++;
                c.drawRect(holes.get(i).left, holes.get(i).up, holes.get(i).right, holes.get(i).down, holes.get(i).boxc);
            }
        }
    }

    // this function is going to write a column of wall to make level make easily
    public void drawholecolumn(Canvas c, int cn, int n, int x, int y, boolean dir, boolean first){
        // cn represents current hole numbers
        if (first) {
            for (i = cn; i < cn + n; i++) {
                holes.add(new Box(80, 2));
            }
        }
        if (dir) {
            // write the column to up direction if dir == true
            j = 0;
            for (i = cn; i < cn+n; i++) {
                holes.get(i).left = x;
                holes.get(i).up = y - j * holes.get(i).sidelength;
                holes.get(i).right = x + holes.get(i).sidelength;
                holes.get(i).down = y - (j-1) * holes.get(i).sidelength;
                j++;
                c.drawRect(holes.get(i).left, holes.get(i).up, holes.get(i).right, holes.get(i).down, holes.get(i).boxc);
            }
        }
        else
        {
            j = 0;
            for (i = cn; i < cn+n; i++) {
                holes.get(i).left = x;
                holes.get(i).up = y + j * holes.get(i).sidelength;
                holes.get(i).right = x + holes.get(i).sidelength;
                holes.get(i).down = y + (j+1) * holes.get(i).sidelength;
                j++;
                c.drawRect(holes.get(i).left, holes.get(i).up, holes.get(i).right, holes.get(i).down, holes.get(i).boxc);
            }
        }
    }
}