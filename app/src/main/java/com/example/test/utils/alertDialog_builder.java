package com.example.test.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;


import androidx.appcompat.app.AlertDialog;

import com.example.test.R;
import com.example.test.start_load.load;

/*
    用于显示切换账户的对话框
 */
public class alertDialog_builder {
    private AlertDialog.Builder builder;
    private Context context;


    public alertDialog_builder(Context context) {

        this.context = context;

    }

    public AlertDialog.Builder build() {

        builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.ic_launcher_background);
        //    设置Title的内容
        builder.setTitle("提示");
        //    设置Content来显示一个信息
        builder.setMessage("您确定要切换账号吗？");
        //    设置一个PositiveButton
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.setClass(context, load.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        //    设置一个NegativeButton
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //    显示出该对话框
        return builder;
    }
}
