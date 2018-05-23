package com.rtukpe.fixtures.utils.others

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.text.TextUtils
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Team
import java.lang.ref.WeakReference
import java.util.*

class PictureDrawablePreloadModelProvider(private val mContext: Context, internal var teams: ArrayList<Team>) : ListPreloader.PreloadModelProvider<Team> {

    override fun getPreloadItems(position: Int): List<Team> {
        val team = teams[position]
        return if (TextUtils.isEmpty(team.logo)) {
            emptyList()
        } else listOf(team)
    }

    override fun getPreloadRequestBuilder(team: Team): RequestBuilder<PictureDrawable>? {
        val requestBuilder = GlideApp.with(WeakReference(mContext).get()!!)
                .`as`(PictureDrawable::class.java)
                .placeholder(R.drawable.champions_league32x32)
                .error(R.drawable.champions_league32x32)
                .transition(withCrossFade())
                .listener(SvgSoftwareLayerSetter())
                .override(64, 64)
        return requestBuilder.load(team.logo)
    }
}