package com.example.workingwithapis.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workingwithapis.R;
import com.example.workingwithapis.model.TrailerResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerHolder> {
    private List<TrailerResult> trailerList;
    private Context context;

    public TrailerAdapter(List<TrailerResult> trailerList, Context context) {
        this.trailerList = trailerList;
        this.context = context;
    }

    @NonNull
    @Override
    public TrailerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer_item, parent, false);
        context = parent.getContext();
        return new TrailerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerHolder holder, int position) {

        holder.bindViews(trailerList.get(position));
    }

    @Override
    public int getItemCount() {
        return trailerList.size();
    }

    public class TrailerHolder extends RecyclerView.ViewHolder {
        private ImageView trailerimage;
        private View mView;

        private TrailerHolder(@NonNull View itemView) {
            super(itemView);

            trailerimage = itemView.findViewById(R.id.trailer_image);
            this.mView = itemView;

        }
        private void bindViews(final TrailerResult model)
        {
            final String trailerKey = model.getKey();
            Picasso.get().load("https://img.youtube.com/vi/"+trailerKey+"/0.jpg").into(trailerimage);

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + trailerKey));
                    intent.putExtra("trailer_id", model.getId());
                    context.startActivity(intent);

                    Toast.makeText(context, "trailer" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
