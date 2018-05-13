package com.rtukpe.fixtures.ui.competition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import butterknife.BindView
import butterknife.ButterKnife
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.ui.base.BaseActivity
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesFragment
import com.rtukpe.fixtures.ui.competition.table.TableFragment
import com.rtukpe.fixtures.ui.competition.teams.TeamsFragment
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment.COMPETITION_NAME
import com.rtukpe.fixtures.utils.others.widgets.CustomViewPager
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject

class CompetitionActivity : BaseActivity(), CompetitionMvpView, TabLayout.OnTabSelectedListener {

    @Inject
    lateinit var mPresenter: CompetitionMvpContract<CompetitionMvpView>
    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar
    @BindView(R.id.view_pager)
    lateinit var mViewPager: CustomViewPager
    @BindView(R.id.tab_layout)
    lateinit var mTabLayout: TabLayout
    @Inject
    lateinit var mPagerAdapter: CompetitionPagerAdapter

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_competition)

        activityComponent.inject(this)

        setUnBinder(ButterKnife.bind(this))

        mPresenter.onAttach(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }

    override fun showHideToolBar(hide: Boolean) {
        toolbar.visibility = if (hide) View.GONE else View.VISIBLE
    }

    override fun setUp() {
        mPresenter.onViewInitialized()

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra(COMPETITION_NAME)
        toolbar.title = name

        val id = intent.getIntExtra(CompetitionsFragment.COMPETITION_ID, 0)

        if (id != 464 && id != 458) {
            mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.table)))
        }
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.fixtures)))
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.teams)))

        if (id != 464 && id != 458) {
            mPagerAdapter.addFragment(TableFragment.newInstance(), getString(R.string.table))
        }
        mPagerAdapter.addFragment(CompetitionFixturesFragment.newInstance(), getString(R.string.fixtures))
        mPagerAdapter.addFragment(TeamsFragment.newInstance(), getString(R.string.teams))

        mViewPager.adapter = mPagerAdapter
        mViewPager.isPagingEnabled = false
        mViewPager.offscreenPageLimit = mPagerAdapter.count
        mViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mTabLayout))
        mTabLayout.addOnTabSelectedListener(this)
    }

    override fun recyclerViewListClicked(v: View, position: Int) {

    }

    override fun onTabSelected(tab: TabLayout.Tab) {
        mViewPager.currentItem = tab.position
    }

    override fun onTabUnselected(tab: TabLayout.Tab) {

    }

    override fun onTabReselected(tab: TabLayout.Tab) {

    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, CompetitionActivity::class.java)
        }
    }
}
