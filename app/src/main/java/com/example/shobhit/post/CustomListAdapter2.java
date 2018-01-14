package com.example.shobhit.post;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomListAdapter2 extends ArrayAdapter<Comment> {

    private final Activity context;
    ArrayList<Comment> comment=new ArrayList<>();

    public CustomListAdapter2(Activity context, ArrayList<Comment> comment) {
        super(context, R.layout.list_item,comment);
        // TODO Auto-generated constructor stub
        this.comment=comment;
        this.context=context;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item2, null,true);
        //Log.i("Post1",comment.get(1).getTitle()+"\n"+position);
        TextView email = (TextView) rowView.findViewById(R.id.email);
        TextView userId = (TextView) rowView.findViewById(R.id.title2);
        TextView name = (TextView) rowView.findViewById(R.id.title3);
        TextView body = (TextView) rowView.findViewById(R.id.body);



        email.setText(comment.get(position).getEmail()+"");
        userId.setText(comment.get(position).getId()+"");
        name.setText(comment.get(position).getName()+"");
        body.setText(comment.get(position).getBody()+"");

        return rowView;

    };
}