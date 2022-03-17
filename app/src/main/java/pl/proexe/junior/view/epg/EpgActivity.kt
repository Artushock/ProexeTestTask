package pl.proexe.junior.view.epg

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import pl.proexe.junior.R
import pl.proexe.junior.databinding.ActivityMainBinding
import pl.proexe.junior.model.data.DayTile
import pl.proexe.junior.model.data.NavigationDrawerModel
import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.model.data.TvProgrammeCategory
import pl.proexe.junior.presenter.epg.EpgPresenter
import pl.proexe.junior.presenter.epg.LocalEpgPresenter
import pl.proexe.junior.view.epg.recycler.EpgListAdapter

class EpgActivity : AppCompatActivity(), EpgView {

    private val presenter: EpgPresenter = LocalEpgPresenter()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initActionBar()

        presenter.onViewCreated(this)
    }

    private fun initActionBar() {
        setSupportActionBar(binding.myAwesomeToolbar)
        supportActionBar?.let {
            it.title = getString(R.string.program_tv)
            it.setDisplayHomeAsUpEnabled(true)
            val drawable = ContextCompat.getDrawable(this, R.drawable.ic_hamburger_v)
            it.setHomeAsUpIndicator(drawable)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optional_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                binding.drawer.openDrawer(GravityCompat.START)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showEpgList(programmes: List<TvProgramme>) {

        val adapter = EpgListAdapter(programmes)
        val recyclerView = binding.epgRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemDecoration =
            DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        val drawable = ContextCompat.getDrawable(this, R.drawable.epg_item_divider)
        if (drawable != null) {
            itemDecoration.setDrawable(drawable)
        }

        recyclerView.addItemDecoration(itemDecoration)

        recyclerView.adapter = adapter

    }

    override fun showDaysList(days: List<DayTile>) {
        val linearLayout = binding.daysListLinearLayout

        for (d in days) {
            val tv = TextView(this)
            tv.setTextColor(ContextCompat.getColor(this, R.color.colorRecyclerViewTimeItemNotSelected))
            tv.setPadding(60, 0, 60, 0)
            tv.text = getString(d.dayLabel)
            linearLayout.addView(tv)
        }
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
