package com.material.androidpro.utils

import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.DisplayMetrics
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.snackbar.Snackbar
import com.material.androidpro.apiclient.RetrofitClient
import com.material.androidpro.model.ErrorResponse
import com.material.sharedcode.utils.AppUtils
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

class AppUtil private constructor() {

    init {
        throw IllegalArgumentException(AppUtil::class.java.name)
    }

    companion object {

        @JvmStatic
        fun showToastOnUiThread(activity: Activity, message: String?, length: Int) {
            activity.runOnUiThread { AppUtils.showToast(activity, message, length) }
        }

        @JvmStatic
        fun setWhiteNavigationBar(context: Context?, dialog: Dialog) {
            val window = dialog.window
            if (window != null) {
                val metrics = DisplayMetrics()
                window.windowManager.defaultDisplay.getMetrics(metrics)
                val dimDrawable = GradientDrawable()
                // ...customize your dim effect here
                val navigationBarDrawable = GradientDrawable()
                navigationBarDrawable.shape = GradientDrawable.RECTANGLE
                //navigationBarDrawable.setColor(ContextCompat.getColor(context, R.color.navigationBarColor));
                val layers = arrayOf<Drawable>(dimDrawable, navigationBarDrawable)
                val windowBackground = LayerDrawable(layers)
                windowBackground.setLayerInsetTop(1, metrics.heightPixels)
                window.setBackgroundDrawable(windowBackground)
            }
        }

        @JvmStatic
        fun dismissProgressDialog(
            activity: Activity,
            progressDialog: ProgressDialog
        ) {
            activity.runOnUiThread { progressDialog.dismiss() }
        }

        @JvmStatic
        fun showSnackBar(
            activity: Activity,
            coordinatorLayout: CoordinatorLayout?,
            message: String?, length: Int
        ) {
            activity.runOnUiThread { Snackbar.make(coordinatorLayout!!, message!!, length).show() }
        }

        @JvmStatic
        fun configMaps(googleMap: GoogleMap): GoogleMap {
            // set map type
            googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            // Enable / Disable zooming controls
            googleMap.uiSettings.isZoomControlsEnabled = false

            // Enable / Disable Compass icon
            googleMap.uiSettings.isCompassEnabled = true
            // Enable / Disable Rotate gesture
            googleMap.uiSettings.isRotateGesturesEnabled = true
            // Enable / Disable zooming functionality
            googleMap.uiSettings.isZoomGesturesEnabled = true
            googleMap.uiSettings.isScrollGesturesEnabled = true
            googleMap.uiSettings.isMapToolbarEnabled = true
            //googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            return googleMap
        }

        @JvmStatic
        fun parseError(response: Response<*>?): ErrorResponse {
            val converter: Converter<ResponseBody?, ErrorResponse> =
                RetrofitClient.getRetrofit()
                    .responseBodyConverter(ErrorResponse::class.java, arrayOfNulls<Annotation>(0))
            var error = ErrorResponse()
            if (response?.errorBody() != null) {
                error = try {
                    converter.convert(response.errorBody()!!)!!
                } catch (e: IOException) {
                    return ErrorResponse()
                }
            }
            return error
        }

    }
}
