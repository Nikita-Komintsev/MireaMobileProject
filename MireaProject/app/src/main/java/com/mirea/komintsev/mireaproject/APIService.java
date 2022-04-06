package com.mirea.komintsev.mireaproject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("heroes.php")
    Call<Heroes> getHeroes();
}
