package dev.alexferreira.tddkotlinproject.ui.view

import android.os.Bundle
import dev.alexferreira.tddkotlinproject.R
import dev.alexferreira.tddkotlinproject.data.model.Receita
import dev.alexferreira.tddkotlinproject.ui.contract.MainContract
import dev.alexferreira.tddkotlinproject.ui.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseView<MainContract.View, MainContract.Presenter>(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(repositoryInstance.receitaRepo)

        fab_add.setOnClickListener {
            presenter.selectAddReceita()
        }
    }

    override fun initReceitaList(receitaList: MutableList<Receita>?) {

    }

    override fun showList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyText() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openAddReceitaView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openReceitaView(receita: Receita?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
