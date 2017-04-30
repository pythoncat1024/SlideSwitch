package com.python.cat.slideswitchlib.base;

import android.app.Application;

import com.apkfuns.logutils.LogUtils;

/**
 * packageName: com.python.cat.slideswitchlib.base
 * Created on 2017/4/30.
 *
 * @author cat
 */

public class SlideSwitchApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.getLogConfig().configShowBorders(false);
    }
}
