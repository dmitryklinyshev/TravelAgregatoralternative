package com.example.travelagregatoralternative;

import android.os.Parcel;
import android.os.Parcelable;

public class Tour implements Parcelable {
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

    public Tour() {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<Tour> CREATOR = new Parcelable.Creator<Tour>() {

        @Override
        public Tour createFromParcel(Parcel source) {
         return new Tour();
        }

        @Override
        public Tour[] newArray(int size) {
            return new Tour[size];
        }
    };
}
