package dev.alexferreira.tddproject.ui.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import dev.alexferreira.tddproject.R;
import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.helper.ViewHelper;
import dev.alexferreira.tddproject.ui.contract.MainContract;
import dev.alexferreira.tddproject.ui.presenter.MainPresenter;

public class MainActivity extends BaseView<MainContract.View, MainContract.Presenter> implements MainContract.View, MainContract.Navigation {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_empty)
    TextView emptyTV;
    @BindView(R.id.fab_add)
    FloatingActionButton addFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(repositoryInstance.getReceitaRepo());

        addFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.selectAddReceita();
            }
        });
    }

    @Override
    public void initReceitaList(List<Receita> receitaList) {

    }

    @Override
    public void showList() {
        ViewHelper.showFirstGoneSecond(recyclerView, emptyTV);
    }

    @Override
    public void showEmptyText() {
        ViewHelper.showFirstGoneSecond(emptyTV, recyclerView);
    }

    @Override
    public void openAddReceitaView() {

    }

    @Override
    public void openReceitaView(Receita receita) {

    }
}
