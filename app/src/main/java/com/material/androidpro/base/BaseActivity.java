package com.material.androidpro.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public abstract class BaseActivity extends AppCompatActivity {

    public abstract Fragment getCurrentFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    /*protected void addFragment(@NonNull final Fragment addFragment) {
        new Thread(() -> {
            String currentFragmentName = "";
            Fragment currentFragment = getCurrentFragment();
            if (currentFragment != null) {
                currentFragmentName = currentFragment.getClass().getName();
            }
            if (addFragment.getClass().getName().equals(currentFragmentName)) {
                return;
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.add(R.id.fragmentContainer, addFragment);
            transaction.commit();
        }).start();
    }

    protected void replaceFragment(@NonNull final Fragment addFragment) {
        new Thread(() -> {
            String currentFragmentName = "";
            Fragment currentFragment = getCurrentFragment();
            if (currentFragment != null) {
                currentFragmentName = currentFragment.getClass().getName();
            }
            if (addFragment.getClass().getName().equals(currentFragmentName)) {
                return;
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.replace(R.id.fragmentContainer, addFragment);
            transaction.commit();
        }).start();
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment fragment = getCurrentFragment();
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
