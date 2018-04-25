package com.rtukpe.fixtures.ui.competitions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Movie;
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.ButterKnife;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.ViewHolder> {

    private ArrayList<Movie> mFeeds;
    private Context mContext;
    private RecyclerViewClickListener mRecyclerViewClickListener;

    public CompetitionsAdapter(@NonNull Context context) {
        this.mContext = context;
        this.mFeeds = new ArrayList<>();
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
//        holder.mFeedText.setText(mContext.getString(R.string.our_take_placeholder));
    }

    @Override
    public int getItemCount() {
        return mFeeds.size();
    }

    public Movie getBookAtPosition(int position) {
        return mFeeds.get(position);
    }

    public Movie getFirstBook() {
        return mFeeds.get(0);
    }

    public Movie getLastBook() {
        return mFeeds.get(mFeeds.size() - 1);
    }

    public void addBook(Movie set) {
        mFeeds.add(set);
        notifyDataSetChanged();
    }

    public void addBooks(Collection<Movie> movies) {
        mFeeds.addAll(movies);
        notifyDataSetChanged();
    }

    public void clear() {
        mFeeds.clear();
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RecyclerViewClickListener recyclerViewClickListener;

        ViewHolder(View itemView, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            this.recyclerViewClickListener = recyclerViewClickListener;
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickListener.recyclerViewListClicked(v, getAdapterPosition());
        }
    }
}
