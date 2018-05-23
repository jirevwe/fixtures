package com.rtukpe.fixtures.ui.competition.table

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import butterknife.BindView
import butterknife.ButterKnife
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.LeagueTable
import com.rtukpe.fixtures.ui.base.BaseFragment
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment
import java.util.*
import javax.inject.Inject

class TableFragment : BaseFragment(), TableMvpView {

    @BindView(R.id.recylcer_view)
    lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var mLinearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var mDividerItemDecoration: DividerItemDecoration

    @Inject
    lateinit var tableAdapter: TableAdapter

    @Inject
    lateinit var mPresenter: TableMvpContract<TableMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
        menu!!.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun setUp(view: View) {
        mPresenter.onViewInitialized()

        val id = baseActivity.intent.getIntExtra(CompetitionsFragment.COMPETITION_ID, 0)
        mPresenter.getCompetitionsTable(id)

        recyclerView.adapter = tableAdapter
        recyclerView.layoutManager = mLinearLayoutManager
        recyclerView.addItemDecoration(mDividerItemDecoration)

        tableAdapter.setRecyclerViewClickListener(this)
    }

    override fun recyclerViewListClicked(v: View, position: Int) {

    }

    override fun updateTableStandings(standings: ArrayList<LeagueTable.Standing>) {
        tableAdapter.addStandings(standings)
    }

    companion object {
        fun newInstance(): TableFragment {
            val fragment = TableFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
