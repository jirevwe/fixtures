package com.rtukpe.fixtures.utils.others;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Team;
import com.rtukpe.fixtures.utils.others.GlideApp;
import com.rtukpe.fixtures.utils.others.SvgSoftwareLayerSetter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class PictureDrawablePreloadModelProvider implements ListPreloader.PreloadModelProvider<Team> {

    ArrayList<Team> teams;
    private Context mContext;

    public PictureDrawablePreloadModelProvider(Context mContext, ArrayList<Team> teams) {
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
    public RequestBuilder<PictureDrawable> getPreloadRequestBuilder(@NonNull Team team) {
        RequestBuilder<PictureDrawable> requestBuilder = GlideApp.with(new WeakReference<>(mContext).get())
                .as(PictureDrawable.class)
                .placeholder(R.drawable.champions_league32x32)
                .error(R.drawable.champions_league32x32)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter())
                .override(64, 64);
        return requestBuilder.load(team.logo);
    }
}