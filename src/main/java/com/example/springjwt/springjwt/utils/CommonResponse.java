package com.example.springjwt.springjwt.utils;

public class CommonResponse<T> {
    CommonStatus commonStatus;
    T data;

    public CommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
