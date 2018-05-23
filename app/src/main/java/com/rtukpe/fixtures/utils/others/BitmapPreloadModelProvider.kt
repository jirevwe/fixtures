package com.rtukpe.fixtures.utils.others

import android.content.Context
import android.graphics.Bitmap
import android.text.TextUtils
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Team
import java.lang.ref.WeakReference
import java.util.*

class BitmapPreloadModelProvider(private val mContext: Context, private val teams: ArrayList<Team>) : ListPreloader.PreloadModelProvider<Team> {

    override fun getPreloadItems(position: Int): List<Team> {
        val team = teams[position]
        return if (TextUtils.isEmpty(team.logo)) {
            emptyList()
        } else listOf(team)
    }

    override fun getPreloadRequestBuilder(url: Team): RequestBuilder<Bitmap>? {
        val myOptions = RequestOptions()
                .placeholder(R.drawable.champions_league32x32)
                .fitCenter()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .dontAnimate()

        return GlideApp.with(WeakReference(mContext).get()!!)
                .asBitmap()
                .apply(myOptions)
                .load(url.logo)
                .override(64, 64)
    }
}