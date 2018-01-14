package com.example.shobhit.post;

/**
 * Created by DELL on 1/14/2018.
 */

public class Post {

    String title,body;
    int id,userId;
    public Post(int userId,int id,String title,String body)
    {
        this.userId=userId;
        this.id=id;
        this.body=body;
        this.title=title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
