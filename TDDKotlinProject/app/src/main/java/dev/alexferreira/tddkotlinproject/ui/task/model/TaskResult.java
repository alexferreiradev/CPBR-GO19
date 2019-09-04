package dev.alexferreira.tddkotlinproject.ui.task.model;

public class TaskResult<M> {
    private M model;
    private Exception exception;
    private boolean hasError;
    private boolean isEmpty;

    TaskResult(M model, Exception exception, boolean hasError, boolean isEmpty) {
        this.model = model;
        this.exception = exception;
        this.hasError = hasError;
        this.isEmpty = isEmpty;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public boolean hasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String toString() {
        return "TaskResult{" +
                "model=" + model +
                ", exception=" + exception +
                ", hasError=" + hasError +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
