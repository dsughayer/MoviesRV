package com.example.android.moviesrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by dsugh on 7/11/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    //List of Movies
    List<Movies> movies;
    private ImageLoader imageLoader;
    private Context context;

    public CardAdapter(List<Movies> movies, Context context) {
        super();
        //Getting all the Movies
        this.movies = movies;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movies_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Movies movie = movies.get(position);

        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        ImageLoader.ImageContainer imageContainer = imageLoader.get(movie.getImageUrl(),
                ImageLoader.getImageListener(holder.imageView,
                        R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        holder.imageView.setImageUrl(movie.getImageUrl(), imageLoader);
        holder.title.setText(movie.getTitle());
        holder.rating.setText(String.valueOf(movie.getRating()));
        holder.year.setText(movie.getYear());
        String genre = "";
        for (int i = 0; i < movie.getGenre().size(); i++) {
            genre += movie.getGenre().get(i);
        }

        holder.genre.setText(genre);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public NetworkImageView imageView;
        public TextView title;
        public TextView rating;
        public TextView year;
        public TextView genre;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            rating = (TextView) itemView.findViewById(R.id.rating);
            year = ((TextView) itemView.findViewById(R.id.year));
            genre = (TextView) itemView.findViewById(R.id.genre);
        }
    }
}