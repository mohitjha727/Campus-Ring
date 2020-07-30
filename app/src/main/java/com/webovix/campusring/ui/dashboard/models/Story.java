package com.webovix.campusring.ui.dashboard.models;

import com.webovix.campusring.ui.dashboard.models.ImagesList;

import java.util.List;

public class Story {
    String name;
    List<ImagesList> imageList;

    public Story() {
    }

    public Story(String name, List<ImagesList> imageList) {
        this.name = name;
        this.imageList = imageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImagesList> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImagesList> imageList) {
        this.imageList = imageList;
    }
}
