package com.example.shehrooz.movies.rest;

import com.example.shehrooz.movies.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("movie/top_rated")
    abstract public Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    abstract public Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

}
