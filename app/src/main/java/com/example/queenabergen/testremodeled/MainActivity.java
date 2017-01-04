package com.example.queenabergen.testremodeled;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        fragmenttransaction.replace(R.id.maincontainer, new NewFragment()).commit();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        Call<Example> call = apiService.getAPIinfo();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Success :" + response.body().getAnimals().get(0).getName());
                } else {
                    Log.d(TAG, "Error: Something Happened" + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }


}
