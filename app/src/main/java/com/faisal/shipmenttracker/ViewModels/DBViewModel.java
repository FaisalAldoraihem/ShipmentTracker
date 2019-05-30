package com.faisal.shipmenttracker.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.faisal.shipmenttracker.Database.ArchiveDatabase;
import com.faisal.shipmenttracker.Database.ShipmentEntry;

import java.util.List;

public class DBViewModel extends AndroidViewModel {
    private final LiveData<List<ShipmentEntry>> mShipments;

    public DBViewModel(@NonNull Application application) {
        super(application);
        ArchiveDatabase database = ArchiveDatabase.getInstance(this.getApplication());
        mShipments = database.shipmentDao().laodAllShipments();
    }

    public LiveData<List<ShipmentEntry>> getmShipments() {
        return mShipments;
    }
}
