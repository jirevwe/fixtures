package com.rtukpe.fixtures.ui.competitions;

import com.rtukpe.fixtures.ui.base.MvpPresenter;

public interface CompetitionsMvpContract<V extends CompetitionsMvpView> extends MvpPresenter<V> {

    void getFeed();

}