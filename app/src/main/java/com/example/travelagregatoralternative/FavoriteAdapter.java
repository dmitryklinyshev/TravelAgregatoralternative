package com.example.travelagregatoralternative;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private ArrayList<Tour> tourList;

    public FavoriteAdapter(ArrayList<Tour> tourList) {
        this.tourList = tourList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup vg, int i) {
        View v = LayoutInflater.from(vg.getContext()).inflate(R.layout.item_layout, vg, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bindItemToView(tourList.get(position));

    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView hotel;
        private ImageView image;
        private RatingBar stars;
        private TextView price;
        private TextView date;
        private ImageButton star;

        public ViewHolder(View itemView) {
            super(itemView);
            hotel = (TextView) itemView.findViewById(R.id.CardHotelView);
            image = (ImageView) itemView.findViewById(R.id.CardImageView);
            stars = (RatingBar) itemView.findViewById(R.id.CardRatingBar);
            price = (TextView) itemView.findViewById(R.id.CardPriceView);
            date = (TextView) itemView.findViewById(R.id.CardDateView);
            star = (ImageButton) itemView.findViewById(R.id.CardStarImageButton);

        }

        public void bindItemToView(final Tour tour) {
            hotel.setText(tour.getHotel());
            if (tour.getImage().isEmpty()) {
                Picasso.get().load("https://s.tez-tour.com/hotel/2250/express_1735_small.jpg")
                        .resize(100, 100)
                        .into(image);
            } else {
                Picasso.get().load(tour.getImage())
                        .resize(100, 100)
                        .into(image);
            }
            stars.setNumStars(tour.getStars());
            price.setText(tour.getPrice() + "\u20BD");
            date.setText(tour.getDateFrom() + " - " + tour.getDateTo());
            star.setVisibility(View.INVISIBLE);
        }
    }

}
