package com.rtukpe.fixtures.ui.competitions;

import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.ui.base.MvpView;

import java.util.ArrayList;

public interface CompetitionsMvpView extends MvpView {

    void updateCompetitions(ArrayList<Competition> competitions);

}
