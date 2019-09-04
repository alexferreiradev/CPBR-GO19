package dev.alexferreira.tddkotlinproject.ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import dev.alexferreira.tddkotlinproject.ui.contract.IPresenter;
import dev.alexferreira.tddkotlinproject.ui.contract.IView;

public abstract class BasePresenter<V extends IView> implements IPresenter<V> {

    protected V view;
    protected Context context;
    protected Activity activity;

    @Override
    public void onViewCreated(V view, Context context, Activity activity) {
        this.view = view;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void onViewDestroyed() {

    }

    @Override
    public void onViewPaused(Bundle bundle) {

    }

    @Override
    public void onViewStarted(Intent intent) {

    }
}
