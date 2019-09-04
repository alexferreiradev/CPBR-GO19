package dev.alexferreira.tddkotlinproject.ui.task;

import android.os.AsyncTask;
import dev.alexferreira.tddkotlinproject.ui.task.model.TaskResult;
import dev.alexferreira.tddkotlinproject.ui.task.model.TaskResultBuilder;

abstract class DefaultLoadTask<M, R> extends AsyncTask<String, Integer, TaskResult<M>> {

    protected R repository;
    TaskResultBuilder<M> builder = new TaskResultBuilder<>();
    private TaskCallback<M> callback;

    DefaultLoadTask(R repository, TaskCallback<M> callback) {
        this.callback = callback;
        this.repository = repository;
    }

    @Override
    protected void onPostExecute(TaskResult<M> defaultResult) {
        super.onPostExecute(defaultResult);
        if (defaultResult == null) {
            callback.onError(new NullPointerException("Resultado de background foi nulo"));
        } else if (defaultResult.hasError()) {
            callback.onError(defaultResult.getException());
        } else if (defaultResult.isEmpty()) {
            callback.onEmptyData();
        } else if (defaultResult.getModel() == null) {
            callback.onError(new NullPointerException("model está nulo"));
        } else {
            callback.onLoadData(defaultResult.getModel());
        }
    }
}
