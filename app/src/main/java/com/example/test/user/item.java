package com.example.test.user;

/*
item主要设计收藏时的选中状态以及信息
 */
public class item {
    String menu_name;

    Boolean ischeck;


    public item(String menu_name) {
        this.menu_name = menu_name;

        this.ischeck = false;

    }



    public String getMenu_name() {
        return menu_name;
    }



    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public Boolean getIscheck() {
        return ischeck;
    }

    public void setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }
}
