package com.rtukpe.fixtures.ui.competition.table

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.LeagueTable
import com.rtukpe.fixtures.utils.others.ImageUtils
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener
import java.util.*

class TableAdapter(private val mContext: Context) : RecyclerView.Adapter<TableAdapter.ViewHolder>() {

    val standings: ArrayList<LeagueTable.Standing> = ArrayList()
    lateinit var mRecyclerViewClickListener: RecyclerViewClickListener

    val firstStanding: LeagueTable.Standing
        get() = standings[0]

    val lastStanding: LeagueTable.Standing
        get() = standings[standings.size - 1]

    fun setRecyclerViewClickListener(mRecyclerViewClickListener: RecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_table_standing_item, parent, false)
        return ViewHolder(view, mRecyclerViewClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(standings[holder.adapterPosition]) {
            holder.standingName.text = team
            holder.standingIndex.text = rank.toString()
            holder.standingPoints.text = points.toString()
            holder.standingPlayed.text = playedGames.toString()
            holder.standingGoalDifference.text = goalDifference.toString()

            if (logo != null && logo!!.contains("svg")) {
                logo?.let { ImageUtils.loadSVG(mContext, it, holder.standingLogo) }
            } else {
                logo?.let { ImageUtils.displayImageFromUrl(mContext, it, holder.standingLogo) }
            }
        }
    }

    override fun getItemCount(): Int {
        return standings.size
    }

    fun getStandingAtPosition(position: Int): LeagueTable.Standing {
        return standings[position]
    }

    fun addStanding(fixture: LeagueTable.Standing) {
        standings.add(fixture)
        notifyDataSetChanged()
    }

    fun addStandings(fixtures: Collection<LeagueTable.Standing>) {
        this.standings.addAll(fixtures)
        notifyDataSetChanged()
    }

    fun clear() {
        standings.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder internal constructor(itemView: View, internal var recyclerViewClickListener: RecyclerViewClickListener)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        @BindView(R.id.standing_index)
        lateinit var standingIndex: TextView

        @BindView(R.id.standing_logo)
        lateinit var standingLogo: ImageView

        @BindView(R.id.standing_name)
        lateinit var standingName: TextView

        @BindView(R.id.standing_played)
        lateinit var standingPlayed: TextView

        @BindView(R.id.standing_goal_diff)
        lateinit var standingGoalDifference: TextView

        @BindView(R.id.standing_points)
        lateinit var standingPoints: TextView

        init {
            ButterKnife.bind(this, itemView)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            recyclerViewClickListener.recyclerViewListClicked(v, adapterPosition)
        }
    }
}
