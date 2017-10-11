package com.grace;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hongyang on 17-8-25.
 */

public class OsTelevision extends FrameLayout {

    private LinearLayout osLode;
    private LinearLayout osLodeError;
    public static final int LODE_FLAG = 0x00;
    public static final int LODE_ERROR_FLAG = 0x01;
    private static final String METHOD = "onAgain";
    private int conversion;

    public OsTelevision(Activity context) {
        super(context);
        this.initialization();
    }

    public OsTelevision(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initialization();
    }

    private void initialization() {
        setFocusable(true);
        LayoutInflater.from(getContext()).inflate(R.layout.os_television, this);
        osLode = (LinearLayout) findViewById(R.id.os_lode);
        osLodeError = (LinearLayout) findViewById(R.id.os_lode_error);
    }

    public void conversion(int conversion) {
        this.conversion = conversion;
        switch (conversion) {
            case LODE_FLAG:
                osLode.setVisibility(VISIBLE);
                osLodeError.setVisibility(GONE);
                break;
            case LODE_ERROR_FLAG:
                osLode.setVisibility(GONE);
                osLodeError.setVisibility(VISIBLE);
                break;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
                if (conversion == LODE_ERROR_FLAG) {
                    method();
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void method() {
        try {
            Method method = getContext().getClass().getDeclaredMethod(METHOD);
            method.setAccessible(true);
            try {
                method.invoke(getContext());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
