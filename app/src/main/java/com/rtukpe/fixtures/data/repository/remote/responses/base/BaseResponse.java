package com.rtukpe.fixtures.data.repository.remote.responses.base;

import com.rtukpe.fixtures.utils.others.AppUtils;

/**
 * Created by rtukpe on 14/03/2018.
 */

public class BaseResponse<T> {
    private String status;
    private T data;
    private Object message;
    private Object meta;

    public T getData() {
        return data;
    }

    public Object getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public Object getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return AppUtils.gson.toJson(this);
    }
}