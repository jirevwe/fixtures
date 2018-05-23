package com.rtukpe.fixtures.ui.competitions


import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import butterknife.BindView
import butterknife.ButterKnife
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Competition
import com.rtukpe.fixtures.ui.base.BaseFragment
import com.rtukpe.fixtures.ui.competition.CompetitionActivity
import com.rtukpe.fixtures.utils.others.AppUtils
import java.util.*
import javax.inject.Inject

class CompetitionsFragment : BaseFragment(), CompetitionsMvpView {

    @BindView(R.id.recylcer_view)
    lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var mLinearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var competitionsAdapter: CompetitionsAdapter

    @Inject
    lateinit var mDividerItemDecoration: DividerItemDecoration

    @Inject
    lateinit var mPresenter: CompetitionsMvpContract<CompetitionsMvpView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_competitions, container, false)
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

        mPresenter.getCompetitions()

        recyclerView.adapter = competitionsAdapter
        recyclerView.layoutManager = mLinearLayoutManager
        recyclerView.addItemDecoration(mDividerItemDecoration)
        competitionsAdapter.setRecyclerViewClickListener(this)
    }

    override fun recyclerViewListClicked(v: View, position: Int) {
        if (AppUtils.hasInternetConnection(baseActivity)) {
            val intent = CompetitionActivity.getStartIntent(baseActivity)
            intent.putExtra(COMPETITION_ID, competitionsAdapter.getCompetitionAtPosition(position).id)
            intent.putExtra(COMPETITION_NAME, competitionsAdapter.getCompetitionAtPosition(position).caption)
            startActivity(intent)
        } else {
            show("Please connect to the internet", false)
        }
    }

    override fun updateCompetitions(competitions: ArrayList<Competition>) {
        competitionsAdapter.addCompetitions(competitions)
    }

    companion object {

        val COMPETITION_ID = "CompetitionsFragment.COMPETITION_ID"
        val COMPETITION_NAME = "CompetitionsFragment.COMPETITION_NAME"

        fun newInstance(): CompetitionsFragment {
            val fragment = CompetitionsFragment()
            val args = Bundle()

            fragment.arguments = args
            return fragment
        }
    }
}
