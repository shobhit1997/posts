package com.example.shobhit.post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DELL on 1/14/2018.
 */

public interface ApiInterface {
    @GET("posts")
    Call<ArrayList<Post>> getPosts();

    @GET("comments")
    Call<ArrayList<Comment>> getComments(@Query("postId") String postId);
}
