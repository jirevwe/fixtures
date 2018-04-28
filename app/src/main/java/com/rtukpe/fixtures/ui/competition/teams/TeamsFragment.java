package com.rtukpe.fixtures.ui.competition.teams;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Team;
import com.rtukpe.fixtures.di.component.ActivityComponent;
import com.rtukpe.fixtures.ui.base.BaseFragment;
import com.rtukpe.fixtures.ui.competitions.CompetitionsFragment;
import com.rtukpe.fixtures.utils.others.ItemOffsetDecoration;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsFragment extends BaseFragment implements TeamsMvpView {

    @BindView(R.id.recylcer_view)
    RecyclerView recyclerView;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @Inject
    TeamsAdapter teamsAdapter;

    @Inject
    GridLayoutManager gridLayoutManager;

    @Inject
    TeamsMvpContract<TeamsMvpView> mPresenter;

    public TeamsFragment() {

    }

    public static TeamsFragment newInstance() {
        TeamsFragment fragment = new TeamsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
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
        mPresenter.getTeams(id);

//        ListPreloader.PreloadSizeProvider<Team> sizeProvider = new FixedPreloadSizeProvider<>(64, 64);
//        BitmapPreloadModelProvider bitmapPreloadModelProvider = new BitmapPreloadModelProvider(getContext(), teamsAdapter.getTeams());
//        PictureDrawablePreloadModelProvider pictureDrawablePreloadModelProvider = new PictureDrawablePreloadModelProvider(getBaseActivity(), teamsAdapter.getTeams());
//        RecyclerViewPreloader<Team> preloader = new RecyclerViewPreloader<>(Glide.with(getBaseActivity()), pictureDrawablePreloadModelProvider, sizeProvider, 20 /*maxPreload*/);
//        recyclerView.addOnScrollListener(preloader);
        recyclerView.setAdapter(teamsAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getBaseActivity(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        teamsAdapter.setRecyclerViewClickListener(this);
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {

    }

    @Override
    public void updateTeams(ArrayList<Team> teams) {
        teamsAdapter.addTeams(teams);
    }
}
