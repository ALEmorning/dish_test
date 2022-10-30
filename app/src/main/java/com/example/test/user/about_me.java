package com.example.test.user;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.database.CommonDatabase;

/*
    我的信息功能实现，主要根据登录时传过来的intent所携带的数据
 */
public class about_me extends AppCompatActivity {
    SQLiteDatabase db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        //获取数据库对象
        db = new CommonDatabase().getSqliteObject(about_me.this, "test_db");

        //获取登录时传来的信息
        final Intent intent_about_me = getIntent();

        //绑定组件
        TextView t_about_id = findViewById(R.id.aboutme_id);
        TextView t_about_name = findViewById(R.id.aboutme_name);
        TextView t_about_phone = findViewById(R.id.aboutme_phone);
        TextView t_about_sex = findViewById(R.id.aboutme_sex);
        TextView t_about_age = findViewById(R.id.aboutme_age);

        Cursor cursor_about = db.query("user", null, "id = ?", new String[]{intent_about_me.getStringExtra("id")}, null, null, null);
        while (cursor_about.moveToNext()) {
            //将通过id查询到的信息显示到界面中
            t_about_id.setText(cursor_about.getString(cursor_about.getColumnIndex("id")));
            t_about_name.setText(cursor_about.getString(cursor_about.getColumnIndex("name")));

            t_about_phone.setText(cursor_about.getString(cursor_about.getColumnIndex("phone")));
            t_about_sex.setText(cursor_about.getString(cursor_about.getColumnIndex("sex")));
            t_about_age.setText(cursor_about.getString(cursor_about.getColumnIndex("age")));


        }
        Button button_back = findViewById(R.id.button_finish_about);


        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
