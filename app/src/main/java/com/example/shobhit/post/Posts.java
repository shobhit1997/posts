package com.example.shobhit.post;

import java.util.ArrayList;

/**
 * Created by DELL on 1/14/2018.
 */

public class Posts {

    ArrayList<Post> posts;

    public Posts(ArrayList<Post> posts)
    {
        this.posts=posts;

    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
}
