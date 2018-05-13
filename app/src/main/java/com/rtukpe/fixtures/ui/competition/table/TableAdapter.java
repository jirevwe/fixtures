package com.rtukpe.fixtures.ui.competition.table;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.LeagueTable;
import com.rtukpe.fixtures.utils.others.ImageUtils;
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    private ArrayList<LeagueTable.Standing> standings;
    private Context mContext;
    private RecyclerViewClickListener mRecyclerViewClickListener;

    public TableAdapter(@NonNull Context context) {
        this.mContext = context;
        this.standings = new ArrayList<>();
    }

    public ArrayList<LeagueTable.Standing> getStandings() {
        return standings;
    }

    public void setRecyclerViewClickListener(RecyclerViewClickListener mRecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_table_standing_item, parent, false);
        return new ViewHolder(view, mRecyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.standingName.setText(standings.get(holder.getAdapterPosition()).getTeam());
        holder.standingIndex.setText(String.valueOf(standings.get(holder.getAdapterPosition()).getRank()));
        holder.standingPoints.setText(String.valueOf(standings.get(holder.getAdapterPosition()).getPoints()));
        holder.standingPlayed.setText(String.valueOf(standings.get(holder.getAdapterPosition()).getPlayedGames()));
        holder.standingGoalDifference.setText(String.valueOf(standings.get(holder.getAdapterPosition()).getGoalDifference()));
        if (standings.get(holder.getAdapterPosition()).getLogo() != null && standings.get(holder.getAdapterPosition()).getLogo().contains("svg")) {
            ImageUtils.loadSVG(mContext, standings.get(holder.getAdapterPosition()).getLogo(), holder.standingLogo);
        } else {
            ImageUtils.displayImageFromUrl(mContext, standings.get(holder.getAdapterPosition()).getLogo(), holder.standingLogo);
        }
    }

    @Override
    public int getItemCount() {
        return standings.size();
    }

    public LeagueTable.Standing getStandingAtPosition(int position) {
        return standings.get(position);
    }

    public LeagueTable.Standing getFirstStanding() {
        return standings.get(0);
    }

    public LeagueTable.Standing getLastStanding() {
        return standings.get(standings.size() - 1);
    }

    public void addStanding(LeagueTable.Standing fixture) {
        standings.add(fixture);
        notifyDataSetChanged();
    }

    public void addStandings(Collection<LeagueTable.Standing> fixtures) {
        this.standings.addAll(fixtures);
        notifyDataSetChanged();
    }

    public void clear() {
        standings.clear();
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.standing_index)
        TextView standingIndex;

        @BindView(R.id.standing_logo)
        ImageView standingLogo;

        @BindView(R.id.standing_name)
        TextView standingName;

        @BindView(R.id.standing_played)
        TextView standingPlayed;

        @BindView(R.id.standing_goal_diff)
        TextView standingGoalDifference;

        @BindView(R.id.standing_points)
        TextView standingPoints;

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
}
