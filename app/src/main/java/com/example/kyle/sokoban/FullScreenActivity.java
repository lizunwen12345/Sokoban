package com.example.kyle.sokoban;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class FullScreenActivity extends Activity{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(new SokobanView(this));
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }

}
