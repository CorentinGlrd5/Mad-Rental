package com.corentin.mad_rental;

public class ReservedVehicle {
    private int id;
    private String name;
    private String image;
    private Integer price;
    private String beginDate;
    private String endDate;

    public ReservedVehicle(int id, String name, String image, Integer price, String beginDate, String endDate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
