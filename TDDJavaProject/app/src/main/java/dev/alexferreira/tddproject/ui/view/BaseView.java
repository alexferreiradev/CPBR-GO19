package dev.alexferreira.tddproject.ui.view;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dev.alexferreira.tddproject.application.HasRoomDatabase;
import dev.alexferreira.tddproject.data.source.database.DataBaseDaoCreator;
import dev.alexferreira.tddproject.ui.contract.IView;

public abstract class BaseView<PresenterType> extends AppCompatActivity implements IView {

    protected PresenterType presenter;
    protected DataBaseDaoCreator daoCreator;

    @Override
    public void showPB() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application application = getApplication();
        if (application instanceof HasRoomDatabase) {
            daoCreator = (DataBaseDaoCreator) ((HasRoomDatabase) application).getDataBase();
        }
    }
}
