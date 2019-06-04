package com.faisal.shipmenttracker.Utils;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.faisal.shipmenttracker.Database.ArchiveDatabase;
import com.faisal.shipmenttracker.Database.ShipmentEntry;
import com.faisal.shipmenttracker.POJO.Shipment;
import com.faisal.shipmenttracker.Shipment.Tracking;
import com.faisal.shipmenttracker.ShipmentWidget;
import com.faisal.shipmenttracker.UI.MainActivity;
import com.faisal.shipmenttracker.UI.ShipmentsFragment;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.List;

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
    public static final String ACTION_GET_TRACKING = "com.faisal.shipmenttracker.action_get_tracking";
    public static final String TRACKING_OBJECT = "trackingObj";
    public static final String TRACKING = "tracking";
    public static final String SLUG = "slug";
    public static final String SHIPMENT_OBJECT = "shipmentObj";

    private Retrofit retrofit = NetworkClient.getRetrofitClient();
    private API api = retrofit.create(API.class);
    private ArchiveDatabase dbM;
    int pos = 0;

    public ShipmentsUtils() {
        super("ShipmentsUtils");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            switch (action) {
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
                    deleteShipment(slug, tracking);
                    break;

                case ACTION_GET_TRACKING:
                    handleActionGetTracking();
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
                } else {
                    ShipmentsFragment.refresh();
                }
            }

            @Override
            public void onFailure(@NotNull Call<JSONObject> call, @NotNull Throwable t) {

            }
        });

    }

    public static void startActionGetTracking(Context context) {
        Intent intent = new Intent(context, ShipmentsUtils.class);
        intent.setAction(ACTION_GET_TRACKING);
        context.startService(intent);
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

    private void handleActionGetTracking() {
        Call<Shipment> post = api.getShipments(MainActivity.id);
        post.enqueue(new Callback<Shipment>() {
            @Override
            public void onResponse(Call<Shipment> call, Response<Shipment> response) {
                if (response.body() != null) {
                    update(response.body());
                }
            }

            @Override
            public void onFailure(Call<Shipment> call, Throwable t) {

            }
        });
    }

    private void update(Shipment entries) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, ShipmentWidget.class));
        if (entries != null) {
            ShipmentWidget.updateTrackingWidgets(this, appWidgetManager, appWidgetIds, entries.getData().getTrackings().get(pos));
            pos++;
            if (pos > entries.getData().getTrackings().size() - 1) {
                pos = 0;
            }
        } else {
            ShipmentWidget.updateTrackingWidgets(this, appWidgetManager, appWidgetIds, null);
        }

    }

}
