package com.example.testjsonparse;

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
            "?accommodationId=2" +
            "&after=01.07.2018" +
            "&before=07.07.2018" +
            "&cityId=345" +
            "&countryId=147573" +
            "&currency=5561" +
            "&hotelClassBetter=true" +
            "&hotelClassId=2569" +
            "&hotelInStop=false" +
            "&locale=ru" +
            "&nightsMax=14" +
            "&nightsMin=9" +
            "&noTicketsFrom=false" +
            "&noTicketsTo=false" +
            "&priceMax=120000" +
            "&priceMin=0" +
            "&rAndBBetter=true" +
            "&rAndBId=2424" +
            "&tourId=3024267" +
            "&formatResult=true" +
            "&xml=false";



    public JsonResultClient(Receiver receiver) {
        this.o = new OkHttpClient();
        this.receiver = receiver;
    }

    public JsonResultClient(Receiver receiver, String url) {
        this.o = new OkHttpClient();
        this.receiver = receiver;
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

                    String hotelRow = h.get(1).toString();
                    String hotel = hotelRow.substring(0, hotelRow.length() - 4);
                    int stars = Integer.parseInt(hotelRow.substring(hotelRow.length() - 3, hotelRow.length() - 2));
                    int price = Integer.parseInt(p.get("total").toString());
                    String image = h.get(2).toString();


                    result.add(new Tour(hotel, image, price, stars));
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
        if (result != null || result.size() == 0) {
            receiver.OnReceiveData(result);
        } else {
            receiver.OnReceiveError(s);
        }
    }
}
