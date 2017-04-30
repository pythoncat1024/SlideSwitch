package com.python.cat.slideswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.python.cat.slideswitchlib.SlideSwitch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SlideSwitch ss = (SlideSwitch) findViewById(R.id.slide_switch);
        ss.setSwitchState(SlideSwitch.State.OPEN);

        ss.setOnCheckedChangeListener(new SlideSwitch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SlideSwitch buttonView, boolean isOpened) {
                Toast.makeText(getApplication(), "isOpened? " + isOpened, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
