package com.example.testjsonparse;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.ViewHolder> {

    ArrayList<Tour> a = null;

    public TourAdapter(ArrayList<Tour> a) {
        this.a = a;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup vg, int i) {
        View v = LayoutInflater.from(vg.getContext()).inflate(R.layout.new_item_layout, vg, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder vh, int i) {
        Tour t = a.get(i);
        vh.hotel.setText(t.getHotel());
        Picasso.get().load(t.getImage()).into(vh.image);
        vh.stars.setNumStars(t.getStars());
    }

    @Override
    public int getItemCount() {
        return a.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView hotel;
        private ImageView image;
        private RatingBar stars;

        public ViewHolder(View itemView) {
            super(itemView);
            hotel = (TextView) itemView.findViewById(R.id.CardTextView);
            image = (ImageView) itemView.findViewById(R.id.CardImageView);
            stars = (RatingBar) itemView.findViewById(R.id.CardRatingBar);
        }
    }

}
