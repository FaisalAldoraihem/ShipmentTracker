package com.faisal.shipmenttracker.ViewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.faisal.shipmenttracker.POJO.Shipment;
import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.UI.MainActivity;
import com.faisal.shipmenttracker.Utils.API;
import com.faisal.shipmenttracker.Utils.NetworkClient;
import com.faisal.shipmenttracker.Utils.ShipmentsUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ShipmentsViewModel extends ViewModel {
    private Retrofit retrofit = NetworkClient.getRetrofitClient();
    private API api = retrofit.create(API.class);

    private final MutableLiveData<Shipment> mShipments = new MutableLiveData<>();

    public ShipmentsViewModel() {
        fetchShipments();
    }

    public void fetchShipments() {
        Call<Shipment> post = api.getShipments(MainActivity.id);
        post.enqueue(new Callback<Shipment>() {
            @Override
            public void onResponse(Call<Shipment> call, Response<Shipment> response) {
                if (response.body() != null) {
                    mShipments.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Shipment> call, Throwable t) {

            }
        });

    }

    public LiveData<Shipment> getmShipments() {
        return mShipments;
    }

}
