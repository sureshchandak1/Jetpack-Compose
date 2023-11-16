package com.material.androidpro.dashboard.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.material.androidpro.R;

import java.util.HashMap;
import java.util.List;

public class CustomizedExpandableListAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private final List<String> expandableTitleList;
    private final HashMap<String, List<String>> expandableDetailList;

    // constructor
    public CustomizedExpandableListAdapter(Context context, List<String> expandableListTitle,
                                           HashMap<String, List<String>> expandableListDetail) {
        this.context = context;
        this.expandableTitleList = expandableListTitle;
        this.expandableDetailList = expandableListDetail;
    }

    @Override
    // Gets the data associated with the given child within the given group.
    public Object getChild(int lstPosn, int expanded_ListPosition) {
        return this.expandableDetailList.get(this.expandableTitleList.get(lstPosn)).get(expanded_ListPosition);
    }

    @Override
    // Gets the ID for the given child within the given group.
    // This ID must be unique across all children within the group. Hence we can pick the child uniquely
    public long getChildId(int listPosition, int expanded_ListPosition) {
        return expanded_ListPosition;
    }

    @Override
    // Gets a View that displays the data for the given child within the given group.
    public View getChildView(int lstPosn, final int expanded_ListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(lstPosn, expanded_ListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_list_item, null);
        }
        TextView expandedListTextView = convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    // Gets the number of children in a specified group.
    public int getChildrenCount(int listPosition) {
        return this.expandableDetailList.get(this.expandableTitleList.get(listPosition)).size();
    }

    @Override
    // Gets the data associated with the given group.
    public Object getGroup(int listPosition) {
        return this.expandableTitleList.get(listPosition);
    }

    @Override
    // Gets the number of groups.
    public int getGroupCount() {
        return this.expandableTitleList.size();
    }

    @Override
    // Gets the ID for the group at the given position. This group ID must be unique across groups.
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    // Gets a View that displays the given group.
    // This View is only for the group--the Views for the group's children
    // will be fetched using getChildView()
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_list_group, null);
        }
        ImageView arrowDownUpImage = convertView.findViewById(R.id.arrowDownUpImage);
        if (isExpanded) {
            arrowDownUpImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_arrow_drop_up));
        } else {
            arrowDownUpImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_arrow_drop_down));
        }

        TextView listTitleTextView = convertView.findViewById(R.id.listTitle);
        //listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    // Indicates whether the child and group IDs are stable across changes to the underlying data.
    public boolean hasStableIds() {
        return false;
    }

    @Override
    // Whether the child at the specified position is selectable.
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

}
