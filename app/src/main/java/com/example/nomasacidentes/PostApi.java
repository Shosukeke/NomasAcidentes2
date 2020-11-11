package com.example.nomasacidentes;



import com.example.nomasacidentes.model.AseAccidente;
import com.example.nomasacidentes.model.Fiscalizacion;
import com.example.nomasacidentes.model.Login;
import com.example.nomasacidentes.model.Mejora;
import com.example.nomasacidentes.model.User;
import com.example.nomasacidentes.model.solicitudesCbox;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface PostApi {


    String root = "http://192.168.43.21:8000/";

    String API_URL = root + "api/v1/";




    @POST("accounts/login/")
    Call<User> login(@Body Login login);

    @POST("accounts/register/")
    Call<User> registrationUser(@Body User userModel);

    @POST("AsesoriaFis/")
    Call<Fiscalizacion> registrationFis(@Body Fiscalizacion fisModel);

    @POST("AsesoriaAcci/")
    Call<AseAccidente> registrationAcc(@Body AseAccidente AcciModel);

    @GET("SoliCbox/")
    Call<List<solicitudesCbox>> getSoliFiList();

    @GET("listAcci/")
    Call<List<AseAccidente>> getAcciList();

    @GET("listFisca/")
    Call<List<Fiscalizacion>> getFiscaList();

    @POST("Solicitudes/")
    Call<Solicitudes> registrationSoli(@Body Solicitudes soliModel);

    @GET("Mejoras/")
    Call<List<Mejora>> getMejoras();

    @POST("Mejoras/")
    Call<Mejora> registrarMejora(@Body Mejora MejoraModel);

}