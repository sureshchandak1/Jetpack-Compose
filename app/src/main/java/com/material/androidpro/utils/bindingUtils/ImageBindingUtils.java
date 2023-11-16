package com.material.androidpro.utils.bindingUtils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;

public final class ImageBindingUtils {

    private ImageBindingUtils() {
        throw new IllegalStateException(getClass().getName());
    }

    private static final String IMAGE_BITMAP = "setImageBitmap";
    private static final String IMAGE_URI = "setImageUri";
    private static final String IMAGE_IMAGE_URI = "setImageUri";
    private static final String SET_IMAGE_RESOURCES = "setImageResources";
    private static final String SET_IMAGE_DRAWABLE = "setImageDrawable";

    @BindingAdapter({IMAGE_BITMAP})
    public static void setImageBitmap(@NonNull ImageView imageView,
                                      Bitmap bitmap) {
        if (bitmap != null) {
           imageView.setImageBitmap(bitmap);
        }
    }

    @BindingAdapter({IMAGE_URI})
    public static void setImageUri(@NonNull ImageView imageView,
                                   Uri uri) {
        if (uri != null) {
            imageView.setImageURI(null);
            imageView.setImageURI(uri);
        }
    }

    @BindingAdapter({IMAGE_IMAGE_URI})
    public static void setImageUri(@NonNull ImageView imageView,
                                   String path) {
        if (path != null) {
            imageView.setImageURI(Uri.parse(path));
        }
    }

    @BindingAdapter({SET_IMAGE_RESOURCES})
    public static void setImageResources(@NonNull ImageView imageView,
                                         Integer resources) {
        if (resources != null) {
            imageView.setImageResource(resources);
        }
    }

    @BindingAdapter({SET_IMAGE_DRAWABLE})
    public static void setImageDrawable(@NonNull ImageView imageView,
                                        Drawable drawable) {
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

}
