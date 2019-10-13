package com.zypher606.SpringCRUD.models;


import org.json.simple.JSONObject;

/**
 * Created by zypher606 on 13/10/19.
 */
public class Api {
    private String status;
    private String message;
    private Object data;

    public Api(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public JSONObject getApiResponse() {
        JSONObject res = new JSONObject();
        res.put("status", status);
        res.put("message", message);
        res.put("data", data);
        return res;
    }
}
