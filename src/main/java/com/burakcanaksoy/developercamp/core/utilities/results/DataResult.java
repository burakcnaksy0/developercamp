package com.burakcanaksoy.developercamp.core.utilities.results;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResult<T> extends Result{
    private T data;

    public DataResult(boolean success) {
        super(success);
    }
    public DataResult(T data , boolean success) {
        super(success);
        this.data = data;
    }
    public DataResult(T data , boolean success, String message) {
        super(success, message);
        this.data = data;
    }
}
