package com.rtukpe.fixtures.ui.competition.table;

import com.rtukpe.fixtures.data.model.LeagueTable;
import com.rtukpe.fixtures.ui.base.MvpView;

import java.util.ArrayList;

public interface TableMvpView extends MvpView {

    void updateTableStandings(ArrayList<LeagueTable.Standing> standings);

}
