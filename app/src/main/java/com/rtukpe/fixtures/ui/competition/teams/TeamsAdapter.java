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
import com.rtukpe.fixtures.utils.others.ImageUtils;
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private ArrayList<Team> teams;
    private Context mContext;
    private RecyclerViewClickListener mRecyclerViewClickListener;

    public TeamsAdapter(@NonNull Context context) {
        this.mContext = context;
        this.teams = new ArrayList<>();
    }

    public void setRecyclerViewClickListener(RecyclerViewClickListener mRecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_competition_item, parent, false);
        return new ViewHolder(view, mRecyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.teamName.setText(teams.get(holder.getAdapterPosition()).name);
        if (teams.get(holder.getAdapterPosition()).logo != null && teams.get(holder.getAdapterPosition()).logo.contains("svg")) {
            ImageUtils.loadSVG(mContext, teams.get(holder.getAdapterPosition()).logo, holder.teamLogo);
        } else if (teams.get(holder.getAdapterPosition()).logo != null) {
            ImageUtils.displayImageFromUrl(mContext, teams.get(holder.getAdapterPosition()).logo, holder.teamLogo);
        }
    }

    @Override
    public int getItemCount() {
        return teams.size();
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
        public void onClick(View v) {
            recyclerViewClickListener.recyclerViewListClicked(v, getAdapterPosition());
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.header_name)
        AutoResizeTextView headerName;

        HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
