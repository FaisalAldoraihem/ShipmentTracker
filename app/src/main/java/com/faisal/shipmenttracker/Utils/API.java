package com.faisal.shipmenttracker.Utils;

import com.faisal.shipmenttracker.POJO.Shipment;


import org.json.JSONObject;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    //add you api here
    String api = "";


    @Headers({
            "Content-Type:application/json",
            "aftership-api-key:" + api
    })
    @POST("trackings")
    Call<JSONObject> postTracking(@Body com.faisal.shipmenttracker.Shipment.Tracking info);

    @Headers({
            "Content-Type:application/json",
            "aftership-api-key:" + api
    })
    @GET("trackings/{slug}/{tracking_number}")
    Call<Shipment> getShipment(@Path("slug") String carrier,
                               @Path("tracking_number") String tracking);

    @Headers({
            "Content-Type:application/json",
            "aftership-api-key:" + api
    })
    @GET("trackings")
    Call<Shipment> getShipments(@Query("keyword") String id);

    @Headers({
            "Content-Type:application/json",
            "aftership-api-key:" + api
    })
    @DELETE("trackings/{slug}/{tracking_number}")
    Call<JSONObject> deleteTracking(@Path("slug") String carrier,
                                  @Path("tracking_number") String tracking);

}

