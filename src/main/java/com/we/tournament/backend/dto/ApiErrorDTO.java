package com.we.tournament.backend.dto;

public class ApiErrorDTO {
    private String error;
    private String message;

    public ApiErrorDTO() {
    }

    public ApiErrorDTO(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
