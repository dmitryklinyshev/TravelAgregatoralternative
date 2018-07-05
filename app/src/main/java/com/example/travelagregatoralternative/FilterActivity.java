package com.example.travelagregatoralternative;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


public class FilterActivity extends AppCompatActivity {
    TextView pickedDate;
    String dateTo;
    EditText nightCount;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        pickedDate = (TextView) findViewById(R.id.pickedDate);
        pickedDate.setText("0" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + ".0" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "." + Calendar.getInstance().get(Calendar.YEAR));
        dateTo = "0" + (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1) + ".0" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "." + Calendar.getInstance().get(Calendar.YEAR);
        nightCount = (EditText) findViewById(R.id.nightCount);
        nightCount.setText("5");
    }


    public void onApply(View view) {

        Intent result = new Intent();
        result.putExtra("url", "http://search.tez-tour.com/tariffsearch/getResult" +
                "?accommodationId=1" +
                "&after=" + pickedDate.getText().toString() +
                "&before=" + dateTo +
                "&cityId=345" +
                "&currency=8390" +
                "&hotelClassBetter=true" +
                "&hotelClassId=2567" +
                "&hotelInStop=false" +
                "&locale=ru" +
                "&nightsMax=" + (Integer.parseInt(nightCount.getText().toString()) + 2) +
                "&nightsMin=" + Integer.parseInt(nightCount.getText().toString()) +
                "&noTicketsFrom=false" +
                "&noTicketsTo=false" +
                "&priceMax=1200000" +
                "&priceMin=0" +
                "&rAndBBetter=true" +
                "&rAndBId=2474" +
                getCountry() +
                "&formatResult=true" +
                "&xml=false");
        setResult(RESULT_OK, result);
        finish();
    }

    private String getCountry() {
        String s;
        switch (((EditText) findViewById(R.id.country)).getText().toString()) {
            case "Австрия":
                s = "&countryId=147573" +
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
                        "&tourId=597522";
                break;
            case "Андорра":
                s = "&countryId=257195" +
                        "&tourId=255458" +
                        "&tourId=255468" +
                        "&tourId=255470" +
                        "&tourId=255464" +
                        "&tourId=255462" +
                        "&tourId=255460";
                break;
            case "Беларусь":
            case "Болгария":
            case "Венгрия":
            case "Греция":

            case "Грузия":

            case "Доминикана":
            case "Египет":
                s = "&countryId=5732" +
                        "&tourId=416623" +
                        "&tourId=26313" +
                        "&tourId=15163" +
                        "&tourId=14355" +
                        "&tourId=111466" +
                        "&tourId=14353" +
                        "&tourId=14354" +
                        "&tourId=54766" +
                        "&tourId=5734" +
                        "&tourId=5735" +
                        "&tourId=14351";
                break;
            case "Израиль":
            case "Индонезия":
            case "Испания":

            case "Италия":

            case "Кипр":
            case "Китай":
            case "Куба":
            case "Латвия":
            case "Литва":
            case "Маврикий":
            case "Мальдивы":
            case "Мексика":
            case "ОАЭ":
            case "Португалия":

            case "Россия":
            case "Сейшелы":
            case "Таиланд":

            case "Турция":

            case "Франция":

            case "Чехия":

            case "Шри-Ланка":
            case "Эстония":
            default:
                s = "&countryId=147573" +
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
                        "&tourId=597522";
                break;
        }
        return s;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 1:
                DatePickerDialog tpd = new DatePickerDialog(this);
                tpd.setOnDateSetListener(myCallBack);
                return tpd;
            default:
                return super.onCreateDialog(id);
        }
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            pickedDate.setText("0" + dayOfMonth + ".0" + (monthOfYear + 1) + "." + year);
            dateTo = "0" + (dayOfMonth + 1) + ".0" + (monthOfYear + 1) + "." + year;
        }
    };

    public void setFromDate(View view) {
        showDialog(1);
    }
}
