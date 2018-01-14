package com.example.shobhit.post;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Comment> comments;
    CustomListAdapter2 listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i=getIntent();
        String title=i.getStringExtra("title");
        String description=i.getStringExtra("description");
        String postId=i.getStringExtra("postId");

        TextView des=(TextView)findViewById(R.id.desc);
        TextView titleE=(TextView)findViewById(R.id.title);
        des.setText(description);
        titleE.setText(title);

        comments=new ArrayList<>();
        listAdapter=new CustomListAdapter2(Main2Activity.this,comments);
        ListView listView=(ListView)findViewById(R.id.listC);
        listView.setAdapter(listAdapter);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<Comment>> call = apiService.getComments(postId+"");
        call.enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>>call, Response<ArrayList<Comment>> response) {
                for (int i=0;i<response.body().size();i++)
                    comments.add(response.body().get(i));
                Log.i("Comment",comments.get(1).body);
                listAdapter.notifyDataSetChanged();
                //Log.d(TAG, "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>>call, Throwable t) {
                // Log error here since request failed
                Log.d("Error", t.toString());
            }
        });



    }
}
