package com.example.volleypractice.volleyService;


public interface VolleyResponseListener {

    void onError(String message);

    void onResponse(Object response);

}
