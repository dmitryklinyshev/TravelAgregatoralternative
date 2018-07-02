package com.example.travelagregatoralternative;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

public class TestFr extends Fragment {
    public static TestFr newInstance(){
        TestFr fragment = new TestFr();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup contanter, Bundle savedInstanceState){
        return inflater.inflate(R.layout.item_layout,contanter,false);
    }
}
