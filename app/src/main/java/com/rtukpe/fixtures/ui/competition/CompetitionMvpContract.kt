package com.rtukpe.fixtures.ui.competition

import com.rtukpe.fixtures.di.annotations.PerActivity
import com.rtukpe.fixtures.ui.base.MvpPresenter

/**
 * Created by rtukpe on 21/03/2018.
 */

@PerActivity
interface CompetitionMvpContract<V : CompetitionMvpView> : MvpPresenter<V>
