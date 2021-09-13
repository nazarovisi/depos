package com.aris.depo.model;

public class Response {

    private int status = 200;
    private String message = "Success!";
    private Object response;

    public Response() {

    }

    public int getStatus() {
        return status;
    }

    public Response setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getResponse() {
        return response;
    }

    public Response setResponse(Object response) {
        this.response = response;
        return this;
    }


}
