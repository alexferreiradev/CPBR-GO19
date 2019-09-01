package dev.alexferreira.tddproject.ui.contract;

import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;

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
