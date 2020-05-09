package com.example.workingwithapis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workingwithapis.R;
import com.example.workingwithapis.callback.OnReviewItem;
import com.example.workingwithapis.fragment.ModalBottomSheet;
import com.example.workingwithapis.model.ReviewResult;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsHolder> {
    private List<ReviewResult> reviewsList;
    private Context context;
    private OnReviewItem onReviewItem;

    public ReviewsAdapter(List<ReviewResult> reviewsList, OnReviewItem onReviewItem) {
        this.reviewsList = reviewsList;
        this.onReviewItem = onReviewItem;
    }

    @NonNull
    @Override
    public ReviewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item, parent, false);

        context = parent.getContext();
        return new ReviewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsHolder holder, int position) {
        holder.bindViews(reviewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return reviewsList.size();
    }

    public class ReviewsHolder extends RecyclerView.ViewHolder {

        private TextView reviewAuthor, reviewContent, reviewAuthorBottomSheet, reviewContentBottomSheet;
        private BottomSheetBehavior mBottomSheetBehavior;
        private View bottomSheet;


        private ReviewsHolder(@NonNull View itemView) {
            super(itemView);
            reviewAuthor = itemView.findViewById(R.id.review_author_TV);
            reviewContent = itemView.findViewById(R.id.review_content_TV);
          /*  reviewAuthorBottomSheet = itemView.findViewById(R.id.review_author_TV_bottom_sheet);
            reviewContentBottomSheet = itemView.findViewById(R.id.review_content_TV_bottom_sheet);
            bottomSheet = itemView.findViewById(R.id.review_bottom_sheet);
            mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        */}

        private void bindViews(final ReviewResult model)
        {
            reviewAuthor.setText(model.getAuthor());
            reviewContent.setText(model.getContent());
          /*  reviewAuthorBottomSheet.setText(model.getAuthor());
            reviewContentBottomSheet.setText(model.getContent());
*/
          itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  onReviewItem.onReviewItemClick(model.getAuthor(), model.getContent());
              }
          });
         /*   itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    reviewAuthorBottomSheet.setText(model.getAuthor());
                    reviewContentBottomSheet.setText(model.getContent());
                    Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
                }
            });*/
        }

    }
}
