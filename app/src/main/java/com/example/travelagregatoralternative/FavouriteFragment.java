package com.example.travelagregatoralternative;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;


public class FavouriteFragment extends Fragment implements Receiver {

    private android.content.Context mContext;
    private ProgressBar mProgressBar;

    public static FavouriteFragment newInstance(){
        FavouriteFragment fragment = new FavouriteFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        new JsonResultClient(this).execute();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view =  inflater.inflate(R.layout.favourite_fragment,container,false);

        mProgressBar = view.findViewById(R.id.progress_bar2);
        mProgressBar.setVisibility(View.VISIBLE);
        return view;

    }



    @Override
    public void OnReceiveData(ArrayList<Tour> a) {
        if (a != null) {
            RecyclerView rv = (RecyclerView) getView().findViewById(R.id.recycler_viewfav);
            rv.setLayoutManager(new LinearLayoutManager(mContext));
//            rv.setAdapter(new TourAdapter(a));

            mProgressBar.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    public void OnReceiveError(String s) {

    }

    @Override
    public int onTourClicked() {
        return 0;
    }
}
