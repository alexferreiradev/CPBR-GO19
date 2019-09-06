package dev.alexferreira.tddkotlinproject.ui.contract

import dev.alexferreira.tddkotlinproject.data.model.Receita

interface MainContractKotlin {
    interface View : IView, Navigation {
        fun initReceitaList(receitaList: List<Receita>)

        fun showList()

        fun showEmptyText()
    }

    interface Navigation {
        fun openAddReceitaView()

        fun openReceitaView(receita: Receita)
    }

    interface Presenter : IPresenter<View> {
        fun selectAddReceita()

        fun selectReceitaItem(item: Receita)
    }
}