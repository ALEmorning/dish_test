package com.example.test.database.sqlite;

import org.litepal.crud.LitePalSupport;

public class Food extends LitePalSupport {
    private long id;
    private String 品名;
    private String 产品类别;
    private String 食品生产许可证号;
    private String 产品标准号;
    private String 保质期;
    private String 贮存条件;
    private String 制造商;
    private String 地址;
    private String 产地;
    private String 营养成分;
    private String 净含量;
    private double 库存;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String get品名() {
        return 品名;
    }

    public void set品名(String 品名) {
        this.品名 = 品名;
    }

    public String get产品类别() {
        return 产品类别;
    }

    public void set产品类别(String 产品类别) {
        this.产品类别 = 产品类别;
    }

    public String get食品生产许可证号() {
        return 食品生产许可证号;
    }

    public void set食品生产许可证号(String 食品生产许可证号) {
        this.食品生产许可证号 = 食品生产许可证号;
    }

    public String get产品标准号() {
        return 产品标准号;
    }

    public void set产品标准号(String 产品标准号) {
        this.产品标准号 = 产品标准号;
    }

    public String get保质期() {
        return 保质期;
    }

    public void set保质期(String 保质期) {
        this.保质期 = 保质期;
    }

    public String get贮存条件() {
        return 贮存条件;
    }

    public void set贮存条件(String 贮存条件) {
        this.贮存条件 = 贮存条件;
    }

    public String get制造商() {
        return 制造商;
    }

    public void set制造商(String 制造商) {
        this.制造商 = 制造商;
    }

    public String get地址() {
        return 地址;
    }

    public void set地址(String 地址) {
        this.地址 = 地址;
    }

    public String get产地() {
        return 产地;
    }

    public void set产地(String 产地) {
        this.产地 = 产地;
    }

    public String get营养成分() {
        return 营养成分;
    }

    public void set营养成分(String 营养成分) {
        this.营养成分 = 营养成分;
    }

    public String get净含量() {
        return 净含量;
    }

    public void set净含量(String 净含量) {
        this.净含量 = 净含量;
    }

    public double get库存() {
        return 库存;
    }

    public void set库存(double 库存) {
        this.库存 = 库存;
    }

    @Override
    public String toString() {
        return "Food{" +
                "品名='" + 品名 + '\'' +
                ", 产品类别='" + 产品类别 + '\'' +
                ", 食品生产许可证号='" + 食品生产许可证号 + '\'' +
                ", 产品标准号='" + 产品标准号 + '\'' +
                ", 保质期='" + 保质期 + '\'' +
                ", 贮存条件='" + 贮存条件 + '\'' +
                ", 制造商='" + 制造商 + '\'' +
                ", 地址='" + 地址 + '\'' +
                ", 产地='" + 产地 + '\'' +
                ", 营养成分='" + 营养成分 + '\'' +
                ", 净含量='" + 净含量 + '\'' +
                ", 库存=" + 库存 +
                '}';
    }
}

