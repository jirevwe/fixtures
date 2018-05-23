package com.rtukpe.fixtures.ui.competition.teams


import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import butterknife.BindView
import butterknife.ButterKnife
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Team
import com.rtukpe.fixtures.ui.base.BaseFragment
import com.rtukpe.fixtures.ui.competition.teams.team.TeamBottomSheetFragment
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment
import com.rtukpe.fixtures.utils.others.ItemOffsetDecoration
import java.util.*
import javax.inject.Inject

class TeamsFragment : BaseFragment(), TeamsMvpView, TeamsAdapter.OnRetryClicked {

    @BindView(R.id.recylcer_view)
    lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var mLinearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var teamsAdapter: TeamsAdapter

    @Inject
    lateinit var gridLayoutManager: GridLayoutManager

    @Inject
    lateinit var mPresenter: TeamsMvpContract<TeamsMvpView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_teams, container, false)
        val component = activityComponent
        if (component != null) {
            component.inject(this)
            setUnBinder(ButterKnife.bind(this, view))
            mPresenter.onAttach(this)
            setHasOptionsMenu(true)
        }
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        menu?.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun setUp(view: View) {
        mPresenter.onViewInitialized()

        val id = baseActivity.intent.getIntExtra(CompetitionsFragment.COMPETITION_ID, 0)
        mPresenter.getTeams(id)

        recyclerView.adapter = teamsAdapter
        recyclerView.layoutManager = gridLayoutManager
        val itemDecoration = ItemOffsetDecoration(baseActivity, R.dimen.item_offset)
        recyclerView.addItemDecoration(itemDecoration)
        teamsAdapter.setRecyclerViewClickListener(this)
        teamsAdapter.onRetryClickedListener = this
    }

    override fun recyclerViewListClicked(v: View, position: Int) {
        val dialog = TeamBottomSheetFragment.newInstance(teamsAdapter.getTeamAtPosition(position))
        dialog.show(baseActivity.supportFragmentManager, "TEAM")
    }

    override fun updateTeams(fixtures: ArrayList<Team>) {
        teamsAdapter.addTeams(fixtures)
    }

    override fun onRetryClicked() {
        val id = baseActivity.intent.getIntExtra(CompetitionsFragment.COMPETITION_ID, 0)
        mPresenter.getTeams(id)
    }

    companion object {

        fun newInstance(): TeamsFragment {
            val fragment = TeamsFragment()
            val args = Bundle()

            fragment.arguments = args
            return fragment
        }
    }
}
