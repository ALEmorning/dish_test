package com.example.test.user;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.database.CommonDatabase;

import java.util.ArrayList;
import java.util.List;

public class collect extends AppCompatActivity {
    private SQLiteDatabase db;
    private List<item> arrayList;
    private collectAdapter c;
    private ListView listView_collect;
    private Button button_back;
    private Button button_choose;
    private CommonDatabase commonDatabase;
    private Intent intent_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        /////////////////////////////
        commonDatabase = new CommonDatabase();

        db = commonDatabase.getSqliteObject(collect.this, "test_db");

        /////////////////////////////
        listView_collect = findViewById(R.id.listview_u_collect);
        button_back = findViewById(R.id.back);
        button_choose = findViewById(R.id.choose);
        intent_3 = getIntent();
        View.OnClickListener listener_choose = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.choose:
                        String string_chongtu = "";
                        for (int i = 0; i < c.getCount(); i++) {
                            //获取子项的对象
                            item it = (item) c.getItem(i);

                            //如果是被选中的状态
                            if (it.ischeck == true) {
                                //去表中查一下是否已经存在
                                Cursor cursor = db.query("user_collect", null, "user_id =? AND menu_name =? ",
                                        new String[]{intent_3.getStringExtra("user_id"), it.getMenu_name()}, null, null, null);
                                //如果不存在
                                if (cursor.getCount() == 0) {
                                    ContentValues values1 = new ContentValues();
                                    ////////////////////////////////

                                    values1.put("user_id", intent_3.getStringExtra("user_id"));
                                    values1.put("menu_name", it.getMenu_name());

                                    db.insert("user_course", null, values1);
                                }
                                //存在说明已经选过了
                                else {
                                    string_chongtu += it.getMenu_name();
                                    string_chongtu += "/";
                                }
                            }
                            //如果没有冲突的
                            if (string_chongtu.equals("")) {
                                Toast.makeText(collect.this, "选课成功！", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(collect.this, string_chongtu + "重复选中，其他课程选课成功！", Toast.LENGTH_SHORT).show();
                            }

                        }

                        break;

                    case R.id.back:
                        finish();
                        break;
                }
            }
        };
        button_choose.setOnClickListener(listener_choose);
        button_back.setOnClickListener(listener_choose);
        /*

        //获取课程的全部信息
        Cursor cursor = db.query("course", null, null, null, null, null, null);



        arrayList = new ArrayList<item>();
        //对游标进行遍历
        while (cursor.moveToNext()) {

            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("menu_name"));


            item it = new item(name);
            arrayList.add(it);
        }

         */
        //实例化Adapter
        c = new collectAdapter(collect.this, arrayList);

        listView_collect.setAdapter(c);
    }
}





