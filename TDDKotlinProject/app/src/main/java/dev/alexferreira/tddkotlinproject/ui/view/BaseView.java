package dev.alexferreira.tddkotlinproject.ui.view;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import dev.alexferreira.tddkotlinproject.R;
import dev.alexferreira.tddkotlinproject.application.RepositoryCreator;
import dev.alexferreira.tddkotlinproject.application.RoomDatabaseCreator;
import dev.alexferreira.tddkotlinproject.data.source.database.DataBaseDaoCreator;
import dev.alexferreira.tddkotlinproject.ui.contract.IPresenter;
import dev.alexferreira.tddkotlinproject.ui.contract.IView;

public abstract class BaseView<V extends IView, PresenterType extends IPresenter<V>> extends AppCompatActivity implements IView {

    protected PresenterType presenter;
    protected DataBaseDaoCreator daoCreator;
    protected RepositoryCreator repositoryInstance;
    ProgressBar progressBar;
    private V subView;

    @Override
    public void showPB() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePB() {
        progressBar.setVisibility(View.GONE);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application application = getApplication();
        daoCreator = (DataBaseDaoCreator) ((RoomDatabaseCreator) application).getDataBase();
        repositoryInstance = (RepositoryCreator) application;
        subView = (V) this;

        this.progressBar = findViewById(R.id.progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onViewCreated(subView, getApplicationContext(), this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onViewPaused(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDestroyed();
    }

    public void setPresenter(PresenterType presenter) {
        this.presenter = presenter;
    }
}
