package dev.alexferreira.tddproject.ui.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import dev.alexferreira.tddproject.R;
import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.repository.ReceitaRepository;
import dev.alexferreira.tddproject.helper.ViewHelper;
import dev.alexferreira.tddproject.ui.contract.MainContract;
import dev.alexferreira.tddproject.ui.presenter.MainPresenter;

public class MainActivity extends BaseView implements MainContract.View, MainContract.Navigation {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_empty)
    TextView emptyTV;

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
