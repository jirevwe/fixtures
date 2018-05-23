package com.rtukpe.fixtures.ui.competition.fixtures

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import butterknife.BindView
import butterknife.ButterKnife
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Fixture
import com.rtukpe.fixtures.ui.base.BaseFragment
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment
import javax.inject.Inject

class CompetitionFixturesFragment : BaseFragment(), CompetitionFixturesMvpView, CompetitionFixturesAdapter.OnRetryClicked {

    override fun onRetryClicked() {
        mPresenter.getFixtures(id)
    }

    @BindView(R.id.recylcer_view)
    lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var mLinearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var mDividerItemDecoration: DividerItemDecoration

    @Inject
    lateinit var competitionFixturesAdapter: CompetitionFixturesAdapter

    @Inject
    lateinit var mPresenter: CompetitionFixturesMvpContract<CompetitionFixturesMvpView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fixtures, container, false)
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
        mPresenter.getFixtures(id)

        competitionFixturesAdapter.onRetryClickedListener = this
        competitionFixturesAdapter.mRecyclerViewClickListener = this

        recyclerView.adapter = competitionFixturesAdapter
        recyclerView.addItemDecoration(mDividerItemDecoration)
        recyclerView.layoutManager = mLinearLayoutManager

    }

    override fun recyclerViewListClicked(v: View, position: Int) {

    }

    override fun updateFixtures(fixtures: ArrayList<Fixture>) {
        competitionFixturesAdapter.addFixtures(fixtures)
    }

    companion object {

        fun newInstance(): CompetitionFixturesFragment {
            val fragment = CompetitionFixturesFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
