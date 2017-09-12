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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Grace grace = new Grace(this);
        grace.cover();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                grace.rest();
            }
        },5000);
    }

    private void syncNow(){
        Toast.makeText(this,"yeah yeah yeah ",Toast.LENGTH_SHORT).show();
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
