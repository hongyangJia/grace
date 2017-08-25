package com.grace;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hongyang on 17-8-25.
 */

public class Grace {

    private OsTelevision mOsTelevision;
    private Activity mActivity;

    public Grace(Activity mActivity) {
        this.mActivity = mActivity;
        mOsTelevision = new OsTelevision(mActivity);
    }

    public void cover() {
        mOsTelevision.conversion(OsTelevision.LODE_FLAG);
        if (mOsTelevision != null) {
            mActivity.addContentView(mOsTelevision, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }

    public void rest() {
        if (mOsTelevision!=null){
            mOsTelevision.conversion(OsTelevision.LODE_ERROR_FLAG);
        }
    }

    public void removed() {
        if (mOsTelevision != null) {
            ViewGroup contentParent = (ViewGroup) mOsTelevision.getParent();
            contentParent.removeView(mOsTelevision);
        }
        this.mOsTelevision=null;
    }

}
