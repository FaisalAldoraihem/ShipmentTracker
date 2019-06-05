package com.faisal.shipmenttracker.ViewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.faisal.shipmenttracker.POJO.Shipment;
import com.faisal.shipmenttracker.UI.MainActivity;
import com.faisal.shipmenttracker.Utils.API;
import com.faisal.shipmenttracker.Utils.NetworkClient;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ShipmentsViewModel extends ViewModel {
    private final Retrofit retrofit = NetworkClient.getRetrofitClient();
    private final API api = retrofit.create(API.class);

    private final MutableLiveData<Shipment> mShipments = new MutableLiveData<>();

    public ShipmentsViewModel() {
        fetchShipments();
    }

    public void fetchShipments() {
        Call<Shipment> post = api.getShipments(MainActivity.id);
        post.enqueue(new Callback<Shipment>() {
            @Override
            public void onResponse(@NotNull Call<Shipment> call, @NotNull Response<Shipment> response) {
                if (response.body() != null) {
                    mShipments.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<Shipment> call, @NotNull Throwable t) {

            }
        });

    }

    public LiveData<Shipment> getmShipments() {
        return mShipments;
    }

}
