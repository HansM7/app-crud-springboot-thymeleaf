package com.example.ClientAplication.DTO;

import java.lang.reflect.Array;
import java.util.List;

public class ApiResponse<T> {

    private Boolean ok;
    private String message;
    private T data;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
