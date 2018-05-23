package com.rtukpe.fixtures.ui.competition.teams

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.lb.auto_fit_textview.AutoResizeTextView
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Team
import com.rtukpe.fixtures.ui.base.BaseViewHolder
import com.rtukpe.fixtures.utils.others.ImageUtils
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener
import java.util.*

class TeamsAdapter(private val mContext: Context) : RecyclerView.Adapter<BaseViewHolder>() {

    var teams: ArrayList<Team> = ArrayList()
    lateinit var mRecyclerViewClickListener: RecyclerViewClickListener
    lateinit var onRetryClickedListener: OnRetryClicked

    val firstTeam: Team
        get() = teams[0]

    val lastTeam: Team
        get() = teams[teams.size - 1]

    fun setRecyclerViewClickListener(mRecyclerViewClickListener: RecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view: View
        when (viewType) {
            VIEW_TYPE_NORMAL -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.layout_team_item, parent, false)
                return ViewHolder(view, mRecyclerViewClickListener)
            }
            VIEW_TYPE_EMPTY -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.layout_empty_view, parent, false)
                return EmptyViewHolder(view, mRecyclerViewClickListener)
            }
            else -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.layout_empty_view, parent, false)
                return EmptyViewHolder(view, mRecyclerViewClickListener)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (teams.size > 0) {
            VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_EMPTY
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return if (teams.size > 0) {
            teams.size
        } else {
            1
        }
    }

    fun getTeamAtPosition(position: Int): Team {
        return teams[position]
    }

    fun addTeam(team: Team) {
        teams.add(team)
        notifyDataSetChanged()
    }

    fun addTeams(teams: Collection<Team>) {
        this.teams.addAll(teams)
        notifyDataSetChanged()
    }

    fun clear() {
        teams.clear()
        notifyDataSetChanged()
    }

    interface OnRetryClicked {
        fun onRetryClicked()
    }

    inner class ViewHolder(itemView: View, var recyclerViewClickListener: RecyclerViewClickListener)
        : BaseViewHolder(itemView), View.OnClickListener {

        @BindView(R.id.competition_logo)
        lateinit var teamLogo: ImageView

        @BindView(R.id.competition_name)
        lateinit var teamName: AutoResizeTextView

        init {
            ButterKnife.bind(this, itemView)
            itemView.setOnClickListener(this)
        }

        override fun onBind(position: Int) {
            super.onBind(position)

            with(teams[adapterPosition]) {
                teamName.text = name
                if (logo != null && logo!!.contains("svg")) {
                    logo?.let { ImageUtils.loadSVG(mContext, it, teamLogo) }
                } else {
                    logo?.let { ImageUtils.displayImageFromUrl(mContext, it, teamLogo) }
                }
            }
        }

        override fun onClick(v: View) {
            recyclerViewClickListener.recyclerViewListClicked(v, adapterPosition)
        }
    }

    inner class EmptyViewHolder(itemView: View, var recyclerViewClickListener: RecyclerViewClickListener) : BaseViewHolder(itemView) {

        init {
            ButterKnife.bind(this, itemView)
        }

        @OnClick(R.id.retry)
        fun onRetryClick() {
            onRetryClickedListener.onRetryClicked()
        }
    }

    companion object {
        private val VIEW_TYPE_NORMAL = 1
        private val VIEW_TYPE_EMPTY = 0
    }
}
