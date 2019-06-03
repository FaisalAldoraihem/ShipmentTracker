package com.faisal.shipmenttracker.Utils;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.faisal.shipmenttracker.Database.ArchiveDatabase;
import com.faisal.shipmenttracker.Database.ShipmentEntry;
import com.faisal.shipmenttracker.Shipment.Tracking;
import com.faisal.shipmenttracker.UI.ShipmentsFragment;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.parceler.Parcels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import timber.log.Timber;

public class ShipmentsUtils extends IntentService {
    public static final String ACTION_ADD_TOO_DATABASE = "com.faisal.shipmenttracker.action_add_too_database";
    public static final String ACTION_REMOVE_FROM_DATABASE = "com.faisal.shipmenttracker.action_remove_from_database";
    public static final String ACTION_ADD_TOO_TRACKING = "com.faisal.shipmenttracker.action_add_too_tracking";
    public static final String ACTION_REMOVE_FROM_TRACKING = "com.faisal.shipmenttracker.action_remove_from_tracking";
    public static final String TRACKING_OBJECT = "trackingObj";
    public static final String TRACKING = "tracking";
    public static final String SLUG = "slug";
    public static final String SHIPMENT_OBJECT = "shipmentObj";

    private Retrofit retrofit = NetworkClient.getRetrofitClient();
    private API api = retrofit.create(API.class);
    private ArchiveDatabase dbM;


    public ShipmentsUtils() {
        super("ShipmentsUtils");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent != null){
            final String action = intent.getAction();
            switch (action){
                case ACTION_ADD_TOO_DATABASE:
                    addToDatabase(Parcels.unwrap(intent.getParcelableExtra(SHIPMENT_OBJECT)));
                    break;
                case ACTION_REMOVE_FROM_DATABASE:
                    deleteFromDatabase(Parcels.unwrap(intent.getParcelableExtra(SHIPMENT_OBJECT)));
                    break;

                case ACTION_ADD_TOO_TRACKING:
                    postTracking(Parcels.unwrap(intent.getParcelableExtra(TRACKING_OBJECT)));
                    break;

                case ACTION_REMOVE_FROM_TRACKING:
                    String slug = intent.getStringExtra(SLUG);
                    String tracking = intent.getStringExtra(TRACKING);
                    deleteShipment(slug,tracking);
                    break;
            }
        }
    }

    public void postTracking(Tracking info) {
        Call<JSONObject> post = api.postTracking(info);
        post.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(@NotNull Call<JSONObject> call, @NotNull Response<JSONObject> response) {
                if (response.errorBody() != null) {
                    Toast.makeText(getApplicationContext(), "Tracking Already Exists", Toast.LENGTH_LONG).show();
                }else{
                    ShipmentsFragment.refresh();
                }
            }

            @Override
            public void onFailure(@NotNull Call<JSONObject> call, @NotNull Throwable t) {

            }
        });

    }

    public void deleteShipment(String slug, String tracking) {
        Call<JSONObject> post = api.deleteTracking(slug, tracking);

        post.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(@NotNull Call<JSONObject> call, @NotNull Response<JSONObject> response) {
                ShipmentsFragment.refresh();
            }

            @Override
            public void onFailure(@NotNull Call<JSONObject> call, Throwable t) {

            }
        });


    }

    public void addToDatabase(ShipmentEntry entry) {
        dbM = ArchiveDatabase.getInstance(this);
        AppExecutors.getInstance().diskIO().execute(() -> {
            dbM.shipmentDao().insertShipment(entry);
        });
    }

    public void deleteFromDatabase(ShipmentEntry entry) {
        dbM = ArchiveDatabase.getInstance(this);
        Timber.e("Yes");
        AppExecutors.getInstance().diskIO().execute(() -> {
            dbM.shipmentDao().deleteShipment(entry);
        });
    }
}
