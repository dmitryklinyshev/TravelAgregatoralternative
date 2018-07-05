package com.example.travelagregatoralternative;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DreamFragment extends Fragment {
    private ArrayAdapter adapter;
    private Spinner spinner;
    private Object activity;

    public static DreamFragment newInstance() {
        DreamFragment fragment = new DreamFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dream_fragment, container, false);

        ((Toolbar) rootView.findViewById(R.id.toolbar)).setTitle("Хочу быть там");
        initViews(rootView);
        initSpinner();

        return rootView;
    }

    private void initViews(View rootView) {
        spinner = rootView.findViewById(R.id.spinner);
    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getContext(),
                        R.array.planets_array,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "It`s worked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}





