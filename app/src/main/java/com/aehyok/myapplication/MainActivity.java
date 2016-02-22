package com.aehyok.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static RequestQueue mQueue;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.button)
    Button button;

    private String jsonList;
    @Bind(R.id.editText)
    EditText editText;

    private  String str;
    public void Onclick(View view)
    {
        textView.setText("Hello World!");
        //Test 再来测测试一下
        String url = "http://192.168.199.222:888/api/Blog/Detail/100";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println("response="+response);
                        textView.setText(response.toString());
//                        Toast.makeText(MainActivity.this,response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        System.out.println("response=");
//                        Toast.makeText(MainActivity.this,error.toString(), Toast.LENGTH_SHORT).show();
                        textView.setText(error.toString());
                    }


                }
        );
        request.setRetryPolicy(new DefaultRetryPolicy(5000, 2, 2f));
        String requestTag = "volley_getjson";
        request.setTag(requestTag);
        mQueue.add(request);
        str=str+"Hello World";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //setIntent(N);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mQueue = Volley.newRequestQueue(this);
        String url = "http://www.aehyok.com";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response.substring(100,300));
//                        Toast.makeText(MainActivity.this,response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this,error.toString(), Toast.LENGTH_SHORT).show();
                        textView.setText(error.toString());
                    }
                }
        );

        StringRequest request1 = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response.substring(100,300));
//                        Toast.makeText(MainActivity.this,response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this,error.toString(), Toast.LENGTH_SHORT).show();
                        textView.setText(error.toString());
                    }


                }
        );

        //request.setRetryPolicy()
        String requestTag = "volley_get";
        request.setTag(requestTag);
        mQueue.add(request);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
