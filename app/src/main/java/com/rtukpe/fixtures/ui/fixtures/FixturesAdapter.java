package com.rtukpe.fixtures.ui.fixtures;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lb.auto_fit_textview.AutoResizeTextView;
import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Fixture;
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.ViewHolder> {

    private ArrayList<Fixture> fixtures;
    private Context mContext;
    private RecyclerViewClickListener mRecyclerViewClickListener;

    public FixturesAdapter(@NonNull Context context) {
        this.mContext = context;
        this.fixtures = new ArrayList<>();
    }

    public void setRecyclerViewClickListener(RecyclerViewClickListener mRecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_fixtures_item, parent, false);
        return new ViewHolder(view, mRecyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.homeTeamName.setText(fixtures.get(holder.getAdapterPosition()).homeTeamName);
        holder.awayTeamName.setText(fixtures.get(holder.getAdapterPosition()).awayTeamName);

        holder.homeTeamScore.setText(fixtures.get(holder.getAdapterPosition()).result.goalsHomeTeam == -1 ?
                "-" : String.valueOf(fixtures.get(holder.getAdapterPosition()).result.goalsHomeTeam));
        holder.awayTeamScore.setText(fixtures.get(holder.getAdapterPosition()).result.goalsAwayTeam == -1 ?
                "-" : String.valueOf(fixtures.get(holder.getAdapterPosition()).result.goalsAwayTeam));

        holder.matchDay.setText(String.format("MD: %s", String.valueOf(fixtures.get(holder.getAdapterPosition()).matchday)));
        holder.status.setText(fixtures.get(holder.getAdapterPosition()).status);
        holder.startTime.setText(new SimpleDateFormat("HH:mm", Locale.US).format(fixtures.get(holder.getAdapterPosition()).date));
        holder.minutes.setText(String.format("%s'", new SimpleDateFormat("mm", Locale.US).format(fixtures.get(holder.getAdapterPosition()).date)));
    }

    @Override
    public int getItemCount() {
        return fixtures.size();
    }

    public Fixture getFixtureAtPosition(int position) {
        return fixtures.get(position);
    }

    public Fixture getFirstFixture() {
        return fixtures.get(0);
    }

    public Fixture getLastFixture() {
        return fixtures.get(fixtures.size() - 1);
    }

    public void addFixture(Fixture fixture) {
        fixtures.add(fixture);
        notifyDataSetChanged();
    }

    public void addFixtures(Collection<Fixture> fixtures) {
        this.fixtures.addAll(fixtures);
        notifyDataSetChanged();
    }

    public void clear() {
        fixtures.clear();
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.fixture_home_team_logo)
        ImageView homeTeamLogo;

        @BindView(R.id.fixture_away_team_logo)
        ImageView awayTeamLogo;

        @BindView(R.id.fixture_home_team_name)
        AutoResizeTextView homeTeamName;

        @BindView(R.id.fixture_away_team_name)
        AutoResizeTextView awayTeamName;

        @BindView(R.id.fixture_home_team_score)
        TextView homeTeamScore;

        @BindView(R.id.fixture_away_team_score)
        TextView awayTeamScore;

        @BindView(R.id.fixture_minutes)
        TextView minutes;

        @BindView(R.id.fixture_status)
        TextView status;

        @BindView(R.id.fixture_start_time)
        TextView startTime;

        @BindView(R.id.fixture_match_day)
        TextView matchDay;

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
