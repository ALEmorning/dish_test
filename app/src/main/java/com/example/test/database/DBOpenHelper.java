package com.example.test.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/*
   该界面主要用于建表，以及设定完整性
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    private Context mContext;

    //带全部参数的构造函数，此构造函数必不可少
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //食材信息
        String sql_food = " create table Food( " +
                 " ID int primary key not null , " +
                 " 品名 text , " +
                 " 产品类别 text , " +
                 " 食品生产许可证号 text , " +
                 " 产品标准号 text , " +
                 " 保质期 text , " +
                 " 贮存条件 text , " +
                 " 制造商 text , " +
                 " 地址 text , " +
                 " 产地 text , " +
                 " 营养成分 text , " +
                 " 净含量 text , " +
                 " 库存 double) ;";
        //菜谱信息
        String sql_menu = " create table Menu( " +
                " ID int primary key not null , " +
                " 名称 text , " +
                " 主料 text , " +
                " 主料含量 double ," +
                " 配料 text , " +
                " 配料含量 double , " +
                " 做法步骤 text , " +
                " 菜系 text , " +
                " 荤素 text , " +
                " 可做 char(10) , " +
                " 价格 double , " +
                " FOREIGN KEY(主料) REFERENCES Food(品名) , " +
                " FOREIGN KEY(配料) REFERENCES Food(品名) ," +
                " FOREIGN KEY(主料含量) REFERENCES Food(库存) ," +
                " FOREIGN KEY(配料含量) REFERENCES Food(库存) );" ;
        db.execSQL(sql_food);
        db.execSQL(sql_menu);

        String sql_caidan = " create table caidan( " +
                " ID int primary key not null , " +
                " 名称 text , " +
                " 荤素 text , " +
                " 菜系 text , " +
                " 价格 double , " +
                " FOREIGN KEY(名称) REFERENCES Menu(名称) , " +
                " FOREIGN KEY(荤素) REFERENCES Menu(荤素) , " +
                " FOREIGN KEY(菜系) REFERENCES Menu(菜系) , " +
                " FOREIGN KEY(价格) REFERENCES Menu(价格) ) ;" ;
        db.execSQL(sql_caidan);

        //创建成功
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();



        //插入信息
        String sql_insertf1 = "insert into Food(ID,品名,产品类别) values ('001','青菜','素');";
        String sql_insertm1 = "insert into Menu(ID,名称,主料) values ('001','炒青菜','青菜');";

        db.execSQL(sql_insertf1);
        db.execSQL(sql_insertm1);

        //用户信息
        String user = "create table user(" +
                " id int primary key not null , " +
                " name char(20) , " +
                " sex varchar(10) , " +
                " age int , " +
                " phone int) ;";
        //用户——登陆密码表
        String sql_user_load = "create table load_account(account int primary Key not null ,password varchar(20));";
        String sql_insertu1 = "insert into user(id,name,sex,phone) values ('001','赵某某','男','100861');";
        String sql_insertu2 = "insert into user(id,name,sex,phone) values ('002','钱某某','男','100862');";
        String sql_insertl1 = "insert into load_account values ('001','123456')";


        db.execSQL(user);
        db.execSQL(sql_user_load);
        db.execSQL(sql_insertu1);
        db.execSQL(sql_insertu2);
        db.execSQL(sql_insertl1);

        //管理员表
        String sql_admin = "create table administractor(" +
                " account varchar(20)," +
                " password varchar(20));";
        String sql_inserta1 = "insert into administractor values('admin','123456');";





        db.execSQL(sql_admin);
        db.execSQL(sql_inserta1);

        //用户收藏信息表
        String sql_user_collect = "create table user_collect(" +
                " id int , " +
                " menu_name varchar(20) , " +
                " menu_number int , " +
                " menu_caixi varchar(10) , " +
                " menu_hunsu int , " +
                " FOREIGN KEY(menu_name) REFERENCES Menu(名称) , " +
                " FOREIGN KEY(menu_caixi) REFERENCES Menu(菜系) , " +
                " FOREIGN KEY(menu_hunsu) REFERENCES Menu(荤素) ) ;" ;
        db.execSQL(sql_user_collect);
        //留言信息存储表
        String sql_liuyan = "create table message(" +
                " id int primary key not null," +
                " message text);";
        db.execSQL(sql_liuyan);

        //个人资源配置表，比如更改图片之类的啦
        String personal_resource = "create table personal_resource(" +
                "id int primary key not null ," +
                "IMAGE blob);";

        db.execSQL(personal_resource);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
