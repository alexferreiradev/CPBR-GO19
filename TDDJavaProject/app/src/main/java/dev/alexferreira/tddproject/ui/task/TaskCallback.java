package dev.alexferreira.tddproject.ui.task;

public interface TaskCallback<M> {
    void onError(Exception ex);

    void onEmptyData();

    void onLoadData(M model);
}