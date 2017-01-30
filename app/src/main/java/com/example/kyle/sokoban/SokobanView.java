package com.example.kyle.sokoban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SokobanView extends SurfaceView implements SurfaceHolder.Callback
{
    int HEIGHT;
    int WIDTH;
    int level = 1;
    private SurfaceHolder holder;
    private Bitmap person = BitmapFactory.decodeResource(getResources(), R.drawable.player);
    private Bitmap instrument = BitmapFactory.decodeResource(getResources(),R.drawable.operation);
    //private Bitmap Airship = BitmapFactory.decodeResource(getResources(),R.drawable.airship1);

    Draw D;
    boolean running;

    public SokobanView(Context context)
    {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        holder = getHolder();
        HEIGHT = getHeight();
        WIDTH = getWidth();
    }

    SokobanThread st;
    boolean firsttime=true;

    @Override

    protected void onDraw(Canvas c) {
        c.drawColor(Color.GRAY);
        if (firsttime) {
            D = new Draw(HEIGHT, WIDTH);
            firsttime = false;
        }

        D.draw2(c, level);
        D.draw1(c, person, instrument);
        D.drawtext(c, level);
        if (level != checklevel(level))
        {
            D.holes.clear();
            D.spots.clear();
            D.boxes.clear();
            D.player.movement(WIDTH/2, HEIGHT/2);
            D.levelfirst = true;
            level++;
        }

        if (level < 5) {
            this.running = true;
        }
        else
        {
            this.running = false;
        }
        if (!running) {
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.FILL);
            c.drawPaint(paint);

            paint.setColor(Color.BLACK);
            paint.setTextSize(60);
            c.drawText("All 4 Levels Cleard!", WIDTH/10*3, HEIGHT / 2, paint);
            //c.drawText("You finished round " + D.roundcount, WIDTH/10*3, HEIGHT / 2 + HEIGHT / 10, paint);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        HEIGHT = getHeight();
        WIDTH = getWidth();
        Canvas c = holder.lockCanvas(null);
        onDraw(c);
        holder.unlockCanvasAndPost(c);
        st = new SokobanThread(getHolder(), this);
        st.setRunning(true);
        st.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        st.interrupt();
    }
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        int xxx;
        int yyy;
        int touchrange = 35;
        int predictedX;
        int predictedY;
        boolean flag;
		boolean flag2;
        int hittedbox;
        if(e.getAction()==MotionEvent.ACTION_DOWN)
        {
            if(e.getX()>=D.ins.leftbuttoncenterX()-touchrange && e.getX()<=D.ins.leftbuttoncenterX()+touchrange
                  && e.getY()>=D.ins.leftbuttoncenterY()-touchrange && e.getY()<=D.ins.leftbuttoncenterY()+touchrange)
            {
                //move left
                xxx = D.player.getX();
                yyy = D.player.getY();
                predictedX = D.player.centerX-80;
                predictedY = D.player.centerY;
                flag = legalmove(predictedX, predictedY);
                if (flag) {
                    hittedbox = checkhitbox(predictedX, predictedY);
                    if (hittedbox >= 0) {
                        int pX = D.boxes.get(hittedbox).left - 40;
                        int pY = D.boxes.get(hittedbox).up + 40;
                        flag = legalmove(pX, pY);
						flag2 = twoboxmove(pX, pY);
                        if (flag && flag2) {
                            D.boxes.get(hittedbox).left -= 80;
                            D.boxes.get(hittedbox).right -= 80;
                            D.player.movement(xxx - 80, yyy);
                        }
                    }
                    else{
                        D.player.movement(xxx - 80, yyy);
                    }
                }
                return true;
            }
            else if(e.getX()>=D.ins.rightbuttoncenterX()-touchrange && e.getX()<=D.ins.rightbuttoncenterX()+touchrange
                    && e.getY()>=D.ins.rightbuttoncenterY()-touchrange && e.getY()<=D.ins.rightbuttoncenterY()+touchrange)
            {
                //move right
                xxx = D.player.getX();
                yyy = D.player.getY();
                predictedX = D.player.centerX+80;
                predictedY = D.player.centerY;
                flag = legalmove(predictedX, predictedY);
                if (flag) {
                    hittedbox = checkhitbox(predictedX, predictedY);
                    if (hittedbox >= 0) {
                        int pX = D.boxes.get(hittedbox).right + 40;
                        int pY = D.boxes.get(hittedbox).up + 40;
                        flag = legalmove(pX, pY);
						flag2 = twoboxmove(pX, pY);
                        if (flag && flag2) {
                            D.boxes.get(hittedbox).left += 80;
                            D.boxes.get(hittedbox).right += 80;
                            D.player.movement(xxx + 80, yyy);
                        }
                    }
                    else{
                        D.player.movement(xxx + 80, yyy);
                    }
                }
                return true;
            }
            else if(e.getX()>=D.ins.upbuttoncenterX()-touchrange && e.getX()<=D.ins.upbuttoncenterX()+touchrange
                    && e.getY()>=D.ins.upbuttoncenterY()-touchrange && e.getY()<=D.ins.upbuttoncenterY()+touchrange)
            {
                //move up
                xxx = D.player.getX();
                yyy = D.player.getY();
                predictedX = D.player.centerX;
                predictedY = D.player.centerY-80;
                flag = legalmove(predictedX, predictedY);
                if (flag) {
                    hittedbox = checkhitbox(predictedX, predictedY);
                    if (hittedbox >= 0) {
                        int pX = D.boxes.get(hittedbox).left + 40;
                        int pY = D.boxes.get(hittedbox).up - 40;
                        flag = legalmove(pX, pY);
						flag2 = twoboxmove(pX, pY);
                        if (flag && flag2) {
                            D.boxes.get(hittedbox).up -= 80;
                            D.boxes.get(hittedbox).down -= 80;
                            D.player.movement(xxx, yyy - 80);
                        }
                    }
                    else{
                        D.player.movement(xxx, yyy - 80);
                    }
                }
                return true;
            }
            else if(e.getX()>=D.ins.downbuttoncenterX()-touchrange && e.getX()<=D.ins.downbuttoncenterX()+touchrange
                && e.getY()>=D.ins.downbuttoncenterY()-touchrange && e.getY()<=D.ins.downbuttoncenterY()+touchrange)
            {
                //move down
                xxx = D.player.getX();
                yyy = D.player.getY();
                predictedX = D.player.centerX;
                predictedY = D.player.centerY+80;
                flag = legalmove(predictedX, predictedY);
                if (flag) {
                    hittedbox = checkhitbox(predictedX, predictedY);
                    if (hittedbox >= 0) {
                        int pX = D.boxes.get(hittedbox).left + 40;
                        int pY = D.boxes.get(hittedbox).down + 40;
                        flag = legalmove(pX, pY);
						flag2 = twoboxmove(pX, pY);
                        if (flag && flag2) {
                            D.boxes.get(hittedbox).up += 80;
                            D.boxes.get(hittedbox).down += 80;
                            D.player.movement(xxx, yyy + 80);
                        }
                    }
                    else{
                        D.player.movement(xxx, yyy + 80);
                    }
                }
                return true;
            }
            else if (e.getX() > WIDTH/10*2 && e.getX() < WIDTH/10*5 && e.getY() > HEIGHT/30*28 && e.getY() < HEIGHT)
            {
                D.holes.clear();
                D.spots.clear();
                D.boxes.clear();
                D.player.movement(WIDTH/2, HEIGHT/2);
                D.levelfirst = true;
                return true;
            }
        }
        else if(e.getAction()==MotionEvent.ACTION_UP)
        {
            return false;
        }
        else
        {
            return false;
        }
        return false;
    }

    // this function is going to decide if a move will hit the wall
    public boolean legalmove(int x, int y)
    {
        int i;
        for (i = 0; i < D.holes.size(); i++) {
            if (x > D.holes.get(i).left && x < D.holes.get(i).right && y > D.holes.get(i).up && y < D.holes.get(i).down)
            {
                return false;
            }
        }
        return true;
    }
	
	// this function is going to decide if a move will hit two boxes 
	public boolean twoboxmove(int x, int y)
	{
		int i;
        for (i = 0; i < D.boxes.size(); i++) {
            if (x > D.boxes.get(i).left && x < D.boxes.get(i).right && y > D.boxes.get(i).up && y < D.boxes.get(i).down)
            {
                return false;
            }
        }
        return true;
	}

    //this function is going to decide if a move hit a box
    public int checkhitbox(int x, int y)
    {
        int i;
        for (i = 0; i < D.boxes.size(); i++) {
            if (x > D.boxes.get(i).left && x < D.boxes.get(i).right && y > D.boxes.get(i).up && y < D.boxes.get(i).down)
            {
                return i;
            }
        }
        return -1;
    }

    //this function is going to check if the player advances to the next level
    public int checklevel(int lev)
    {
        int i;
        int j;
        int a;
        for (i = 0; i < D.spots.size(); i++) {
            for (j = 0; j < D.boxes.size(); j++) {
                if (D.spots.get(i).x > D.boxes.get(j).left && D.spots.get(i).x < D.boxes.get(j).right && D.spots.get(i).y < D.boxes.get(j).down && D.spots.get(i).y > D.boxes.get(j).up)
                {
                    D.spots.get(i).filled = true;
                    j = D.boxes.size();
                }
                else
                {
                    D.spots.get(i).filled = false;
                }
            }
        }

        for (i = 0; i < D.spots.size(); i++)
        {
            if (!D.spots.get(i).filled)
            {
                return lev;
            }
        }
        a = lev + 1;
        return a;
    }
}