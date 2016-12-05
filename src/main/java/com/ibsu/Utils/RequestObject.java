package com.ibsu.Utils;


public class RequestObject<T> {

    private T data;

    private RequestObject() {}

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
