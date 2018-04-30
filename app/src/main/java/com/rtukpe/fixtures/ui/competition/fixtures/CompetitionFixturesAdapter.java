package com.rtukpe.fixtures.ui.competition.fixtures;

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
import com.rtukpe.fixtures.ui.base.BaseViewHolder;
import com.rtukpe.fixtures.utils.others.AppUtils;
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompetitionFixturesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int VIEW_TYPE_NORMAL = 1;
    private static final int VIEW_TYPE_EMPTY = 0;

    private ArrayList<Fixture> fixtures;
    private Context mContext;
    private RecyclerViewClickListener mRecyclerViewClickListener;
    private OnRetryClicked onRetryClickedListener;

    public CompetitionFixturesAdapter(@NonNull Context context) {
        this.mContext = context;
        this.fixtures = new ArrayList<>();
    }

    public void setOnRetryClickedListener(OnRetryClicked onRetryClickedListener) {
        this.onRetryClickedListener = onRetryClickedListener;
    }

    public void setRecyclerViewClickListener(RecyclerViewClickListener mRecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                View view = LayoutInflater.from(mContext).inflate(R.layout.layout_fixture_item, parent, false);
                return new ViewHolder(view, mRecyclerViewClickListener);
            case VIEW_TYPE_EMPTY:
            default:
                view = LayoutInflater.from(mContext).inflate(R.layout.layout_empty_view, parent, false);
                return new EmptyViewHolder(view, mRecyclerViewClickListener);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (fixtures != null && fixtures.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (fixtures != null && fixtures.size() > 0) {
            return fixtures.size();
        } else {
            return 1;
        }
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

    interface OnRetryClicked {
        void onRetryClicked();
    }

    protected class ViewHolder extends BaseViewHolder implements View.OnClickListener {

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
        public void onBind(int position) {
            super.onBind(position);

            homeTeamName.setText(fixtures.get(getAdapterPosition()).homeTeamName);
            awayTeamName.setText(fixtures.get(getAdapterPosition()).awayTeamName);

            homeTeamScore.setText(fixtures.get(getAdapterPosition()).result.goalsHomeTeam == -1 ?
                    "-" : String.valueOf(fixtures.get(getAdapterPosition()).result.goalsHomeTeam));
            awayTeamScore.setText(fixtures.get(getAdapterPosition()).result.goalsAwayTeam == -1 ?
                    "-" : String.valueOf(fixtures.get(getAdapterPosition()).result.goalsAwayTeam));

            matchDay.setText(String.format("MD: %s", String.valueOf(fixtures.get(getAdapterPosition()).matchday)));
            status.setText(fixtures.get(getAdapterPosition()).status);
            startTime.setText(new SimpleDateFormat("HH:mm", Locale.US).format(fixtures.get(getAdapterPosition()).date));
            minutes.setText(String.format("%s'", new SimpleDateFormat("mm", Locale.US).format(fixtures.get(getAdapterPosition()).date)));
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickListener.recyclerViewListClicked(v, getAdapterPosition());
        }
    }

    class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.error_no_internet)
        ImageView errorNoInternet;

        @BindView(R.id.error_no_items)
        ImageView errorNoItems;

        @BindView(R.id.error_text)
        TextView errorText;

        RecyclerViewClickListener recyclerViewClickListener;

        EmptyViewHolder(View itemView, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.recyclerViewClickListener = recyclerViewClickListener;
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            if (AppUtils.hasInternetConnection(mContext)) {
                errorNoItems.setVisibility(View.VISIBLE);
                errorNoInternet.setVisibility(View.GONE);
                errorText.setText(mContext.getResources().getString(R.string.empty));
            } else {
                errorNoInternet.setVisibility(View.VISIBLE);
                errorNoItems.setVisibility(View.GONE);
                errorText.setText(mContext.getResources().getString(R.string.offline));
            }
        }

        @OnClick(R.id.retry)
        void onRetryClick() {
            if (onRetryClickedListener != null) onRetryClickedListener.onRetryClicked();
        }
    }
}
