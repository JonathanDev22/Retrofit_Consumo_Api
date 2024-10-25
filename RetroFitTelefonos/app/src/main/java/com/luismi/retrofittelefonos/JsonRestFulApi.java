package com.luismi.retrofittelefonos;

//  Listar todos los objetos con un RecyclerView
//  Mostrar un objeto por el ID
//  Subir un objeto usando un formulario
//  Actualizar un objeto
//  Borrar un objeto

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface JsonRestFulApi {
    @GET("objects")
    Call<List<Phone>> getAllPhone();

    @GET("/objects/{id}")
    Call<Phone> getIdPhone(@Path("id") String id);

    @POST("objects")
    Call<Phone> addPhone(@Body Phone newPhone);

    @PUT("objects/{id}")
    Call<Phone> updatePhone(@Path("id") String id, @Body Phone phone);

    @PATCH("objects/{id}")
    Call<Phone> partialUpdatePhone(@Path("id") String id, @Body Phone phone);

    @DELETE("objets/{id}")
    Call<Phone> deletePhone(@Path("id") String id);

}
