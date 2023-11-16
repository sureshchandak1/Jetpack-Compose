package com.material.androidpro.dashboard;

import android.app.Activity;

import androidx.databinding.ObservableField;

public class DashboardViewModel {

    public final ObservableField<DashboardAdapter> mAdapter = new ObservableField<>();

    DashboardViewModel(Activity activity) {
        DashboardAdapter adapter = new DashboardAdapter(DashboardData.list(activity));
        mAdapter.set(adapter);
    }

}
