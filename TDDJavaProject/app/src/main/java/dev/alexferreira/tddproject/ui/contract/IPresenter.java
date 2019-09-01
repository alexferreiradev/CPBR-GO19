package dev.alexferreira.tddproject.ui.contract;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public interface IPresenter<V extends IView> {

    void onViewCreated(V view, Context context, Activity activity);

    void onViewDestroyed();

    void onViewPaused(Bundle bundle);

    void onViewStarted(Intent intent);
}
