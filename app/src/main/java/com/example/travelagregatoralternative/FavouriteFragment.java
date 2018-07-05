package com.example.travelagregatoralternative;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;


public class FavouriteFragment extends Fragment {

    private android.content.Context mContext;
    private ProgressBar mProgressBar;

    public static FavouriteFragment newInstance(){
        FavouriteFragment fragment = new FavouriteFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view =  inflater.inflate(R.layout.favourite_fragment,container,false);

        mProgressBar = view.findViewById(R.id.progress_bar2);
        mProgressBar.setVisibility(View.INVISIBLE);

        ((Toolbar) view.findViewById(R.id.toolbar)).setTitle("Избранное");

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_viewfav);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        ArrayList<Tour> tourArrayList = ((MainActivity) getActivity()).getTourArrayList();
        rv.setAdapter(new FavoriteAdapter(tourArrayList));

        return view;

    }



}
