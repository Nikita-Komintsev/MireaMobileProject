package com.mirea.komintsev.mireaproject.ui.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("heroes.php")
    Call<Heroes> getHeroes();
}
