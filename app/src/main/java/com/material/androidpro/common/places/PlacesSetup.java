package com.material.androidpro.common.places;

import android.content.Context;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.material.androidpro.R;
import com.material.androidpro.adapters.ViewModel;
import com.material.androidpro.common.EmptyItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class PlacesSetup {

    public PlacesSetup(Context context, RecyclerView recyclerView) {
        setAdapter(context, recyclerView);
    }

    private void setAdapter(Context context, RecyclerView recyclerView) {

        List<ViewModel> viewModels = new ArrayList<>();

        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._agra), "Taj Mahal", "Agra, Uttar Pradesh"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._alleppey), "Stay in Houseboat", "Alleppey, Kerala"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._amer_fort_jaipur), "Amer Fort", "Jaipur, Rajasthan"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._amritsar), "Golden Temple", "Amritsar, Punjab"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._andaman), "Radhanagar Beach", "Havelock Island, Andaman Nicobar Islands, Union Territory"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._coorg), "Abbey Falls", "Coorg, Karnataka"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._dalhousie), "Panchpula", "Dalhousie, Himachal Pradesh"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._darjeeling), "Tiger Hill", "Darjeeling, West Bengal"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._delhi), "India Gate", "New Delhi, Delhi, Ncr"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._goa), "Calangute Beach", "North Goa, Goa"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._gokarna), "Om Beach", "Gokarna, Karnataka"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._jaisalmer), "Jaisalmer Fort", "Jaisalmer, Rajasthan"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._kanha_national_park), "Kanha National Park", "Madhya Pradesh, India"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._lake_pichola_udaipur), "Lake Pichola", "Udaipur, Rajasthan"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._lakshadweep), "Minicoy Island", "Lakshadweep Islands, Union Territory"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._leh_ladakh), "Pangong Lake", "Hemis, Ladakh, Union Territory"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._manali), "Old Manali", "Manali, Himachal Pradesh"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._munnar), "Munnar Tea Plantations", "Kerala, India"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._ooty), "Ooty Lake", "Ooty, Tamil Nadu"));
        viewModels.add(new PlacesItemViewModel(context,
                ContextCompat.getDrawable(context, R.drawable._pondicherry), "Pondicherry", "Union Territory, India"));

        viewModels.add(new EmptyItemViewModel());
        viewModels.add(new EmptyItemViewModel());

        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        PlacesAdapter adapter = new PlacesAdapter(viewModels);
        recyclerView.setAdapter(adapter);
    }
}
