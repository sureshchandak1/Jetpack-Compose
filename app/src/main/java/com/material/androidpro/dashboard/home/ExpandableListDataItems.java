package com.material.androidpro.dashboard.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class ExpandableListDataItems {

    private ExpandableListDataItems() {
        throw new IllegalArgumentException(ExpandableListDataItems.class.getName());
    }

    public static HashMap<String, List<String>> getData() {

        HashMap<String, List<String>> expandableDetailList = new HashMap<>();

        List<String> fruits = new ArrayList<>();
        fruits.add("Basic");
        fruits.add("Text Label");
        expandableDetailList.put("Buttons", fruits);

        List<String> vegetables = new ArrayList<>();
        vegetables.add("Tomato");
        vegetables.add("Potato");
        vegetables.add("Carrot");
        vegetables.add("Cabbage");
        vegetables.add("Cauliflower");
        expandableDetailList.put("Vegetable Items", vegetables);

        List<String> nuts = new ArrayList<>();
        nuts.add("Cashews");
        nuts.add("Badam");
        nuts.add("Pista");
        nuts.add("Raisin");
        nuts.add("Walnut");
        expandableDetailList.put("Nuts Items", nuts);

        return expandableDetailList;
    }

}
