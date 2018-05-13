package com.rtukpe.fixtures.ui.competitions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lb.auto_fit_textview.AutoResizeTextView;
import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.ViewHolder> {

    private ArrayList<Competition> mCompetitions;
    private Context mContext;
    private RecyclerViewClickListener mRecyclerViewClickListener;

    public CompetitionsAdapter(@NonNull Context context) {
        this.mContext = context;
        this.mCompetitions = new ArrayList<>();
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
        holder.competitionName.setText(mCompetitions.get(position).getCaption());
        holder.competitionLogo.setImageDrawable(mContext.getResources().getDrawable(R.drawable.champions_league32x32));
    }

    @Override
    public int getItemCount() {
        return mCompetitions.size();
    }

    public Competition getCompetitionAtPosition(int position) {
        return mCompetitions.get(position);
    }

    public Competition getFirstCompetition() {
        return mCompetitions.get(0);
    }

    public Competition getLastCompetition() {
        return mCompetitions.get(mCompetitions.size() - 1);
    }

    public void addCompetition(Competition set) {
        mCompetitions.add(set);
        notifyDataSetChanged();
    }

    public void addCompetitions(Collection<Competition> competitions) {
        mCompetitions.addAll(competitions);
        notifyDataSetChanged();
    }

    public void clear() {
        mCompetitions.clear();
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.competition_logo)
        ImageView competitionLogo;

        @BindView(R.id.competition_name)
        AutoResizeTextView competitionName;

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
