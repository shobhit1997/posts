package com.example.shobhit.post;

/**
 * Created by DELL on 1/14/2018.
 */

public class Comment {

    int postId,id;
    String name,email,body;

    public Comment(int postId,int id,String name,String email, String body)
    {
        this.postId=postId;
        this.id=id;
        this.name=name;
        this.body=body;
        this.email=email;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public String getEmail() {
        return email;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
