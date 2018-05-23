package com.rtukpe.fixtures.ui.competitions

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.lb.auto_fit_textview.AutoResizeTextView
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Competition
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener
import java.util.*

class CompetitionsAdapter(val mContext: Context) : RecyclerView.Adapter<CompetitionsAdapter.ViewHolder>() {

    val mCompetitions: ArrayList<Competition> = ArrayList()
    lateinit var mRecyclerViewClickListener: RecyclerViewClickListener

    val firstCompetition: Competition
        get() = mCompetitions[0]

    val lastCompetition: Competition
        get() = mCompetitions[mCompetitions.size - 1]

    fun setRecyclerViewClickListener(mRecyclerViewClickListener: RecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_competition_item, parent, false)
        return ViewHolder(view, mRecyclerViewClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.competitionName.text = mCompetitions[position].caption
        holder.competitionLogo.setImageDrawable(mContext.resources.getDrawable(R.drawable.champions_league32x32))
    }

    override fun getItemCount(): Int {
        return mCompetitions.size
    }

    fun getCompetitionAtPosition(position: Int): Competition {
        return mCompetitions[position]
    }

    fun addCompetition(set: Competition) {
        mCompetitions.add(set)
        notifyDataSetChanged()
    }

    fun addCompetitions(competitions: Collection<Competition>) {
        mCompetitions.addAll(competitions)
        notifyDataSetChanged()
    }

    fun clear() {
        mCompetitions.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder constructor(itemView: View, var recyclerViewClickListener: RecyclerViewClickListener)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        @BindView(R.id.competition_logo)
        lateinit var competitionLogo: ImageView

        @BindView(R.id.competition_name)
        lateinit var competitionName: AutoResizeTextView

        init {
            ButterKnife.bind(this, itemView)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            recyclerViewClickListener.recyclerViewListClicked(v, adapterPosition)
        }
    }
}
