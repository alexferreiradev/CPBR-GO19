package dev.alexferreira.tddproject.ui.view;

import android.os.Bundle;

import java.util.List;

import dev.alexferreira.tddproject.R;
import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.repository.ReceitaRepository;
import dev.alexferreira.tddproject.ui.contract.MainContract;
import dev.alexferreira.tddproject.ui.presenter.MainPresenter;

public class MainActivity extends BaseView implements MainContract.View, MainContract.Navigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(new ReceitaRepository(daoCreator.createReceitaDao()));
    }

    @Override
    public void initReceitaList(List<Receita> receitaList) {

    }

    @Override
    public void showList() {

    }

    @Override
    public void showEmptyText() {

    }

    @Override
    public void openAddReceitaView() {

    }

    @Override
    public void openReceitaView(Receita receita) {

    }
}
