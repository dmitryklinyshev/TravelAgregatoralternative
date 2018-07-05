package com.example.travelagregatoralternative;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.travelagregatoralternative.R;
import com.example.travelagregatoralternative.Receiver;
import com.example.travelagregatoralternative.Tour;
import com.example.travelagregatoralternative.TourAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements ITourActions {
    private final int FILTER_CODE = 0;
    private ArrayList<Tour> tourArrayList;
    private String url = "http://search.tez-tour.com/tariffsearch/getResult" +
            "?accommodationId=1" +
            "&after=02.08.2018" +
            "&before=07.08.2018" +
            "&cityId=345" +
            "&countryId=147573" +
            "&currency=8390" +
            "&hotelClassBetter=true" +
            "&hotelClassId=2567" +
            "&hotelInStop=false" +
            "&locale=ru" +
            "&nightsMax=14" +
            "&nightsMin=9" +
            "&noTicketsFrom=false" +
            "&noTicketsTo=false" +
            "&priceMax=1200000" +
            "&priceMin=0" +
            "&rAndBBetter=true" +
            "&rAndBId=2474" +
            "&tourId=308122" +
            "&tourId=3024267" +
            "&tourId=147579" +
            "&tourId=353869" +
            "&tourId=320460" +
            "&tourId=3024283" +
            "&tourId=3024283" +
            "&tourId=3024262" +
            "&tourId=253138" +
            "&tourId=3026464" +
            "&tourId=3024262" +
            "&tourId=293808" +
            "&tourId=469713" +
            "&tourId=3024272" +
            "&tourId=314293" +
            "&tourId=467029" +
            "&tourId=348518" +
            "&tourId=544505" +
            "&tourId=3024262" +
            "&tourId=348518" +
            "&tourId=384331" +
            "&tourId=594027" +
            "&tourId=544505" +
            "&tourId=3025654" +
            "&tourId=3024262" +
            "&tourId=258494" +
            "&tourId=597522" +
            "&formatResult=true" +
            "&xml=false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tourArrayList = new ArrayList<Tour>();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                android.support.v4.app.Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.favourite:
                        selectedFragment = FavouriteFragment.newInstance();
                        break;
                    case R.id.main:
                        selectedFragment = RecyclerFragment.newInstance(url);
                        break;
                    case R.id.dream:
                        selectedFragment = DreamFragment.newInstance();
                        break;
                }
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, selectedFragment);
                fragmentTransaction.commit();
                return true;
            }

        });


        //Manually displaying the first fragment - one time only
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, RecyclerFragment.newInstance(url));
        navigation.setSelectedItemId(R.id.main);
        transaction.commit();
    }


    public void onFilterButtonClick() {
        Intent intent = new Intent(this, FilterActivity.class);
        startActivityForResult(intent, FILTER_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case FILTER_CODE:
                if (resultCode == RESULT_OK) {
                    this.url = data.getStringExtra("url");
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, RecyclerFragment.newInstance(url)).commit();
                }
                break;
        }
    }

    public ArrayList<Tour> getTourArrayList() {
        return tourArrayList;
    }

    @Override
    public void onTourClicked(Tour tour) {
        tourArrayList.add(tour);
    }
}



