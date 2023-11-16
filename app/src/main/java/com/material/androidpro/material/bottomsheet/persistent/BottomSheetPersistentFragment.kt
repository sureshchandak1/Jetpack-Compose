package com.material.androidpro.material.bottomsheet.persistent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.databinding.FragmentBottomSheetPersistentBinding
import com.material.androidpro.utils.AppUtil
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.material.androidpro.R


class BottomSheetPersistentFragment : Fragment(), GoogleMap.OnMarkerClickListener,
    OnMapReadyCallback {

    private lateinit var mBinding: FragmentBottomSheetPersistentBinding
    private lateinit var mMap: GoogleMap
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private val INDIA = LatLng(20.5937, 78.9629)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_bottom_sheet_persistent,
            container,
            false
        )

        val mapFragment: SupportMapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val llBottomSheet = mBinding.root.findViewById(R.id.bottom_sheet) as CoordinatorLayout
        bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        mBinding.fabDirections.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            try {
                mMap.animateCamera(zoomingLocation(INDIA))
            } catch (e: Exception) {
            }
        }

        return mBinding.root
    }

    override fun onMapReady(map: GoogleMap) {
        mMap = AppUtil.configMaps(map)

        val marker = MarkerOptions()
        marker.position(INDIA)
        marker.title("India")
        mMap.clear()
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(INDIA,8F))
        mMap.addMarker(marker)

        mMap.setOnMapClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            val markerOptions = MarkerOptions()
            markerOptions.position(it)
            markerOptions.title("" + it.latitude + ", " + it.longitude)
            mMap.clear()
            mMap.animateCamera(zoomingLocation(it))
            mMap.addMarker(markerOptions)
        }

        mMap.setOnMarkerClickListener(this)
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        return false
    }

    private fun zoomingLocation(latLng: LatLng): CameraUpdate {
        return CameraUpdateFactory.newLatLngZoom(latLng, 12f)
    }

}