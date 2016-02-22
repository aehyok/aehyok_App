package com.aehyok.myapplication;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by aehyok on 2016/1/28.
 */
public class RequestProxy {
    private  static RequestQueue requestQueue;
    public void Get(Context context)
    {
        //aehyok app
        requestQueue= Volley.newRequestQueue(context);

    }
}
