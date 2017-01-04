package com.example.queenabergen.testremodeled;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by queenabergen on 1/3/17.
 */

public interface APIService {
    @GET(" ")
    Call<Example> getAPIinfo();

}
