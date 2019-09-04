package dev.alexferreira.tddkotlinproject.ui.contract;

import dev.alexferreira.tddkotlinproject.data.model.Receita;

import java.util.List;

public interface MainContract {
    interface View extends IView, Navigation {
        void initReceitaList(List<Receita> receitaList);

        void showList();

        void showEmptyText();
    }

    interface Navigation {
        void openAddReceitaView();

        void openReceitaView(Receita receita);
    }

    interface Presenter extends IPresenter<View> {
        void selectAddReceita();

        void selectReceitaItem(Receita item);
    }
}
