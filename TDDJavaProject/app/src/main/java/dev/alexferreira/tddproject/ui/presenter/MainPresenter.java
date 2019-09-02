package dev.alexferreira.tddproject.ui.presenter;

import android.content.Intent;

import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.repository.IReceitaRepository;
import dev.alexferreira.tddproject.ui.contract.MainContract;
import dev.alexferreira.tddproject.ui.task.LoadReceitaTask;
import dev.alexferreira.tddproject.ui.task.TaskCallback;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private IReceitaRepository receitaRepository;

    public MainPresenter(IReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @Override
    public void onViewStarted(Intent intent) {
        super.onViewStarted(intent);
        loadDataFromRepo();
    }

    private void loadDataFromRepo() {
        new LoadReceitaTask(receitaRepository, new TaskCallback<List<Receita>>() {
            @Override
            public void onError(Exception ex) {

            }

            @Override
            public void onEmptyData() {

            }

            @Override
            public void onLoadData(List<Receita> model) {

            }
        }).execute();
    }

    @Override
    public void selectAddReceita() {
        view.openAddReceitaView();
    }

    @Override
    public void selectReceitaItem(Receita item) {
        view.openReceitaView(item);
    }
}
