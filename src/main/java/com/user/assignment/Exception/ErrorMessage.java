package com.user.assignment.Exception;


public class ErrorMessage {
    private int statusCode;
    private String message;

    public ErrorMessage(int status, String message) {
        this.statusCode = status;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
