package com.example.shehrooz.movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.shehrooz.movies.R;
import com.example.shehrooz.movies.activity.FinalActivity;
import com.example.shehrooz.movies.model.Movie;
import com.example.shehrooz.movies.model.MovieResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private List<Movie> movies;
    private Context context;

    public MovieAdapter(Callback<MovieResponse> callback, List<Movie> movies) {
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        LinearLayout movieLayout;
        TextView movieTitle;
        TextView movieDescription;
        TextView movieYear;
        ImageView moviePhoto;

        public MovieViewHolder(View itemView) {
            super(itemView);

            movieLayout = itemView.findViewById(R.id.parent_layout);
            movieTitle = itemView.findViewById(R.id.title_text);
            movieDescription = itemView.findViewById(R.id.desc_text);
            movieYear = itemView.findViewById(R.id.year_text);
            moviePhoto = itemView.findViewById(R.id.image);
        }
    }

        public MovieAdapter(List<Movie> movies, int recycler_row, Context context){
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.movieYear.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());

        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath())
                .fit()
                .into(holder.moviePhoto);

        holder.movieLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FinalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movieTitle", movies.get(position).getTitle());
                intent.putExtra("movieImage", "https://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath());
                intent.putExtra("movieAdult", movies.get(position).isAdult());
                intent.putExtra("movieDate", movies.get(position).getReleaseDate());
                intent.putExtra("movieVoteAverage", movies.get(position).getVoteAverage());
                intent.putExtra("movieLanguage", movies.get(position).getOriginalLanguage());
                intent.putExtra("movieVoteCount", movies.get(position).getVoteCount());
                intent.putExtra("movieVoteAverage", movies.get(position).getVoteAverage());
                intent.putExtra("movieDescription", movies.get(position).getOverview());
                intent.putExtra("movieAdult", movies.get(position).isAdult());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
