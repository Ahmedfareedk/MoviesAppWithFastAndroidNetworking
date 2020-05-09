package com.example.workingwithapis.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workingwithapis.R;
import com.example.workingwithapis.adapter.ReviewsAdapter;
import com.example.workingwithapis.adapter.TrailerAdapter;
import com.example.workingwithapis.api.Networking;
import com.example.workingwithapis.callback.OnMovieListener;
import com.example.workingwithapis.callback.OnReviewItem;
import com.example.workingwithapis.model.Reviews;
import com.example.workingwithapis.model.Trailers;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private TextView movieTitleDetailsTV, movieRateDetailsTV, movieReleaseDateDetailsTV, overviewTV, titleDetailsTV;
    private ImageView posterDetailsImage, backdropPathImage;
    private RecyclerView trailerRecycler, reviewsRecycler;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private String movieId;
    private TextView reviewAuthor, reviewContent, reviewAuthorBottomSheetTV, reviewContentBottomSheetTV;
    private BottomSheetBehavior mBottomSheetBehavior;
    private View bottomSheet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        appBarLayout = findViewById(R.id.appBar_layout_details);
        collapsingToolbarLayout = findViewById(R.id.collapse_layout);
        toolbar = findViewById(R.id.toolbar_details);
        overviewTV = findViewById(R.id.overview_text_view_details);
        movieRateDetailsTV = findViewById(R.id.movie_rate_details);
        movieTitleDetailsTV = findViewById(R.id.movie_title_details);
        movieReleaseDateDetailsTV = findViewById(R.id.movie_release_date_details);
        
        backdropPathImage = findViewById(R.id.movie_poster_backdrop_details);
        posterDetailsImage = findViewById(R.id.movie_poster_image_details);
        posterDetailsImage.setClipToOutline(true);


        reviewAuthorBottomSheetTV = findViewById(R.id.review_author_TV_bottom_sheet);
        reviewContentBottomSheetTV = findViewById(R.id.review_content_TV_bottom_sheet);
        bottomSheet = findViewById(R.id.review_bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);


        trailerRecycler = findViewById(R.id.trailers_recyclerview);
        reviewsRecycler = findViewById(R.id.reviews_recycler_view);
        trailerRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        reviewsRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));




        movieId = getIntentValues("movie_id");
        setContentForViews();

        fetchTrailers();
        fetchReviews();
    }


    private void fetchTrailers()
    {
        Networking.fetchResponses(movieId, "videos", Trailers.class, new OnMovieListener<Trailers>() {
            @Override
            public void onResponse(Trailers response) {
                trailerRecycler.setAdapter(new TrailerAdapter(response.getResults(), DetailsActivity.this));
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private void fetchReviews()
    {
        Networking.fetchResponses(movieId, "reviews", Reviews.class, new OnMovieListener<Reviews>() {
            @Override
            public void onResponse(Reviews response) {
                reviewsRecycler.setAdapter(new ReviewsAdapter(response.getResults(), new OnReviewItem() {
                    @Override
                    public void onReviewItemClick(String author, String content) {

                        reviewAuthorBottomSheetTV.setText(author);
                        reviewContentBottomSheetTV.setText(content);
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                }));
            }

            @Override
            public void onError(String error) {
                Toast.makeText(DetailsActivity.this, "Error loading reviews", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*private void fetchTrailers()
    {
        Networking.fetch(getIntentValues("movie_id"),"videos" ,new OnMovieListener<Trailers>() {
            @Override
            public void onResponse(Trailers response) {
                trailerRecycler.setAdapter(new TrailerAdapter(response.getResults(), DetailsActivity.this));
            }

            @Override
            public void onError(String error) {
                Toast.makeText(DetailsActivity.this, "Error fetching trailers", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    private void setContentForViews()
    {
        movieTitleDetailsTV.setText(getIntentValues("movie_title"));
        movieRateDetailsTV.setText(getIntentValues("movie_rate"));
        movieReleaseDateDetailsTV.setText(getIntentValues("release_date"));
        overviewTV.setText(getIntentValues("overview"));
        Picasso.get().load(getIntentValues("poster_url")).into(posterDetailsImage);
        Picasso.get().load(getIntentValues("backdrop_path")).into(backdropPathImage);
        initializeCollapseLayout();

    }

    private String getIntentValues(String key)
    {
        Intent intent = getIntent();
        if(!intent.hasExtra(key))
            return "there is no data";
        return intent.getExtras().getString(key);
    }

    private void initializeCollapseLayout()
    {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int appBarScrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(appBarScrollRange == -1){
                        appBarScrollRange = appBarLayout.getTotalScrollRange();
                }
                if(appBarScrollRange + verticalOffset == 0)
                {
                    collapsingToolbarLayout.setTitle(getIntentValues("movie_title"));
                    toolbar.setVisibility(View.VISIBLE);
                    isShow = true;
                }else if(isShow){
                    collapsingToolbarLayout.setTitle(" ");
                    toolbar.setVisibility(View.INVISIBLE);
                    isShow = false;
                }
            }
        });
    }
}
