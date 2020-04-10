package com.xupt.springmvc.parameter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Wnlife
 * @create 2020-04-10 15:00
 */
public class Pojo {
    private String sex;
    private String[] tec;
    private String country;
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Pojo() {
    }

    public Pojo(String sex, String[] tec, String country) {
        this.sex = sex;
        this.tec = tec;
        this.country = country;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getTec() {
        return tec;
    }

    public void setTec(String[] tec) {
        this.tec = tec;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "sex='" + sex + '\'' +
                ", tec=" + Arrays.toString(tec) +
                ", country='" + country + '\'' +
                ", items=" + items +
                '}';
    }
}
