package dev.alexferreira.tddkotlinproject.ui.view

import android.os.Bundle
import android.view.View
import dev.alexferreira.tddkotlinproject.R
import dev.alexferreira.tddkotlinproject.data.model.Receita
import dev.alexferreira.tddkotlinproject.ui.contract.MainContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseView<MainContract.View, MainContract.Presenter>(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fab_add.setOnClickListener {
            presenter.selectAddReceita()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.onViewStarted(intent)
    }

    override fun initReceitaList(receitaList: MutableList<Receita>?) {

    }

    override fun showList() {
        recyclerView.visibility = View.VISIBLE
        tv_empty.visibility = View.GONE
    }

    override fun showEmptyText() {
        recyclerView.visibility = View.GONE
        tv_empty.visibility = View.VISIBLE
    }

    override fun openAddReceitaView() {
    }

    override fun openReceitaView(receita: Receita?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
