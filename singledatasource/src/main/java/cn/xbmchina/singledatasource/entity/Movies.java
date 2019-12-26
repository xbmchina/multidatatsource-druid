package cn.xbmchina.singledatasource.entity;

import lombok.Data;

@Data
public class Movies {

    private String name;
    private int price;

    public Movies(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Movies() {
    }
}
