package com.corentin.mad_rental;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Option implements Serializable{
    private int id;
    @SerializedName("nom")
    private String name;
    @SerializedName("prix")
    private int price;

    public Option(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
