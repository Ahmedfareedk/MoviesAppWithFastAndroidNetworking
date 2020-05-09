package com.example.workingwithapis.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.example.workingwithapis.R;
import com.example.workingwithapis.adapter.MovieAdapter;
import com.example.workingwithapis.api.Networking;
import com.example.workingwithapis.callback.OnMovieListener;
import com.example.workingwithapis.model.Movies;

public class MainActivity extends AppCompatActivity {
    private RecyclerView movieRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieRecyclerview = findViewById(R.id.movies_recycler);
        movieRecyclerview.setLayoutManager(new LinearLayoutManager(this));



        Networking.fetchMovies(new OnMovieListener<Movies>() {
            @Override
            public void onResponse(Movies response) {
                movieRecyclerview.setAdapter(new MovieAdapter(response.getResults()));
            }
            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
            }
        });

















                /*.getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONObject data = response.optJSONObject("data");
                        JSONArray movies = data.optJSONArray("movies");
                        List<MovieData> movieData =  new ArrayList<>();

                        for(int i =0; i < movies.length(); i++)
                        {
                            JSONObject movie = movies.optJSONObject(i);
                            JSONArray genres = movie.optJSONArray("genres");
                            MovieData mData = new MovieData();

                            mData.setTitle(movie.optString("title"));
                            mData.setRating((float) movie.optDouble("rating"));
                            mData.setGenres(genres.optString(0));
                            mData.setLanguage(movie.optString("language"));
                            mData.setLarge_cover_image(movie.optString("large_cover_image"));

                            movieData.add(mData);
                        }

                        movieRecyclerview.setAdapter(new MoviesAdapter(movieData));
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

*/

    }
}
