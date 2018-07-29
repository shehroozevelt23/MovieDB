package com.example.shehrooz.movies.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shehrooz.movies.R;
import com.squareup.picasso.Picasso;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        TextView movieTitle = findViewById(R.id.movie_final_title);
        ImageView movieImage = findViewById(R.id.movie_final_pic);
        TextView movieDescription = findViewById(R.id.movie_description);
        TextView movieAdult = findViewById(R.id.adult_final);
        TextView movieDate = findViewById(R.id.release_date_final);
        TextView movieVoteCount = findViewById(R.id.vote_count_final);
        TextView movieVoteAverage = findViewById(R.id.vote_average_final);
        TextView movieLanguage = findViewById(R.id.original_language_final);

        movieTitle.setText(getIntent().getStringExtra("movieTitle"));
        movieDescription.setText(getIntent().getStringExtra("movieDescription"));
        movieAdult.setText(Boolean.toString(getIntent().getBooleanExtra("movieAdult", true)));
        movieDate.setText(getIntent().getStringExtra("movieDate"));
        movieLanguage.setText(getIntent().getStringExtra("movieLanguage"));
        Picasso.get().load(getIntent().getStringExtra("movieImage")).fit().into(movieImage);
        movieVoteCount.setText(Integer.toString(getIntent().getIntExtra("movieVoteCount", 0)));
        movieVoteAverage.setText(Double.toString(getIntent().getDoubleExtra("movieVoteAverage", 0)));

    }
}