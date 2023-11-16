package com.material.androidpro.dashboard.home;

import android.app.Activity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeViewModel extends ViewModel {

    HomeViewModel(Activity activity, ExpandableListView expandableListView) {

        HashMap<String, List<String>> expandableDetailList = ExpandableListDataItems.getData();
        List<String> expandableTitleList = new ArrayList<>(expandableDetailList.keySet());
        CustomizedExpandableListAdapter expandableListAdapter = new CustomizedExpandableListAdapter(activity,
                expandableTitleList, expandableDetailList);
        expandableListView.setAdapter(expandableListAdapter);

        // This method is called when the group is expanded
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        // This method is called when the group is collapsed
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Toast.makeText(activity, expandableTitleList.get(groupPosition)
                        + " -> "
                        + expandableDetailList.get(
                        expandableTitleList.get(groupPosition)).get(
                        childPosition), Toast.LENGTH_SHORT
                ).show();

                return false;
            }
        });

    }

}
