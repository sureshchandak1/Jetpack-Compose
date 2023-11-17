package com.material.androidpro.dashboard;

import android.app.Activity;

import com.material.androidpro.MaterialRetention;
import com.material.androidpro.R;
import com.material.androidpro.adapters.ViewModel;
import com.material.androidpro.common.EmptyItemViewModel;
import com.material.androidpro.common.GithubItemViewModel;
import com.material.androidpro.common.HeadingItemViewModel;
import com.material.androidpro.compose.ui.ComposeUIRetention;

import java.util.ArrayList;
import java.util.List;

public final class DashboardData {

    private DashboardData() {
        throw new IllegalArgumentException(DashboardData.class.getName());
    }

    static List<ViewModel> list(Activity activity) {
        final List<ViewModel> list = new ArrayList<>();

        DashboardModel model = null;

        model = new DashboardModel();
        model.setImage(R.drawable.ic_bottom_sheet);
        model.setTitle("Bottom Sheets");
        model.setShortDes("Bottom sheets are surfaces containing supplementary content that are anchored to the bottom of the screen.");
        model.setMaterialType(MaterialRetention.BOTTOM_SHEET);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_bottom_app_bar);
        model.setTitle("Bottom app bar");
        model.setShortDes("A bottom app bar displays navigation and key actions at the bottom of mobile screens.");
        model.setMaterialType(MaterialRetention.BOTTOM_APP_BAR);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_button);
        model.setTitle("Buttons");
        model.setShortDes("Buttons allow users to take actions, and make choices, with a single tap.");
        model.setMaterialType(MaterialRetention.BUTTONS);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_cards);
        model.setTitle("Cards");
        model.setShortDes("Cards contain content and actions that relate information about a subject.");
        model.setMaterialType(MaterialRetention.CARDS);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_checkbox);
        model.setTitle("Checkboxes");
        model.setShortDes("Checkboxes allow users to select one or more items from a set. Checkboxes can turn an option on or off.");
        model.setMaterialType(MaterialRetention.CHECKBOX);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_chips);
        model.setTitle("Chips");
        model.setShortDes("Chips help people enter information, make selections, filter content, or trigger actions. Chips can show multiple interactive elements together in the same area, such as a list of selectable movie times, or a series of email contacts.");
        model.setMaterialType(MaterialRetention.CHIPS);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_dialog);
        model.setTitle("Dialogs");
        model.setShortDes("Dialogs provide important prompts in a user flow. They can require an action, communicate information, or help users accomplish a task.");
        model.setMaterialType(MaterialRetention.DIALOGS);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_menus);
        model.setTitle("Menus");
        model.setShortDes("Menus display a list of choices on a temporary surface. They appear when users interact with a button, action, or other control.");
        model.setMaterialType(MaterialRetention.MENUS);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_bottom_nav);
        model.setTitle("Bottom Navigation");
        model.setShortDes("Navigation bars offer a persistent and convenient way to switch between primary destinations in an app.");
        model.setMaterialType(MaterialRetention.BOTTOM_NAVIGATION);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_progress);
        model.setTitle("Progress");
        model.setShortDes("Progress indicators express an unspecified wait time or display the length of a process.");
        model.setMaterialType(MaterialRetention.PROGRESS);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_slider);
        model.setTitle("Slider");
        model.setShortDes("Sliders allow users to make selections from a range of values.");
        model.setMaterialType(MaterialRetention.SLIDER);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_switch);
        model.setTitle("Switch");
        model.setShortDes("Switches toggle the state of a single item on or off.");
        model.setMaterialType(MaterialRetention.SWITCH);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_tabs);
        model.setTitle("Tabs");
        model.setShortDes("Tabs organize content across different screens, data sets, and other interactions.");
        model.setMaterialType(MaterialRetention.TABS);
        list.add(new DashboardItemViewModel(activity, model));

        model = new DashboardModel();
        model.setImage(R.drawable.ic_toolbar);
        model.setTitle("Top App Bar");
        model.setShortDes("Top app bars display information and actions at the top of a screen.");
        model.setMaterialType(MaterialRetention.TOP_APP_BAR);
        list.add(new DashboardItemViewModel(activity, model));

        list.add(new HeadingItemViewModel("Compose UI"));

        model = new DashboardModel();
        model.setImage(R.drawable.dog_1);
        model.setTitle("Pet List");
        model.setShortDes("");
        model.setComposeUIType(ComposeUIRetention.PET_LIST);
        list.add(new ComposeUIItemViewModel(activity, model));

        list.add(new HeadingItemViewModel("GitHub"));

        list.add(new GithubItemViewModel("Jetpack-Compose", "https://github.com/suresh000/Jetpack-Compose"));
        list.add(new GithubItemViewModel("Android-MVVM", "https://github.com/suresh000/Android-MVVM"));

        list.add(new EmptyItemViewModel());

        return list;
    }

}
