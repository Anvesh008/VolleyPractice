package com.example.volleypractice.volleyService;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;



public class VolleyUtils {

    private final static String TAG = "Volley Utils";

   /* RequestQueue mRequestQueue = null;
    Context context;
    VolleyResponseListener listener;*/

    public VolleyUtils() {
    }


    public void downloadImage(Context context, String url, final Map<String, String> json, final VolleyResponseListener listener) {

        // Retrieves an image specified by the URL, displays it in the UI.
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        listener.onResponse(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error.toString());
                    }
                });
        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance().addToRequestQueue(request);

    }



    //for get request

    public static void requestGetJSON(String url, final Map<String, String> json, final VolleyResponseListener listener) {




            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            listener.onResponse(response);

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if(error instanceof NoConnectionError){
                                listener.onError("Network is Unreachable.");
                            }else{
                                listener.onError("Please try again");
                            }

                        }
                    });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy( 90000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            // Access the RequestQueue through your singleton class.
            MySingleton.getInstance().addToRequestQueue(jsObjRequest);

    }


    //for post request

    public static void requestPostJSON(String url, final JSONObject json, final VolleyResponseListener listener) {

            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.POST, url, json, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d(TAG, "onResponse: "+response.toString());
                            listener.onResponse(response);

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG, "onErrorResponse: error Msg"+error.toString());
                            Log.d(TAG, "onErrorResponse: Error network response"+error.networkResponse);
                           if(error instanceof NoConnectionError){
                               listener.onError("Network is Unreachable.");
                           }else{
                               listener.onError("Please try again");
                           }

                        }
                    });
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy( 90000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            MySingleton.getInstance().addToRequestQueue(jsObjRequest);
    }

    //put request

    public static void requestPutJSON(String url, final JSONObject json, final VolleyResponseListener listener) {

            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.PUT, url, json, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            listener.onResponse(response);

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {

                            if(error instanceof NoConnectionError){
                                listener.onError("Network is Unreachable.");
                            }else{
                                listener.onError("Please try again");
                            }
                        }
                    });

            MySingleton.getInstance().addToRequestQueue(jsObjRequest);
    }

    //delete request

    public static void requestDeleteJSON(String url, final JSONObject json, final VolleyResponseListener listener) {

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.DELETE, url, json, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        listener.onResponse(response);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if(error instanceof NoConnectionError){
                            listener.onError("Network is Unreachable.");
                        }else{
                            listener.onError("Please try again");
                        }
                    }
                });

        MySingleton.getInstance().addToRequestQueue(jsObjRequest);
    }


    //convert json to java objects

    public static <T>T parseGsonResponse(String serverResponse, Class<T> target){
        T data = null;
        Gson gson = new Gson();
        try {
            data = gson.fromJson(serverResponse, target);
        }
        catch (Exception e) {
            Log.v(TAG,"error " + e.toString());
        }
       // Log.v(TAG,"data trans " + data);
        return data;
    }
}
