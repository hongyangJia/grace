package com.grace;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by hongyang on 17-8-25.
 */

public class OsTelevision extends FrameLayout {

    private LinearLayout osLode;
    private LinearLayout osLodeError;
    public static final int LODE_FLAG = 0x00;
    public static final int LODE_ERROR_FLAG = 0x01;

    public OsTelevision(Context context) {
        super(context);
        this.initialization();
    }

    public OsTelevision(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initialization();
    }

    private void initialization() {
        LayoutInflater.from(getContext()).inflate(R.layout.os_television, this);
        osLode = (LinearLayout) findViewById(R.id.os_lode);
        osLodeError = (LinearLayout) findViewById(R.id.os_lode_error);
    }

    public void conversion(int conversion) {
        switch (conversion){
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

}
