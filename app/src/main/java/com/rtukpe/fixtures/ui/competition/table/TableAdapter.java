package com.rtukpe.fixtures.ui.competition.table;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.LeagueTable;
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.Collection;

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
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_fixture_item, parent, false);
        return new ViewHolder(view, mRecyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

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
