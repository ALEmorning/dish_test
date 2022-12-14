package com.example.test.administractor;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.database.CommonDatabase;


public class add_admin extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);

        db =new CommonDatabase().getSqliteObject(add_admin.this,"test_db");





        final EditText edit_admin_account = findViewById(R.id.edit_admin_account);
        final EditText edit_admin_password = findViewById(R.id.edit_admin_password);



        Button change = findViewById(R.id.button_add_admin_ok);
        change.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String account = edit_admin_account.getText().toString();
                final String password = edit_admin_password.getText().toString();
                ContentValues values = new ContentValues();
                values.put("account",account);
                values.put("password",(password));
                db.insert("administractor",null,values);
                Toast.makeText(add_admin.this,"增加管理员成功！",Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}
