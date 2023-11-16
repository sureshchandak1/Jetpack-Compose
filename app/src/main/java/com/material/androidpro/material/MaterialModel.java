package com.material.androidpro.material;

public class MaterialModel {

    private String title;
    private int from;

    public MaterialModel(String title, int from) {
        this.title = title;
        this.from = from;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }
}
