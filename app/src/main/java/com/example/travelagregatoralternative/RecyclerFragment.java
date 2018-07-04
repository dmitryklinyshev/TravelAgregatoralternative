package com.example.travelagregatoralternative;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;


public class RecyclerFragment extends Fragment implements Receiver, ITourActions {

    private String defaultUrl = "http://search.tez-tour.com/tariffsearch/getResult" +
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


    private ProgressBar mProgressBar;
    JsonResultClient jsonResultClient;
    private Toolbar toolbar;

    public static RecyclerFragment newInstance(String url) {
        RecyclerFragment mFragment = new RecyclerFragment();

        Bundle args = new Bundle();
        args.putString("url", url);
        mFragment.setArguments(args);

        return mFragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = getArguments().getString("url", defaultUrl);
        jsonResultClient = new JsonResultClient(this);
        jsonResultClient.setUrl(url);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.recycler_layout, container, false);

        jsonResultClient.execute();

        mProgressBar = view.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.VISIBLE);

        setHasOptionsMenu(true);

        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Главная");
        toolbar.inflateMenu(R.menu.tour_list_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_filter:
                        ((MainActivity) getActivity()).onFilterButtonClick();
                    default:
                        return false;
                }
            }
        });


        //
//        fragment = ItemFragment.newInstance();
//        mImageView = view.findViewById(R.id.CardImageView);
//        mImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//
//                fragmentTransaction.replace(R.id.frame_layout, fragment);
//
//                fragmentTransaction.commit();
//            }
//        });
        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        jsonResultClient.cancel(true);
    }

    @Override
    public void OnReceiveData(ArrayList<Tour> a) {

        RecyclerView rv = (RecyclerView) getView().findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setAdapter(new TourAdapter(a, this));

        mProgressBar.setVisibility(ProgressBar.INVISIBLE);



    }


    @Override
    public void OnReceiveError(String s) {
//            ((TextView)getView().findViewById(R.id.ErrorLogTextView)).setText(s);
    }


    @Override
    public void onTourClicked(int id) {

    }
}




