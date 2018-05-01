package com.rtukpe.fixtures.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.ui.base.BaseActivity;
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment;
import com.rtukpe.fixtures.ui.fixtures.FixturesFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DashboardActivity extends BaseActivity implements DashboardMvpView,
        BottomNavigationView.OnNavigationItemSelectedListener {

    public static final String SELECTED_ITEM = "arg_selected_item";
    private static String fixtures = "Today's Fixtures";
    private static String competitions = "Competitions";

    Fragment fixturesFragment;
    Fragment competitionsFragment;

    @BindView(R.id.navigation)
    BottomNavigationViewEx mBottomNavigationView;
    @BindView(R.id.container)
    FrameLayout frameLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    DashboardMvpContract<DashboardMvpView> mPresenter;
    FragmentManager mFragmentManager = getSupportFragmentManager();
    Fragment mFragment;
    private int mSelectedItem = 0;

    @NonNull
    public static Intent getStartIntent(Context context) {
        return new Intent(context, DashboardActivity.class);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
    }

    @Override
    protected void setUp() {
        mPresenter.onViewInitialized();
        setSupportActionBar(toolbar);

        fixturesFragment = FixturesFragment.newInstance();
        competitionsFragment = CompetitionsFragment.newInstance();

        createFragments();

        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mBottomNavigationView.enableAnimation(true);
        mBottomNavigationView.setTextVisibility(false);
        mBottomNavigationView.setIconSize(32, 32);

        mSelectedItem = getIntent().getIntExtra(SELECTED_ITEM, 0);

        MenuItem homeItem = mBottomNavigationView.getMenu().getItem(mSelectedItem);
        selectFragment(homeItem);
        mBottomNavigationView.setSelectedItemId(mSelectedItem);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return selectFragment(item);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNavigationView.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            selectFragment(homeItem);
            mBottomNavigationView.setSelectedItemId(0);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void showHideToolBar(boolean hide) {
        toolbar.setVisibility(hide ? View.GONE : View.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    //Method to add and hide all of the fragments you need to. In my case I hide 4 fragments, while 1 is visible, that is the first one.
    private void addHideFragment(Fragment fragment, String tag) {
        mFragmentManager.beginTransaction().add(R.id.container, fragment, tag).hide(fragment).commit();
    }

    //Method to hide and show the fragment you need. It is called in the BottomBar click listener.
    private Fragment hideShowFragment(Fragment hide, Fragment show) {
        mFragmentManager.beginTransaction().hide(hide).show(show).commit();
        return show;
    }

    //Add all the fragments that need to be added and hidden. Also, add the one that is supposed to be the starting one, that one is not hidden.
    private void createFragments() {
        mFragmentManager.beginTransaction().remove(competitionsFragment).commit();
        mFragmentManager.beginTransaction().remove(fixturesFragment).commit();
        addHideFragment(competitionsFragment, competitions);

        mFragmentManager.beginTransaction().add(R.id.container, fixturesFragment, fixtures).commit();
        mFragment = fixturesFragment;
    }

    private boolean selectFragment(MenuItem item) {
        if (mSelectedItem == item.getItemId()) {
            return false;
        }

        switch (item.getItemId()) {
            case R.id.navigation_fixtures:
                toolbar.setTitle(fixtures);
                mFragment = hideShowFragment(mFragment, fixturesFragment);
                break;
            case R.id.navigation_competitions:
                toolbar.setTitle(competitions);
                mFragment = hideShowFragment(mFragment, competitionsFragment);
                break;
        }

        mSelectedItem = item.getItemId();
        return true;
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {

    }
}
