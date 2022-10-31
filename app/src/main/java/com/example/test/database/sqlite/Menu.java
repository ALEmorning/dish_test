package com.example.test.database.sqlite;

import org.litepal.crud.LitePalSupport;

public class Menu extends LitePalSupport {
    private long id;
    private String 名称;
    private String 主料;
    private double 主料含量;
    private String 配料;
    private double 配料含量;
    private String 做法步骤;
    private String 菜系;
    private String 荤素;
    private String 可做;
    private double 价格;

    public String get名称() {
        return 名称;
    }

    public void set名称(String 名称) {
        this.名称 = 名称;
    }

    public String get主料() {
        return 主料;
    }

    public void set主料(String 主料) {
        this.主料 = 主料;
    }

    public double get主料含量() {
        return 主料含量;
    }

    public void set主料含量(double 主料含量) {
        this.主料含量 = 主料含量;
    }

    public String get配料() {
        return 配料;
    }

    public void set配料(String 配料) {
        this.配料 = 配料;
    }

    public double get配料含量() {
        return 配料含量;
    }

    public void set配料含量(double 配料含量) {
        this.配料含量 = 配料含量;
    }

    public String get做法步骤() {
        return 做法步骤;
    }

    public void set做法步骤(String 做法步骤) {
        this.做法步骤 = 做法步骤;
    }

    public String get菜系() {
        return 菜系;
    }

    public void set菜系(String 菜系) {
        this.菜系 = 菜系;
    }

    public String get荤素() {
        return 荤素;
    }

    public void set荤素(String 荤素) {
        this.荤素 = 荤素;
    }

    public String get可做() {
        return 可做;
    }

    public void set可做(String 可做) {
        this.可做 = 可做;
    }

    public double get价格() {
        return 价格;
    }

    public void set价格(double 价格) {
        this.价格 = 价格;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "名称='" + 名称 + '\'' +
                ", 主料='" + 主料 + '\'' +
                ", 主料含量=" + 主料含量 +
                ", 配料='" + 配料 + '\'' +
                ", 配料含量=" + 配料含量 +
                ", 做法步骤='" + 做法步骤 + '\'' +
                ", 菜系='" + 菜系 + '\'' +
                ", 荤素='" + 荤素 + '\'' +
                ", 可做='" + 可做 + '\'' +
                ", 价格=" + 价格 +
                '}';
    }
}


