package com.rtukpe.fixtures.ui.competition.fixtures;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Fixture;
import com.rtukpe.fixtures.di.component.ActivityComponent;
import com.rtukpe.fixtures.ui.base.BaseFragment;
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompetitionFixturesFragment extends BaseFragment implements CompetitionFixturesMvpView {

    @BindView(R.id.recylcer_view)
    RecyclerView recyclerView;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @Inject
    DividerItemDecoration mDividerItemDecoration;

    @Inject
    CompetitionFixturesAdapter competitionFixturesAdapter;

    @Inject
    CompetitionFixturesMvpContract<CompetitionFixturesMvpView> mPresenter;

    public CompetitionFixturesFragment() {

    }

    public static CompetitionFixturesFragment newInstance() {
        CompetitionFixturesFragment fragment = new CompetitionFixturesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixtures, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            setHasOptionsMenu(true);
        }
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    protected void setUp(View view) {
        mPresenter.onViewInitialized();

        int id = getBaseActivity().getIntent().getIntExtra(CompetitionsFragment.COMPETITION_ID, 0);
        mPresenter.getFixtures(id);

        recyclerView.setAdapter(competitionFixturesAdapter);
        recyclerView.addItemDecoration(mDividerItemDecoration);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        competitionFixturesAdapter.setRecyclerViewClickListener(this);
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void updateFixtures(ArrayList<Fixture> fixtures) {
        competitionFixturesAdapter.addFixtures(fixtures);
    }
}
