package com.rtukpe.fixtures.ui.competition.teams.team;

import android.support.annotation.NonNull;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.rtukpe.fixtures.data.manager.DataManager;
import com.rtukpe.fixtures.data.model.Player;
import com.rtukpe.fixtures.data.model.PlayersResponse;
import com.rtukpe.fixtures.ui.base.BasePresenter;
import com.rtukpe.fixtures.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class TeamPresenter<Z extends TeamMvpView> extends BasePresenter<Z> implements TeamMvpContract<Z> {

    @Inject
    public TeamPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewInitialized() {
        super.onViewInitialized();
    }


    @Override
    public void getPlayers(int id) {
//        ArrayList<Player> players = getDataManager().getMockTeamPlayers().players;
//        players = (ArrayList<Player>) Stream.of(players).sortBy(player -> player.jerseyNumber).collect(Collectors.toList());
//        getMvpView().updatePlayers(players);

        getDataManager().getTeamPlayers(id).enqueue(new Callback<PlayersResponse>() {
            @Override
            public void onResponse(@NonNull Call<PlayersResponse> call, @NonNull Response<PlayersResponse> response) {
                if (response.body() != null) {
                    ArrayList<Player> players = response.body().players;
                    players = (ArrayList<Player>) Stream.of(players).sortBy(player -> player.jerseyNumber).collect(Collectors.toList());
                    getMvpView().updatePlayers(players);
                } else {
                    getMvpView().show("An error occured", true);
                }
            }

            @Override
            public void onFailure(@NonNull Call<PlayersResponse> call, @NonNull Throwable t) {
                Timber.w(t);
                getMvpView().show(t.getMessage(), true);
            }
        });
    }
}
