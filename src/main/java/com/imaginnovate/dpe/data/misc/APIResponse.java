package com.imaginnovate.dpe.data.misc;

import jakarta.ws.rs.core.Response;
import lombok.Data;

@Data
public class APIResponse {
    private boolean success;
    private String message;
    private Object data;

    // Constructors, getters, and setters

    public static Response success(Object data) {
        APIResponse response = new APIResponse();
        response.setSuccess(true);
        response.setData(data);
        return Response.ok(response).build();
    }

    public static Response success(String message, Object data) {
        APIResponse response = new APIResponse();
        response.setSuccess(true);
        response.setData(data);
        response.setMessage(message);
        return Response.ok(response).build();
    }

    public static Response error(String message) {
        APIResponse response = new APIResponse();
        response.setSuccess(false);
        response.setMessage(message);
        response.setData(null);
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(response)
                .build();    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

