package com.faisal.shipmenttracker.Utils;

import com.faisal.shipmenttracker.POJO.Shipment;
import com.faisal.shipmenttracker.POJO.ShipmentInfo;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {

    String api = "be42fb27-d087-41a6-8ac2-9645698b98ff";

    @Headers({
            "Content - Type:application/json",
            "Trackingmore-Api-Key:api" + api
    })
    @POST("/post")
    Call<ShipmentInfo> postTracking(@Body ShipmentInfo info);

    @Headers({
            "Content - Type:application/json",
            "Trackingmore-Api-Key:" + api
    })
    @GET("/{carrier_code}/{tracking_number}")
    Call<Shipment> getShipment(@Path("carrier_code") String carrier,
                               @Path("tracking_number") String tracking);

    @Headers({
            "Content - Type:application/json",
            "Trackingmore-Api-Key:" + api
    })
    @GET("get?page=1&limit=25&created_at_min=1441314361&created_at_max=1446949161")
    Call<Shipment> getShipments();

    @Headers({
            "Content - Type:application/json",
            "Trackingmore-Api-Key:" + api
    })
    @DELETE("/{carrier_code}/{tracking_number}")
    Call<ShipmentInfo> deleteTracking(@Path("carrier_code") String carrier,
                                      @Path("tracking_number") String tracking);

}

