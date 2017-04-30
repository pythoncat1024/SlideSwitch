# SlideSwitch
android 自定义控件 滑动开关

* 滑动开关
  类似于`CheckBox`,有开和关两种状态；与之不同之处在于，不仅可以通过点击切换开关状态，还可以通过手指滑动的方式切换状态。
  
* How To 参照[jitpack.io仓库](https://jitpack.io/#pythoncat1024/SlideSwitch/1.0.0)
  * gradle
    * Step 1. Add the JitPack repository to your build file
 
	    ```gradle
	    allprojects {
			repositories {
	        ...
	        maven { url 'https://jitpack.io' }
	      }
	    }
	    ```

    * Step 2. Add the dependency

	    ```gradle
	    dependencies {
		        compile 'com.github.pythoncat1024:SlideSwitch:1.0.0'
		  }
	    ```
    * Step 3. use in xml
    ```xml
    <com.python.cat.slideswitchlib.SlideSwitch
        android:id="@+id/slide_switch"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#0000" />
    ```
    * Step 4. use in Activity
    ```java
    SlideSwitch ss = (SlideSwitch) findViewById(R.id.slide_switch);
        ss.setSwitchState(SlideSwitch.State.OPEN);

        ss.setOnCheckedChangeListener(new SlideSwitch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SlideSwitch buttonView, boolean isOpened) {
                Toast.makeText(getApplication(), "isOpened? " + isOpened, Toast.LENGTH_SHORT).show();
            }
        });
    ```
* 使用步骤结束。

* 关于实现:参照源码...

