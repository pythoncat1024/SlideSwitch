package com.python.cat.slideswitch.base;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * packageName: com.python.cat.slideswitch.base
 * Created on 2017/4/30.
 *
 * @author cat
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        register();
    }

    private void register() {
        registerComponentCallbacks(new ComponentCallbacks() {
            @Override
            public void onConfigurationChanged(Configuration newConfig) {

            }

            @Override
            public void onLowMemory() {

            }
        });
        registerOnProvideAssistDataListener(new OnProvideAssistDataListener() {
            @Override
            public void onProvideAssistData(Activity activity, Bundle data) {

            }
        });
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
