package com.dekotlinapp.InterfaceClass

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url


/**
 * Created by AMD21 on 25/5/17.
 */
interface APIService {

    @GET
    fun webServiceCall(@Url suburl: String, @QueryMap(encoded = true) param: Map<String, String>): Call<String>
}