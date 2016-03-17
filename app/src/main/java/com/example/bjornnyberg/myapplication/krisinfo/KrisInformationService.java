package com.example.bjornnyberg.myapplication.krisinfo;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Created by bjornnyberg on 17/03/16.
 */
public interface KrisInformationService {
    @GET("v1/capmessage?format=json")
    Call<List<CapMessage>> getInformation();
}
