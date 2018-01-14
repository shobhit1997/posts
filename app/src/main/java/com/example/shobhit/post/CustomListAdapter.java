package com.example.shobhit.post;

        import android.app.Activity;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Post> {

    private final Activity context;
    ArrayList<Post> post=new ArrayList<>();

    public CustomListAdapter(Activity context, ArrayList<Post> post) {
        super(context, R.layout.list_item,post);
        // TODO Auto-generated constructor stub
        this.post=post;
        this.context=context;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item, null,true);
        Log.i("Post1",post.get(1).getTitle()+"\n"+position);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.Itemname);
        TextView imageView = (TextView) rowView.findViewById(R.id.icon);


        txtTitle.setText(post.get(position).getTitle()+"");
        imageView.setText(post.get(position).getUserId()+"");

        return rowView;

    };
}