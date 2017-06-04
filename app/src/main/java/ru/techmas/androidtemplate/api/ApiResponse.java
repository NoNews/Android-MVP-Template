package ru.techmas.androidtemplate.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex Bykov on 14.12.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class ApiResponse<T>{
    private String status;
    @SerializedName("statusCode")
    private String statusCode;
    @SerializedName("status_msg")
    private String statusMsg;
    @SerializedName("data")
    private T data;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public void setDate(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public T getData() {
        return data;
    }
}
