package com.example.mobilesoftwareengineeringlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.mobilesoftwareengineeringlab.Models.DataModel;
import com.example.mobilesoftwareengineeringlab.Models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    TextView firstname;
    TextView lastname;
    ImageView avatar;

    ArrayList<User> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        firstname = findViewById(R.id.first_name_text_view);
        lastname = findViewById(R.id.last_name_text_view);
        avatar = findViewById(R.id.image_view);

        String url = "https://reqres.in/api/users";

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(getStringRequest(url));
    }

    private StringRequest getStringRequest(String url){
        return new StringRequest(Request.Method.GET, url, (response) -> {
            try{
                JSONObject object = new JSONObject(response);
                JSONArray array = object.getJSONArray("data");
                JSONObject user = array.getJSONObject(0);

                firstname.setText(user.getString("first_name"));
                lastname.setText(user.getString("last_name"));

                Glide.with(this)
                        .load(user.getString("avatar"))
                        .circleCrop()
                        .into(avatar);

            } catch (JSONException e){
                e.printStackTrace();
            }

        }, (error) -> {

        });
    }
}