package com.example.travelagregatoralternative;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Tour implements Parcelable {
    private String hotel;
    private String image;
    private int price;
    private int stars;
    private String dateFrom;
    private String dateTo;


    public Tour(String hotel, String image, int price, int stars, String dateFrom, String dateTo) {
        this.hotel = hotel;
        this.image = image;
        this.price = price;
        this.stars = stars;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    private Tour(Parcel parcel) {
        this.hotel = parcel.readString();
        this.image = parcel.readString();
        this.price = parcel.readInt();
        this.stars = parcel.readInt();
        this.dateFrom = parcel.readString();
        this.dateTo = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hotel);
        dest.writeString(image);
        dest.writeInt(price);
        dest.writeInt(stars);
        dest.writeString(dateFrom);
        dest.writeString(dateTo);
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
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


    public static final Parcelable.Creator<Tour> CREATOR = new Parcelable.Creator<Tour>() {

        @Override
        public Tour createFromParcel(Parcel source) {
         return new Tour(source);
        }

        @Override
        public Tour[] newArray(int size) {
            return new Tour[size];
        }
    };
}
