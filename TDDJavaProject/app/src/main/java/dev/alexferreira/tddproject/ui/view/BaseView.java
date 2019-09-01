package dev.alexferreira.tddproject.ui.view;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.alexferreira.tddproject.R;
import dev.alexferreira.tddproject.application.HasRoomDatabase;
import dev.alexferreira.tddproject.application.RepositoryCreator;
import dev.alexferreira.tddproject.data.source.database.DataBaseDaoCreator;
import dev.alexferreira.tddproject.ui.contract.IPresenter;
import dev.alexferreira.tddproject.ui.contract.IView;

public abstract class BaseView<V extends IView, PresenterType extends IPresenter<V>> extends AppCompatActivity implements IView {

    protected PresenterType presenter;
    protected DataBaseDaoCreator daoCreator;
    protected RepositoryCreator repositoryInstance;
    private V subView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

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
        daoCreator = (DataBaseDaoCreator) ((HasRoomDatabase) application).getDataBase();
        repositoryInstance = (RepositoryCreator) application;
        subView = (V) this;

        ButterKnife.bind(this);
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
}
