package dev.alexferreira.tddproject.ui.presenter;

import android.content.Intent;

import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.repository.ReceitaRepository;
import dev.alexferreira.tddproject.ui.contract.MainContract;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private ReceitaRepository receitaRepository;

    public MainPresenter(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @Override
    public void onViewStarted(Intent intent) {
        super.onViewStarted(intent);
    }

    @Override
    public void selectAddReceita() {

    }

    @Override
    public void selectReceitaItem(Receita item) {

    }
}