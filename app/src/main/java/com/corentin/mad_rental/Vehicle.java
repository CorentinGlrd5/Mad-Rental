package com.corentin.mad_rental;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Vehicle {
    private int id;
    @SerializedName("nom")
    private String name;
    private String image;
    @SerializedName("disponible")
    private int availability;
    @SerializedName("prixjournalierbase")
    private String price;
    private String promotion;
    private int agemin;
    private char categorieco2;
    @SerializedName("equipements")
    private List<Equipment> equipments;
    private List<Option> options;

    public Vehicle(int id, String name, String image, int availability, String price, String promotion, int agemin, char categorieco2, List<Equipment> equipments, List<Option> options) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.availability = availability;
        this.price = price;
        this.promotion = promotion;
        this.agemin = agemin;
        this.categorieco2 = categorieco2;
        this.equipments = equipments;
        this.options = options;
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

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public int getAgemin() {
        return agemin;
    }

    public void setAgemin(int agemin) {
        this.agemin = agemin;
    }

    public char getCategorieco2() {
        return categorieco2;
    }

    public void setCategorieco2(char categorieco2) {
        this.categorieco2 = categorieco2;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
