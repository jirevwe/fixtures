package com.rtukpe.fixtures.ui.fixtures

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.lb.auto_fit_textview.AutoResizeTextView
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Fixture
import com.rtukpe.fixtures.ui.base.BaseViewHolder
import com.rtukpe.fixtures.utils.others.AppUtils
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener
import java.text.SimpleDateFormat
import java.util.*

class FixturesAdapter(private val mContext: Context) : RecyclerView.Adapter<BaseViewHolder>() {

    val fixtures: ArrayList<Fixture> = ArrayList()
    lateinit var mRecyclerViewClickListener: RecyclerViewClickListener
    lateinit var onRetryClickedListener: OnRetryClicked

    val firstFixture: Fixture
        get() = fixtures[0]

    val lastFixture: Fixture
        get() = fixtures[fixtures.size - 1]

    fun setRecyclerViewClickListener(mRecyclerViewClickListener: RecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view: View?
        when (viewType) {
            VIEW_TYPE_NORMAL -> {
                view = LayoutInflater.from(mContext).inflate(R.layout.layout_fixture_item, parent, false)
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

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemViewType(position: Int): Int {
        return if (fixtures.size > 0) {
            VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_EMPTY
        }
    }

    override fun getItemCount(): Int {
        return if (fixtures.size > 0) {
            fixtures.size
        } else {
            1
        }
    }

    fun getFixtureAtPosition(position: Int): Fixture {
        return fixtures[position]
    }

    fun addFixture(fixture: Fixture) {
        fixtures.add(fixture)
        notifyItemInserted(this.fixtures.size - 1)
    }

    fun addFixtures(fixtures: Collection<Fixture>) {
        val index = this.fixtures.size - 1
        this.fixtures.addAll(fixtures)
        notifyItemRangeInserted(index, fixtures.size - 1)
    }

    fun removeFixture(index: Int) {
        this.fixtures.removeAt(index)
        notifyItemRemoved(index)
    }

    fun clear() {
        fixtures.clear()
        notifyItemRangeRemoved(0, this.fixtures.size)
    }

    interface OnRetryClicked {
        fun onRetryClicked()
    }

    protected inner class ViewHolder constructor(itemView: View, var recyclerViewClickListener: RecyclerViewClickListener)
        : BaseViewHolder(itemView), View.OnClickListener {

        @BindView(R.id.fixture_home_team_logo)
        lateinit var homeTeamLogo: ImageView

        @BindView(R.id.fixture_away_team_logo)
        lateinit var awayTeamLogo: ImageView

        @BindView(R.id.fixture_home_team_name)
        lateinit var homeTeamName: AutoResizeTextView

        @BindView(R.id.fixture_away_team_name)
        lateinit var awayTeamName: AutoResizeTextView

        @BindView(R.id.fixture_home_team_score)
        lateinit var homeTeamScore: TextView

        @BindView(R.id.fixture_away_team_score)
        lateinit var awayTeamScore: TextView

        @BindView(R.id.fixture_minutes)
        lateinit var minutes: TextView

        @BindView(R.id.fixture_status)
        lateinit var status: TextView

        @BindView(R.id.fixture_start_time)
        lateinit var startTime: TextView

        @BindView(R.id.fixture_match_day)
        lateinit var matchDay: TextView

        init {

            ButterKnife.bind(this, itemView)
            itemView.setOnClickListener(this)
        }

        override fun onBind(position: Int) {
            super.onBind(position)

            homeTeamName.text = fixtures[adapterPosition].homeTeamName
            awayTeamName.text = fixtures[adapterPosition].awayTeamName

            homeTeamScore.text = if (fixtures[adapterPosition].result.goalsHomeTeam == -1)
                "-"
            else
                fixtures[adapterPosition].result.goalsHomeTeam.toString()
            awayTeamScore.text = if (fixtures[adapterPosition].result.goalsAwayTeam == -1)
                "-"
            else
                fixtures[adapterPosition].result.goalsAwayTeam.toString()

            matchDay.text = String.format("MD: %s", fixtures[adapterPosition].matchday.toString())
            status.text = fixtures[adapterPosition].status
            startTime.text = SimpleDateFormat("HH:mm", Locale.US).format(fixtures[adapterPosition].date)
            minutes.text = String.format("%s'", SimpleDateFormat("mm", Locale.US).format(fixtures[adapterPosition].date))
        }

        override fun onClick(v: View) {
            recyclerViewClickListener.recyclerViewListClicked(v, adapterPosition)
        }
    }

    inner class EmptyViewHolder(itemView: View, var recyclerViewClickListener: RecyclerViewClickListener)
        : BaseViewHolder(itemView) {

        @BindView(R.id.error_no_internet)
        lateinit var errorNoInternet: ImageView

        @BindView(R.id.error_no_items)
        lateinit var errorNoItems: ImageView

        @BindView(R.id.error_text)
        lateinit var errorText: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        override fun onBind(position: Int) {
            super.onBind(position)
            checkConnection()
        }

        fun checkConnection() {
            if (AppUtils.hasInternetConnection(mContext)) {
                errorNoItems.visibility = View.VISIBLE
                errorNoInternet.visibility = View.GONE
                errorText.text = mContext.resources.getString(R.string.empty)
            } else {
                errorNoInternet.visibility = View.VISIBLE
                errorNoItems.visibility = View.GONE
                errorText.text = mContext.resources.getString(R.string.offline)
            }
        }

        @OnClick(R.id.retry)
        fun onRetryClick() {
            checkConnection()
            onRetryClickedListener.onRetryClicked()
        }
    }

    companion object {

        private val VIEW_TYPE_NORMAL = 1
        private val VIEW_TYPE_EMPTY = 0
    }
}
