package com.example.workingwithapis.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.workingwithapis.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private TextView movieTitleDetailsTV, movieRateDetailsTV, movieReleaseDateDetailsTV, overviewTV, titleDetailsTV;
    private ImageView posterDetailsImage, backdropPathImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        movieRateDetailsTV = findViewById(R.id.movie_rate_details);
        movieTitleDetailsTV = findViewById(R.id.movie_title_details);
        movieReleaseDateDetailsTV = findViewById(R.id.movie_release_date_details);
        titleDetailsTV = findViewById(R.id.title_details_TV);

        backdropPathImage = findViewById(R.id.backdrop_image_view_details);
        posterDetailsImage = findViewById(R.id.movie_poster_image_details);
        posterDetailsImage.setClipToOutline(true);
        overviewTV = findViewById(R.id.overview_text_view_details);
//        overviewTV.setText(Html.fromHtml("<p><u> Overview </p></u>"));

        Intent intent = getIntent();
        String title = intent.getExtras().getString("movie_title");
        String rate = intent.getExtras().getString("movie_rate");
        String releaseDate = intent.getExtras().getString("release_date");
        String imageUrl = intent.getExtras().getString("poster_url");
        movieTitleDetailsTV.setText(title);
        movieRateDetailsTV.setText(rate);
        movieReleaseDateDetailsTV.setText(releaseDate);
        titleDetailsTV.setText(title);
        overviewTV.setText(intent.getExtras().getString("overview"));
        Picasso.get().load(imageUrl).into(posterDetailsImage);
        Picasso.get().load(intent.getExtras().getString("backdrop_path")).into(backdropPathImage);


    }
}
