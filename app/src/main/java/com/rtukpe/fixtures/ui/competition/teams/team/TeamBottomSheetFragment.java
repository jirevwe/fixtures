package com.rtukpe.fixtures.ui.competition.teams.team;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Player;
import com.rtukpe.fixtures.data.model.Team;
import com.rtukpe.fixtures.di.component.ActivityComponent;
import com.rtukpe.fixtures.ui.base.BaseDialog;
import com.rtukpe.fixtures.utils.others.ImageUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class TeamBottomSheetFragment extends BaseDialog implements TeamMvpView {

    @Inject
    TeamMvpContract<TeamMvpView> mPresenter;

    @BindView(R.id.recylcer_view)
    RecyclerView mRecyclerView;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @Inject
    DividerItemDecoration mDividerItemDecoration;

    @Inject PlayersAdapter mPlayersAdapter;

    @BindView(R.id.team_name)
    TextView teamNameTextView;

    @BindView(R.id.team_logo)
    ImageView teamLogo;

    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {

        }
    };

    public TeamBottomSheetFragment() {

    }

    public static TeamBottomSheetFragment newInstance(Team team) {
        TeamBottomSheetFragment dialog = new TeamBottomSheetFragment();
        Bundle args = new Bundle();
        Timber.d(team.toString());
        args.putString("TEAM", team.toString());
        dialog.setArguments(args);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new BottomSheetDialog(getBaseActivity(), getTheme());
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_team_bottom_sheet, null);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            dialog.setContentView(view);

            component.inject(this);

            setUnBinder(ButterKnife.bind(this, view));

            mPresenter.onAttach(this);

            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) view.getParent()).getLayoutParams();
            CoordinatorLayout.Behavior behavior = params.getBehavior();

            if (behavior != null && behavior instanceof BottomSheetBehavior) {
                ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
            }

            setUp(view);
        }
    }

    @OnClick(R.id.close)
    public void onCloseClicked(View v) {
        dismiss();
    }

    @Override
    protected void setUp(View view) {
        mPresenter.onViewInitialized();

        Bundle bundle = getArguments();
        if (bundle != null) {
            Team team = new Gson().fromJson(bundle.getString("TEAM"), Team.class);
            teamNameTextView.setText(team.name);

            Timber.d(team.toString());

            if (team.logo != null && team.logo.contains("svg")) {
                ImageUtils.loadSVG(getBaseActivity(), team.logo, teamLogo);
            } else {
                ImageUtils.displayImageFromUrl(getBaseActivity(), team.logo, teamLogo);
            }

            mPresenter.getPlayers(team.id);
        }

        mRecyclerView.setAdapter(mPlayersAdapter);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
    }

    @Override
    public void show(String message, boolean useToast) {
        if (getBaseActivity() != null) {
            getBaseActivity().show(message, useToast);
        }
    }

    @Override
    public void updatePlayers(ArrayList<Player> players) {
        mPlayersAdapter.addPlayers(players);
    }
}
