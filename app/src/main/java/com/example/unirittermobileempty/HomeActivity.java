package com.example.unirittermobileempty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private void fetchApi(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);


        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                TextView tv = findViewById(R.id.requestText);
                tv.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new AlertDialog.Builder(getApplicationContext())
                        .setTitle("Error in request")
                        .setMessage(error.toString())
                        .show();
            }
        });

        queue.add(request);
    }

    public void fetchTodos(View $view) {
        this.fetchApi("https://jsonplaceholder.typicode.com/todos");
    }

    public void fetchUsers(View $view) {
        this.fetchApi("https://jsonplaceholder.typicode.com/users");
    }

    public void fetchPosts(View $view) {
        this.fetchApi("https://jsonplaceholder.typicode.com/posts");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void navigateToLogin(View $view) {
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}