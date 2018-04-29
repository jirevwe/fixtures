package com.rtukpe.fixtures.ui.competition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.ui.base.BaseActivity;
import com.rtukpe.fixtures.ui.competition.fixtures.CompetitionFixturesFragment;
import com.rtukpe.fixtures.ui.competition.table.TableFragment;
import com.rtukpe.fixtures.ui.competition.teams.TeamsFragment;
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment;
import com.rtukpe.fixtures.utils.others.widgets.CustomViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.rtukpe.fixtures.ui.competitions.CompetitionsFragment.COMPETITION_NAME;

public class CompetitionActivity extends BaseActivity implements CompetitionMvpView, TabLayout.OnTabSelectedListener {

    @Inject
    CompetitionMvpContract<CompetitionMvpView> mPresenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    CustomViewPager mViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @Inject
    CompetitionPagerAdapter mPagerAdapter;

    @NonNull
    public static Intent getStartIntent(Context context) {
        return new Intent(context, CompetitionActivity.class);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_competition);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void showHideToolBar(boolean hide) {
        toolbar.setVisibility(hide ? View.GONE : View.VISIBLE);
    }

    @Override
    protected void setUp() {
        mPresenter.onViewInitialized();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String name = getIntent().getStringExtra(COMPETITION_NAME);
        toolbar.setTitle(name);

        int id = getIntent().getIntExtra(CompetitionsFragment.COMPETITION_ID, 0);

        if (id != 464 && id != 458) {
            mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.table)));
        }
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.fixtures)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.teams)));

        if (id != 464 && id != 458) {
            mPagerAdapter.addFragment(TableFragment.newInstance(), getString(R.string.table));
        }
        mPagerAdapter.addFragment(CompetitionFixturesFragment.newInstance(), getString(R.string.fixtures));
        mPagerAdapter.addFragment(TeamsFragment.newInstance(), getString(R.string.teams));

        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setPagingEnabled(false);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
