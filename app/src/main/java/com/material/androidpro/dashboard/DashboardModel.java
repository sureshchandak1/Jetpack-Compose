package com.material.androidpro.dashboard;

import com.material.androidpro.MaterialRetention;
import com.material.androidpro.compose.ui.ComposeUIRetention;

public class DashboardModel {

    private int image;
    private String title = "";
    private String shortDes = "";
    private @MaterialRetention.Material int materialType;

    private @ComposeUIRetention.ComposeUI int composeUIType;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public int getMaterialType() {
        return materialType;
    }

    public void setMaterialType(@MaterialRetention.Material int materialType) {
        this.materialType = materialType;
    }

    public int getComposeUIType() {
        return composeUIType;
    }

    public void setComposeUIType(@ComposeUIRetention.ComposeUI int composeUIType) {
        this.composeUIType = composeUIType;
    }
}
