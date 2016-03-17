package com.example.bjornnyberg.myapplication.krisinfo;

import android.os.AsyncTask;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Collections;
import java.util.List;

/**
 * Created by bjornnyberg on 17/03/16.
 */
public class RetrofitTest extends AsyncTask<Void, Void, List<CapMessage>> {

    public KrisInfoResponse delegate;

    public RetrofitTest(KrisInfoResponse kris) {
        delegate = kris;
    }

    public List<CapMessage> getKrisInfo() throws IOException {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setDateFormat(DateFormat.LONG)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.krisinformation.se/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        KrisInformationService krisInformationService = retrofit.create(KrisInformationService.class);

        Call<List<CapMessage>> call = krisInformationService.getInformation();
        List<CapMessage> krisInfos= call.execute().body();
        return krisInfos;
    }

    @Override
    protected List<CapMessage> doInBackground(Void... params) {
        try {
            return getKrisInfo();
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }


    protected void onPostExecute(List<CapMessage> result) {
        delegate.processFinish(result);
    }
}
