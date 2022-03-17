package pl.proexe.junior.view.epg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.proexe.junior.R
import pl.proexe.junior.model.data.DayTile
import pl.proexe.junior.model.data.NavigationDrawerModel
import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.model.data.TvProgrammeCategory
import pl.proexe.junior.presenter.epg.EpgPresenter
import pl.proexe.junior.presenter.epg.LocalEpgPresenter

class EpgActivity : AppCompatActivity(), EpgView {

    private val presenter: EpgPresenter = LocalEpgPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onViewCreated(this)
    }

    override fun showEpgList(programmes: List<TvProgramme>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDaysList(days: List<DayTile>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCategories(categories: List<TvProgrammeCategory>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNavigationDrawer(drawerModel: NavigationDrawerModel) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectDayTile(dayTile: DayTile) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
