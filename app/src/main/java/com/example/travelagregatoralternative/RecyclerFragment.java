package com.example.travelagregatoralternative;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import in.ishankhanna.tinglingsquares.TinglingSquaresView;

public class RecyclerFragment extends Fragment implements Receiver, ITourActions {
    private Context mContext;
    private ProgressBar mProgressBar;
    private ImageView mImageView;
    Fragment fragment;


    public static RecyclerFragment newInstance() {
        RecyclerFragment mFragment = new RecyclerFragment();
        return mFragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new JsonResultClient(this).execute();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.recycler_layout, container, false);


        mProgressBar = view.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.VISIBLE);
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
    public void OnReceiveData(ArrayList<Tour> a) {


        if (a != null) {
            RecyclerView rv = (RecyclerView) getView().findViewById(R.id.recycler_view);
            rv.setLayoutManager(new LinearLayoutManager(mContext));
//            rv.setAdapter(new TourAdapter(a));

            mProgressBar.setVisibility(ProgressBar.INVISIBLE);


        }
    }


    @Override
    public void OnReceiveError(String s) {
//            ((TextView)getView().findViewById(R.id.ErrorTextView)).setText(s);
    }

    @Override
    public int onTourClicked() {
        return 0;
    }

    @Override
    public void onTourClicked(int id) {

    }
}




