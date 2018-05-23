package com.rtukpe.fixtures.ui.competition.teams.team


import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.gson.Gson
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.data.model.Player
import com.rtukpe.fixtures.data.model.Team
import com.rtukpe.fixtures.ui.base.BaseDialog
import com.rtukpe.fixtures.utils.others.ImageUtils
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class TeamBottomSheetFragment : BaseDialog(), TeamMvpView {

    @Inject
    lateinit var mPresenter: TeamMvpContract<TeamMvpView>

    @BindView(R.id.recylcer_view)
    lateinit var mRecyclerView: RecyclerView

    @Inject
    lateinit var mLinearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var mDividerItemDecoration: DividerItemDecoration

    @Inject
    lateinit var mPlayersAdapter: PlayersAdapter

    @BindView(R.id.team_name)
    lateinit var teamNameTextView: TextView

    @BindView(R.id.team_logo)
    lateinit var teamLogo: ImageView

    private val mBottomSheetBehaviorCallback = object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss()
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {

        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(baseActivity, theme)
    }

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_team_bottom_sheet, null)

        val component = activityComponent
        if (component != null) {
            dialog.setContentView(view)

            component.inject(this)

            setUnBinder(ButterKnife.bind(this, view))

            mPresenter.onAttach(this)

            val params = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams
            val behavior = params.behavior

            if (behavior != null && behavior is BottomSheetBehavior<*>) {
                behavior.setBottomSheetCallback(mBottomSheetBehaviorCallback)
            }

            setUp(view)
        }
    }

    @OnClick(R.id.close)
    fun onCloseClicked(v: View) {
        dismiss()
    }

    override fun setUp(view: View) {
        mPresenter.onViewInitialized()

        val bundle = arguments
        if (bundle != null) {
            val team = Gson().fromJson(bundle.getString("TEAM"), Team::class.java)
            teamNameTextView.text = team.name

            Timber.d(team.toString())

            if (team.logo!!.contains("svg")) {
                ImageUtils.loadSVG(baseActivity, team.logo!!, teamLogo)
            } else {
                ImageUtils.displayImageFromUrl(baseActivity, team.logo!!, teamLogo)
            }

            mPresenter.getPlayers(team.id)
        }

        mRecyclerView.adapter = mPlayersAdapter
        mRecyclerView.layoutManager = mLinearLayoutManager
        mRecyclerView.addItemDecoration(mDividerItemDecoration)
    }

    override fun show(message: String, useToast: Boolean) {
        baseActivity.show(message, useToast)
    }

    override fun updatePlayers(players: ArrayList<Player>) {
        mPlayersAdapter.addPlayers(players)
    }

    companion object {

        fun newInstance(team: Team): TeamBottomSheetFragment {
            val dialog = TeamBottomSheetFragment()
            val args = Bundle()
            Timber.d(team.toString())
            args.putString("TEAM", team.toString())
            dialog.arguments = args
            return dialog
        }
    }
}
