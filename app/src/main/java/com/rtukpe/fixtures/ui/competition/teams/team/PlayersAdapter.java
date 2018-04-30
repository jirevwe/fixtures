package com.rtukpe.fixtures.ui.competition.teams.team;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rtukpe.fixtures.R;
import com.rtukpe.fixtures.data.model.Player;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.ViewHolder> {
    private ArrayList<Player> players;
    private Context mContext;

    public PlayersAdapter(@NonNull Context context) {
        this.mContext = context;
        this.players = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_team_player_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.playerName.setText(players.get(holder.getAdapterPosition()).name);
        holder.playerPosition.setText(players.get(holder.getAdapterPosition()).position);
        holder.playerNumber.setText(String.valueOf(players.get(holder.getAdapterPosition()).jerseyNumber));
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public Player getPlayerAtPosition(int position) {
        return players.get(position);
    }

    public Player getFirstPlayer() {
        return players.get(0);
    }

    public Player getLastPlayer() {
        return players.get(players.size() - 1);
    }

    public void addPlayer(Player team) {
        players.add(team);
        notifyDataSetChanged();
    }

    public void addPlayers(Collection<Player> teams) {
        this.players.addAll(teams);
        notifyDataSetChanged();
    }

    public void clear() {
        players.clear();
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.player_name)
        TextView playerName;

        @BindView(R.id.player_number)
        TextView playerNumber;

        @BindView(R.id.player_position)
        TextView playerPosition;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
