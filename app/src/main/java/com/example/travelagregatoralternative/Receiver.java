package com.example.travelagregatoralternative;

import java.util.ArrayList;

public interface Receiver {

    void OnReceiveData(ArrayList<Tour> a);
    void OnReceiveError(String s);

}
