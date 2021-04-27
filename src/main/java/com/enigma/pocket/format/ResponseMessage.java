package com.enigma.pocket.format;

import java.time.LocalDateTime;

public class ResponseMessage<T> {
    private Integer responseCode;
    private String description;
    private LocalDateTime timestamp;

    private T data;

    public ResponseMessage(Integer responseCode, String description, T data) {
        this.responseCode = responseCode;
        this.description = description;
        this.data = data;
    }

    public static <T> ResponseMessage<T> commonResponse(Integer code, T data){
        return new ResponseMessage<>(code, "SUCCESS", data);
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
