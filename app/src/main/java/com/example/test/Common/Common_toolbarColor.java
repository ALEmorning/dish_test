package com.example.test.Common;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;


import com.example.test.R;

public class Common_toolbarColor {

    public void toolbarColorSet(Activity activity)
    {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    window.setStatusBarColor(activity.getColor(R.color.colorPrimary));
                }
                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
