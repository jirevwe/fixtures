package com.rtukpe.fixtures.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import butterknife.BindView
import butterknife.ButterKnife
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.ui.base.BaseActivity
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment
import com.rtukpe.fixtures.ui.fixtures.FixturesFragment
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardMvpView, BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var fixturesFragment: Fragment
    lateinit var competitionsFragment: Fragment

    @BindView(R.id.navigation)
    lateinit var mBottomNavigationView: BottomNavigationViewEx
    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar
    @Inject
    lateinit var mPresenter: DashboardMvpContract<DashboardMvpView>
    var mFragmentManager = supportFragmentManager
    lateinit var mFragment: Fragment
    var mSelectedItem = 0

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)

        activityComponent!!.inject(this)

        setUnBinder(ButterKnife.bind(this))

        mPresenter.onAttach(this)
    }

    override fun setUp() {
        mPresenter.onViewInitialized()
        setSupportActionBar(toolbar)

        fixturesFragment = FixturesFragment.newInstance()
        competitionsFragment = CompetitionsFragment.newInstance()

        createFragments()

        mBottomNavigationView.onNavigationItemSelectedListener = this
        mBottomNavigationView.enableAnimation(true)
        mBottomNavigationView.setTextVisibility(false)
        mBottomNavigationView.setIconSize(32f, 32f)

        mSelectedItem = intent.getIntExtra(SELECTED_ITEM, 0)

        val homeItem = mBottomNavigationView.menu.getItem(mSelectedItem)
        selectFragment(homeItem)
        mBottomNavigationView.selectedItemId = mSelectedItem
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return selectFragment(item)
    }

    override fun onBackPressed() {
        val homeItem = mBottomNavigationView.menu.getItem(0)
        if (mSelectedItem != homeItem.itemId) {
            selectFragment(homeItem)
            mBottomNavigationView.selectedItemId = 0
        } else {
            super.onBackPressed()
        }
    }

    override fun showHideToolBar(hide: Boolean) {
        toolbar.visibility = if (hide) View.GONE else View.VISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SELECTED_ITEM, mSelectedItem)
        super.onSaveInstanceState(outState)
    }

    //Method to add and hide all of the fragments you need to. In my case I hide 4 fragments, while 1 is visible, that is the first one.
    private fun addHideFragment(fragment: Fragment, tag: String) {
        mFragmentManager.beginTransaction().add(R.id.container, fragment, tag).hide(fragment).commit()
    }

    //Method to hide and show the fragment you need. It is called in the BottomBar click listener.
    private fun hideShowFragment(hide: Fragment, show: Fragment): Fragment {
        mFragmentManager.beginTransaction().hide(hide).show(show).commit()
        return show
    }

    //Add all the fragments that need to be added and hidden. Also, add the one that is supposed to be the starting one, that one is not hidden.
    private fun createFragments() {
        mFragmentManager.beginTransaction().remove(competitionsFragment).commit()
        mFragmentManager.beginTransaction().remove(fixturesFragment).commit()
        addHideFragment(competitionsFragment, competitions)

        mFragmentManager.beginTransaction().add(R.id.container, fixturesFragment, fixtures).commit()
        mFragment = fixturesFragment
    }

    private fun selectFragment(item: MenuItem): Boolean {
        if (mSelectedItem == item.itemId) {
            return false
        }

        when (item.itemId) {
            R.id.navigation_fixtures -> {
                toolbar.title = fixtures
                mFragment = hideShowFragment(mFragment, fixturesFragment)
            }
            R.id.navigation_competitions -> {
                toolbar.title = competitions
                mFragment = hideShowFragment(mFragment, competitionsFragment)
            }
        }

        mSelectedItem = item.itemId
        return true
    }

    override fun recyclerViewListClicked(v: View, position: Int) {

    }

    companion object {

        val SELECTED_ITEM = "arg_selected_item"
        private val fixtures = "Today's Fixtures"
        private val competitions = "Competitions"

        fun getStartIntent(context: Context): Intent {
            return Intent(context, DashboardActivity::class.java)
        }
    }
}
