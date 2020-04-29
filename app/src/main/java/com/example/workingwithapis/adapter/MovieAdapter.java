package com.example.workingwithapis.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workingwithapis.R;
import com.example.workingwithapis.activity.DetailsActivity;
import com.example.workingwithapis.model.Result;
import com.example.workingwithapis.callback.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private List<Result> movieList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public MovieAdapter(List<Result> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        context = parent.getContext();
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
        private View mview;
        private MovieHolder(@NonNull View itemView) {
            super(itemView);
            this.mview = itemView;

            imagePoster = itemView.findViewById(R.id.movie_poster_image);
            movieTitle = itemView.findViewById(R.id.movie_title);
            rating = itemView.findViewById(R.id.rating_TV);
            genres= itemView.findViewById(R.id.movie_category);
    }

    public void bind(final Result model)
    {
        movieTitle.setText(model.getTitle());
        rating.setText(Double.toString(model.getVoteAverage()));

        Picasso.get().load(posterPath + model.getPosterPath()).into(imagePoster);
        mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("movie_title",  model.getTitle());
                intent.putExtra("movie_rate", Double.toString(model.getVoteAverage()));
                intent.putExtra("poster_url",posterPath + model.getPosterPath());
                intent.putExtra("release_date", model.getReleaseDate());
                intent.putExtra("backdrop_path", posterPath + model.getBackdropPath());
                intent.putExtra("overview", model.getOverview());
                context.startActivity(intent);
            }
        });

    }

    }
}
