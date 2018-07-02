package com.example.testjsonparse;

public class Tour {
    private String hotel;
    private String image;
    private int price;
    private int stars;


    public Tour(String hotel, String image, int price, int stars) {
        this.hotel = hotel;
        this.image = image;
        this.price = price;
        this.stars = stars;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getPrice() {
        return price;
    }

    public String getHotel() {
        return hotel;
    }

    public String getImage() {
        return image;
    }

    public int getStars() {
        return stars;
    }
}
