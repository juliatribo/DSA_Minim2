package com.example.loginpage;

import com.example.loginpage.models.Badges;
import com.example.loginpage.models.Usuario;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Authentication {
    @POST("login/")
    Call<ResponseBody>loginUser(@Body Usuario user);

    @POST("signup/")
    Call<ResponseBody>signUpUser(@Body Usuario user);

    @GET("{id}/")
    Call<Usuario>getUser(@Path("id") String id);

    @GET("badges/")
    Call<List<Badges>>getBadges();
}

