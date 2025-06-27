package com.we.tournament.backend.dto;

public class SimpleResponseDTO {
    private String message;
    private int code;

    public SimpleResponseDTO() {
    }

    public SimpleResponseDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SimpleResponseDTO{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleResponseDTO that)) return false;
        return code == that.code && message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return message.hashCode() + code;
    }
}
