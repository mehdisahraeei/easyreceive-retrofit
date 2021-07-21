package com.mahdi.receiveretrofit.api;


import com.mahdi.receiveretrofit.recyclerview.model.Model;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("filefetch.php")
    Call<List<Model>> getListCall();


}
