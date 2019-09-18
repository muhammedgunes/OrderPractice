package com.gunes.orderpractice.network;


import com.gunes.orderpractice.Data.Order;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RestInterface {

    @GET(".")
    Call<ArrayList<Order>> getOrders();

}
