package com.example.workingwithapis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.workingwithapis.activity.DetailsActivity;
import com.example.workingwithapis.adapter.TrailerAdapter;
import com.example.workingwithapis.api.Networking;
import com.example.workingwithapis.callback.OnTrailerListener;
import com.example.workingwithapis.model.Trailers;

public class DetailsTemp extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
     //   recyclerView = findViewById(R.id.recycler_view);

      //  recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
     //   fetchTrailers();
    }

  /*  private void fetchTrailers()
    {
        Networking.fetchTrailers(getIntentValues("movie_id"), new OnTrailerListener() {
            @Override
            public void onResponse(Trailers response) {
                recyclerView.setAdapter(new TrailerAdapter(response.getResults(), DetailsTemp.this));
            }

            @Override
            public void onError(String error) {
                Toast.makeText(DetailsTemp.this, "Error fetching trailers", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String getIntentValues(String key)
    {
        Intent intent = getIntent();
        if(!intent.hasExtra(key))
            return "there is no data";
        return intent.getExtras().getString(key);
    }
*/
}
