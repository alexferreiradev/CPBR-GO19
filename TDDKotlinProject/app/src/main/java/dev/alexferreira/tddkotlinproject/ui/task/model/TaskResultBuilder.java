package dev.alexferreira.tddkotlinproject.ui.task.model;

public class TaskResultBuilder<M> {
    private M model;
    private Exception exception;
    private boolean hasError;
    private boolean isEmpty;

    public TaskResult<M> createTaskResult() {
        return new TaskResult<M>(model, exception, hasError, isEmpty);
    }

    public TaskResultBuilder setModel(M model) {
        this.model = model;
        return this;
    }

    public TaskResultBuilder setException(Exception exception) {
        this.exception = exception;
        return this;
    }

    public TaskResultBuilder setHasError(boolean hasError) {
        this.hasError = hasError;
        return this;
    }

    public TaskResultBuilder setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
        return this;
    }
}