package com.faisal.shipmenttracker.Utils;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.faisal.shipmenttracker.Database.ArchiveDatabase;
import com.faisal.shipmenttracker.Database.ShipmentEntry;
import com.faisal.shipmenttracker.POJO.Shipment;
import com.faisal.shipmenttracker.Shipment.Tracking;
import com.faisal.shipmenttracker.ViewModels.ShipmentsViewModel;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShipmentsUtils extends AppCompatActivity {
    private Retrofit retrofit = NetworkClient.getRetrofitClient();
    private API api = retrofit.create(API.class);
    private ShipmentsViewModel mShipmentsViewModel;
    private ArchiveDatabase dbM;


    public void postTracking(Tracking info, Context context) {
        Call<JSONObject> post = api.postTracking(info);

        post.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, @NotNull Response<JSONObject> response) {
                if (response.errorBody() != null) {
                    Toast.makeText(context, "Tracking Already Exsists", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {

            }
        });

    }


    public Shipment getTracking(String slug, String tracking) {

        Call<Shipment> post = api.getShipment(slug, tracking);
        final Shipment[] shipment = new Shipment[1];

        post.enqueue(new Callback<Shipment>() {
            @Override
            public void onResponse(Call<Shipment> call, Response<Shipment> response) {
                if (response.body() != null) {
                    shipment[0] = response.body();
                }
            }

            @Override
            public void onFailure(Call<Shipment> call, Throwable t) {

            }
        });

        return shipment[0];
    }

    public void deleteShipment(String slug, String tracking){
        Call<JSONObject> post = api.deleteTracking(slug,tracking);

        post.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {

            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {

            }
        });

    }

    public void addToDatabase(ShipmentEntry entry,Context context){
        dbM = ArchiveDatabase.getInstance(context);
        AppExecutors.getInstance().diskIO().execute(()-> {
            dbM.shipmentDao().insertShipment(entry);
        });
    }

}
