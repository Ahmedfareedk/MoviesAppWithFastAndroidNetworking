package com.example.workingwithapis.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workingwithapis.R;
import com.example.workingwithapis.api.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private List<Result> movieList;

    public MovieAdapter(List<Result> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        holder.bind(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        private ImageView imagePoster;
        private TextView movieTitle, rating, genres;
        private String posterPath = "https://image.tmdb.org/t/p/w500/";
        private MovieHolder(@NonNull View itemView) {
            super(itemView);

            imagePoster = itemView.findViewById(R.id.movie_poster_image);
            movieTitle = itemView.findViewById(R.id.movie_title);
            rating = itemView.findViewById(R.id.rating_TV);
            genres= itemView.findViewById(R.id.movie_category);


    }

    public void bind(Result model)
    {
        movieTitle.setText(model.getTitle());
        rating.setText(Double.toString(model.getVoteAverage()));

        Picasso.get().load(posterPath + model.getPosterPath()).into(imagePoster);
    }

    }
}
