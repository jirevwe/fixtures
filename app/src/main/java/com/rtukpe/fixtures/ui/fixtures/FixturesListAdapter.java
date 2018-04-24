package com.rtukpe.fixtures.ui.fixtures;

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

public class FixturesListAdapter extends RecyclerView.Adapter<FixturesListAdapter.ViewHolder> {

    private ArrayList<Movie> mMovies;
    private Context mContext;
    private RecyclerViewClickListener mRecyclerViewClickListener;

    public FixturesListAdapter(@NonNull Context context) {
        this.mContext = context;
        this.mMovies = new ArrayList<>();
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
//        holder.bookName.setText(mMovies.get(holder.getAdapterPosition()).getTitle());
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public Movie getBookAtPosition(int position) {
        return mMovies.get(position);
    }

    public Movie getFirstBook() {
        return mMovies.get(0);
    }

    public Movie getLastBook() {
        return mMovies.get(mMovies.size() - 1);
    }

    public void addBook(Movie set) {
        mMovies.add(set);
        notifyDataSetChanged();
    }

    public void addBooks(Collection<Movie> movies) {
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    public void clear() {
        mMovies.clear();
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
