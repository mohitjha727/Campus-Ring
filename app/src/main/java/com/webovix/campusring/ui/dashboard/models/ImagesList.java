package com.webovix.campusring.ui.dashboard.models;

public class ImagesList {
    String imageURL;

    public ImagesList() { }

    public ImagesList(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
