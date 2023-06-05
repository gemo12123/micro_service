package org.mytest.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResEntity implements Serializable {
    private Result result;
    private String reason;

    public ResEntity(Result result) {
        this.result = result;
    }

    public static enum Result{
        SUCCESS,
        ERROR;
    }
}
