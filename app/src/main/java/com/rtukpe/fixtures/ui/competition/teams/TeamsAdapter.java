package com.rtukpe.fixtures.ui.competition.teams;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lb.auto_fit_textview.AutoResizeTextView;
import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Team;
import com.rtukpe.fixtures.ui.base.BaseViewHolder;
import com.rtukpe.fixtures.utils.others.ImageUtils;
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeamsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int VIEW_TYPE_NORMAL = 1;
    private static final int VIEW_TYPE_EMPTY = 0;

    private ArrayList<Team> teams;
    private Context mContext;
    private RecyclerViewClickListener mRecyclerViewClickListener;
    private OnRetryClicked onRetryClickedListener;

    public TeamsAdapter(@NonNull Context context) {
        this.mContext = context;
        this.teams = new ArrayList<>();
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setRecyclerViewClickListener(RecyclerViewClickListener mRecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                view = LayoutInflater.from(mContext).inflate(R.layout.layout_team_item, parent, false);
                return new ViewHolder(view, mRecyclerViewClickListener);
            case VIEW_TYPE_EMPTY:
            default:
                view = LayoutInflater.from(mContext).inflate(R.layout.layout_empty_view, parent, false);
                return new EmptyViewHolder(view, mRecyclerViewClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (teams != null && teams.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (teams != null && teams.size() > 0) {
            return teams.size();
        } else {
            return 1;
        }
    }

    public Team getTeamAtPosition(int position) {
        return teams.get(position);
    }

    public Team getFirstTeam() {
        return teams.get(0);
    }

    public Team getLastTeam() {
        return teams.get(teams.size() - 1);
    }

    public void addTeam(Team team) {
        teams.add(team);
        notifyDataSetChanged();
    }

    public void addTeams(Collection<Team> teams) {
        this.teams.addAll(teams);
        notifyDataSetChanged();
    }

    public void clear() {
        teams.clear();
        notifyDataSetChanged();
    }

    public void setOnRetryClickedListener(OnRetryClicked onRetryClickedListener) {
        this.onRetryClickedListener = onRetryClickedListener;
    }

    interface OnRetryClicked {
        void onRetryClicked();
    }

    class ViewHolder extends BaseViewHolder implements View.OnClickListener {

        @BindView(R.id.competition_logo)
        ImageView teamLogo;

        @BindView(R.id.competition_name)
        AutoResizeTextView teamName;

        RecyclerViewClickListener recyclerViewClickListener;

        ViewHolder(View itemView, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            this.recyclerViewClickListener = recyclerViewClickListener;
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            teamName.setText(teams.get(getAdapterPosition()).name);
            if (teams.get(getAdapterPosition()).logo != null && teams.get(getAdapterPosition()).logo.contains("svg")) {
                ImageUtils.loadSVG(mContext, teams.get(getAdapterPosition()).logo, teamLogo);
            } else {
                ImageUtils.displayImageFromUrl(mContext, teams.get(getAdapterPosition()).logo, teamLogo);
            }
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickListener.recyclerViewListClicked(v, getAdapterPosition());
        }
    }

    class EmptyViewHolder extends BaseViewHolder {

        RecyclerViewClickListener recyclerViewClickListener;

        EmptyViewHolder(View itemView, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.recyclerViewClickListener = recyclerViewClickListener;
        }

        @OnClick(R.id.retry)
        void onRetryClick() {
            if (onRetryClickedListener != null) onRetryClickedListener.onRetryClicked();
        }
    }
}
