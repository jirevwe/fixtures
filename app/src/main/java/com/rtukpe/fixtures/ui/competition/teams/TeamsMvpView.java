package com.rtukpe.fixtures.ui.competition.teams;

import com.rtukpe.fixtures.data.model.Team;
import com.rtukpe.fixtures.ui.base.MvpView;

import java.util.ArrayList;

public interface TeamsMvpView extends MvpView {

    void updateTeams(ArrayList<Team> fixtures);
}
