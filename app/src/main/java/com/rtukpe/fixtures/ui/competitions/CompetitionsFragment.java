package com.rtukpe.fixtures.ui.competitions;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.di.component.ActivityComponent;
import com.rtukpe.fixtures.ui.base.BaseFragment;
import com.rtukpe.fixtures.ui.competition.CompetitionActivity;
import com.rtukpe.fixtures.utils.others.AppUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompetitionsFragment extends BaseFragment implements CompetitionsMvpView {

    public static final String COMPETITION_ID = "CompetitionsFragment.COMPETITION_ID";
    public static final String COMPETITION_NAME = "CompetitionsFragment.COMPETITION_NAME";

    @BindView(R.id.recylcer_view)
    RecyclerView recyclerView;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @Inject
    CompetitionsAdapter competitionsAdapter;

    @Inject
    CompetitionsMvpContract<CompetitionsMvpView> mPresenter;

    public CompetitionsFragment() {

    }

    public static CompetitionsFragment newInstance() {
        CompetitionsFragment fragment = new CompetitionsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_competitions, container, false);
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

        mPresenter.getCompetitions();

        recyclerView.setAdapter(competitionsAdapter);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        competitionsAdapter.setRecyclerViewClickListener(this);
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        if (AppUtils.hasInternetConnection(getBaseActivity())) {
            Intent intent = CompetitionActivity.getStartIntent(getBaseActivity());
            intent.putExtra(COMPETITION_ID, competitionsAdapter.getCompetitionAtPosition(position).id);
            intent.putExtra(COMPETITION_NAME, competitionsAdapter.getCompetitionAtPosition(position).caption);
            startActivity(intent);
        } else {
            show("Please connect to the internet", false);
        }
    }

    @Override
    public void updateCompetitions(ArrayList<Competition> competitions) {
        competitionsAdapter.addCompetitions(competitions);
    }
}
