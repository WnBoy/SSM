package com.xupt.springmvc.pojo;

/**
 * @author Wnlife
 * @create 2020-04-06 20:14
 */
public class Address {
    private String  city;
    private String  province;

    public Address() {
    }

    public Address(String city, String province) {
        this.city = city;
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
