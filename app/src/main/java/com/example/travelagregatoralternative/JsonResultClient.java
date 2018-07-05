package com.example.travelagregatoralternative;

import android.os.AsyncTask;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class JsonResultClient extends AsyncTask<Void, Void, Void> {
    String s;
    ArrayList<Tour> result = null;
    Tour t;
    String str;
    OkHttpClient o;
    Receiver receiver;
    String url = "http://search.tez-tour.com/tariffsearch/getResult" +
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



    public JsonResultClient(Receiver receiver) {
        this.o = new OkHttpClient();
        this.receiver = receiver;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    protected Void doInBackground(Void... voids) {


        Request request = new Request.Builder()
                .url(url)
                .build();


        try {
            Response response = o.newCall(request).execute();
            s = response.body().string();
            JSONObject root = new JSONObject(s);
            if((Boolean) root.get("success")){
                result = new ArrayList<Tour>();
                JSONArray data = new JSONArray(root.get("data").toString());

                for(int i = 0; i < data.length(); i++) {

                    JSONArray tour = new JSONArray(data.get(i).toString());

                    JSONArray h = new JSONArray(tour.get(6).toString());
                    JSONObject p = new JSONObject(tour.get(10).toString());

                    String dateFrom = tour.getString(0);
                    String dateTo = tour.getString(4);

                    String hotelRow = h.getString(1);
                    String hotel = hotelRow.substring(0, hotelRow.length() - 4);
                    int stars = Integer.parseInt(hotelRow.substring(hotelRow.length() - 4, hotelRow.length() - 2).replaceAll("\\D+",""));
                    int price = Integer.parseInt(p.get("total").toString());
                    String image = h.getString(2);


                    result.add(new Tour(hotel, image, price, stars, dateFrom, dateTo));
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (result == null
//                || result.size() == 0
                ) {
            receiver.OnReceiveError(s);

        } else {
            receiver.OnReceiveData(result);

        }
    }
}
