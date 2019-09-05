package dev.alexferreira.tddkotlinproject.ui.presenter

import android.content.Intent
import dagger.Lazy
import dev.alexferreira.tddkotlinproject.data.model.Receita
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository
import dev.alexferreira.tddkotlinproject.data.repository.ReceitaRepositoryKotlin
import dev.alexferreira.tddkotlinproject.injection.scope.ActivityScope
import dev.alexferreira.tddkotlinproject.ui.contract.MainContract
import dev.alexferreira.tddkotlinproject.ui.task.LoadReceitaTaskKotlin
import dev.alexferreira.tddkotlinproject.ui.task.TaskCallback
import javax.inject.Inject

class MainPresenterKotlin @Inject constructor(val repository: Lazy<IReceitaRepository>) :
    BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    override fun onViewStarted(intent: Intent?) {
        super.onViewStarted(intent)
        loadFromRepo()
    }

    private fun loadFromRepo() {
        LoadReceitaTaskKotlin(repository.get(), object : TaskCallback<List<Receita>> {
            override fun onError(ex: Exception?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onEmptyData() {
                view.hidePB()
                view.showEmptyText()
            }

            override fun onLoadData(model: List<Receita>?) {
                view.hidePB()
                view.initReceitaList(model)
                view.showList()
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