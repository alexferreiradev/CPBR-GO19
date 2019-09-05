package dev.alexferreira.tddkotlinproject.ui.presenter

import android.content.Intent
import dev.alexferreira.tddkotlinproject.data.model.Receita
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository
import dev.alexferreira.tddkotlinproject.ui.contract.MainContract
import dev.alexferreira.tddkotlinproject.ui.task.LoadReceitaTaskKotlin
import dev.alexferreira.tddkotlinproject.ui.task.TaskCallback
import java.lang.Exception

class MainPresenterKotlin(val repository: IReceitaRepository) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    override fun onViewStarted(intent: Intent?) {
        super.onViewStarted(intent)
        loadFromRepo()
    }

    private fun loadFromRepo() {
        LoadReceitaTaskKotlin(repository, object : TaskCallback<List<Receita>> {
            override fun onError(ex: Exception?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onEmptyData() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onLoadData(model: List<Receita>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }).execute()
    }

    override fun selectAddReceita() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectReceitaItem(item: Receita?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}