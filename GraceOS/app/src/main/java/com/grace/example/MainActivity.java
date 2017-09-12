package com.grace.example;

import android.app.*;
import android.os.Handler;
import android.support.v7.app.*;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.grace.Grace;

public class MainActivity extends AppCompatActivity {

      Grace grace=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grace = new Grace(this);
        grace.cover();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                grace.rest();
            }
        },5000);
    }

    private void onAgain(){
        grace.cover();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                grace.rest();
            }
        },5000);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dispatchTouchEvent","dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("MainActivity","onKeyDown");
        return super.onKeyDown(keyCode, event);
    }
}
