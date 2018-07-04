package com.example.travelagregatoralternative;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class FilterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        showDialog(1);
    }


    public void onApply(View view) {

        Intent result = new Intent();
        result.putExtra("url", "http://search.tez-tour.com/tariffsearch/getResult" +
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
                "&xml=false");
        setResult(RESULT_OK, result);
        finish();
    }


    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 1:
                DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, 2018, 8, 1);
                return tpd;
            default:
                return super.onCreateDialog(id);
        }
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        }
    };

}
