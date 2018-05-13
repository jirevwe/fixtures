package com.rtukpe.fixtures.utils.others;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Team;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BitmapPreloadModelProvider implements ListPreloader.PreloadModelProvider<Team> {

    private ArrayList<Team> teams;
    private Context mContext;

    public BitmapPreloadModelProvider(Context mContext, ArrayList<Team> teams) {
        this.mContext = mContext;
        this.teams = teams;
    }

    @Override
    @NonNull
    public List<Team> getPreloadItems(int position) {
        Team team = teams.get(position);
        if (TextUtils.isEmpty(team.logo)) {
            return Collections.emptyList();
        }
        return Collections.singletonList(team);
    }

    @Nullable
    @Override
    public RequestBuilder<Bitmap> getPreloadRequestBuilder(@NonNull Team url) {
        final RequestOptions myOptions = new RequestOptions()
                .placeholder(R.drawable.champions_league32x32)
                .fitCenter()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .dontAnimate();

        return GlideApp.with(new WeakReference<>(mContext).get())
                .asBitmap()
                .apply(myOptions)
                .load(url.logo)
                .override(64, 64);
    }
}