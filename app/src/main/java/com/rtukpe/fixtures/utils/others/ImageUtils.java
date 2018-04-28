package com.rtukpe.fixtures.utils.others;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.rtukpe.fixtures.R;

import java.lang.ref.WeakReference;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class ImageUtils {

    // Prevent instantiation
    private ImageUtils() {

    }

    /**
     * Crops image into a circle that fits within the ImageView.
     */
    public static void displayRoundImageFromUrl(@NonNull final Context context, @NonNull final String url, @NonNull final ImageView imageView) {
        try {
            RequestOptions myOptions = new RequestOptions()
                    .placeholder(R.drawable.champions_league32x32)
                    .fitCenter()
                    .centerCrop()
                    .dontAnimate();

            Glide.with(new WeakReference<>(context).get())
                    .asBitmap()
                    .apply(myOptions)
                    .load(url)
                    .into(new BitmapImageViewTarget(imageView) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            imageView.setImageDrawable(circularBitmapDrawable);
                        }
                    });
        } catch (NullPointerException e) {

        } catch (IllegalArgumentException e) {

        }
    }

    public static void loadImageForFullScreen(@NonNull final Context context, @NonNull String urlPhoto, @NonNull final ContentLoadingProgressBar progressBar, final ImageView imageView) {
        try {
            final RequestOptions myOptions = new RequestOptions()
                    .placeholder(R.drawable.champions_league32x32)
                    .override(640, 640)
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .dontAnimate();

            Glide.with(new WeakReference<>(context).get())
                    .asBitmap()
                    .apply(myOptions)
                    .load(urlPhoto)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onLoadStarted(Drawable placeholder) {
                            progressBar.show();
                        }

                        @Override
                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                            progressBar.hide();
                            imageView.setImageBitmap(resource);
                        }

                        @Override
                        public void onLoadFailed(@Nullable Drawable errorDrawable) {
                            super.onLoadFailed(errorDrawable);
                            Toast.makeText(context, "Image loading failed", Toast.LENGTH_LONG).show();
                            progressBar.hide();
                        }
                    });
        } catch (NullPointerException e) {

        } catch (IllegalArgumentException e) {

        }
    }

    public static void displayImageFromUrlCustomPlaceHolder(@NonNull final Context context, @NonNull final String url, @NonNull final ImageView imageView, int resource) {
        try {
            RequestOptions myOptions = new RequestOptions()
                    .placeholder(resource)
                    .fitCenter()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .dontAnimate();

            Glide.with(new WeakReference<>(context).get())
                    .asBitmap()
                    .apply(myOptions)
                    .load(url)
                    .into(imageView);
        } catch (NullPointerException e) {

        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Displays an image from a URL in an ImageView.
     */
    public static void displayImageFromUrlWithListener(@NonNull final Context context, @NonNull final String url, @NonNull final ImageView imageView, @NonNull RequestListener listener) {
        try {
            RequestOptions myOptions = new RequestOptions()
                    .placeholder(R.drawable.champions_league32x32)
                    .fitCenter()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .dontAnimate();

            GlideApp.with(new WeakReference<>(context).get())
                    .asBitmap()
                    .apply(myOptions)
                    .load(url)
                    .listener(listener)
                    .into(imageView);
        } catch (NullPointerException e) {

        } catch (IllegalArgumentException e) {

        }
    }

    public static void displayImageFromUrl(final Context context, @NonNull final String url, @NonNull final ImageView imageView) {
        try {
            final RequestOptions myOptions = new RequestOptions()
                    .placeholder(R.drawable.champions_league32x32)
                    .fitCenter()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .dontAnimate();

            GlideApp.with(new WeakReference<>(context).get())
                    .asBitmap()
                    .apply(myOptions)
                    .load(url)
                    .override(64, 64)
                    .into(imageView);
        } catch (NullPointerException e) {

        } catch (IllegalArgumentException e) {

        }
    }

    public static void loadSVG(@NonNull final Context context, @NonNull final String uri, @NonNull final ImageView imageView) {
        RequestBuilder<PictureDrawable> requestBuilder = GlideApp.with(new WeakReference<>(context).get())
                .as(PictureDrawable.class)
                .placeholder(R.drawable.champions_league32x32)
                .error(R.drawable.champions_league32x32)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter())
                .override(64, 64);
        requestBuilder.load(uri).into(imageView);
    }
}
