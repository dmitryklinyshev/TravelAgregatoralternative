package com.example.travelagregatoralternative;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ItemFragment extends Fragment {

    public static ItemFragment newInstance(){
        ItemFragment fragment = new ItemFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedIstanceState){
        final View view =  layoutInflater.inflate(R.layout.item_section,container,false);


        return view;
    }
}
