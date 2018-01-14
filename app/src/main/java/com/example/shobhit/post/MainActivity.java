package com.example.shobhit.post;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList <Post> post;
    CustomListAdapter listAdapter;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        post=new ArrayList<>();
        listAdapter=new CustomListAdapter(MainActivity.this,post);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(listAdapter);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,post.get(position).getTitle(),Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("title",post.get(position).getTitle());
                intent.putExtra("description",post.get(position).getBody());
                intent.putExtra("postId",post.get(position).getId()+"");
                startActivity(intent);
            }
        });

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<Post>> call = apiService.getPosts();
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>>call, Response<ArrayList<Post>> response) {
                for (int i=0;i<response.body().size();i++)
                post.add(response.body().get(i));
                Log.i("postId",post.get(2).getTitle());
                listAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                //Log.d(TAG, "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>>call, Throwable t) {
                // Log error here since request failed
                Log.d("Error", t.toString());
            }
        });

    }



}
