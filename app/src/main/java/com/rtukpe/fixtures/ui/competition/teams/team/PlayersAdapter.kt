package com.rtukpe.fixtures.ui.competition.teams.team

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Player
import java.util.*

class PlayersAdapter(private val mContext: Context) : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {
    val players: ArrayList<Player> = ArrayList()

    val firstPlayer: Player
        get() = players[0]

    val lastPlayer: Player
        get() = players[players.size - 1]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_team_player_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.playerName.text = players[holder.adapterPosition].name
        holder.playerPosition.text = players[holder.adapterPosition].position
        holder.playerNumber.text = players[holder.adapterPosition].jerseyNumber.toString()
    }

    override fun getItemCount(): Int {
        return players.size
    }

    fun getPlayerAtPosition(position: Int): Player {
        return players[position]
    }

    fun addPlayer(team: Player) {
        players.add(team)
        notifyDataSetChanged()
    }

    fun addPlayers(teams: Collection<Player>) {
        this.players.addAll(teams)
        notifyDataSetChanged()
    }

    fun clear() {
        players.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.player_name)
        lateinit var playerName: TextView

        @BindView(R.id.player_number)
        lateinit var playerNumber: TextView

        @BindView(R.id.player_position)
        lateinit var playerPosition: TextView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}
