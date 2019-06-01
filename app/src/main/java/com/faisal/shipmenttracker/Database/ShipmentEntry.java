package com.faisal.shipmenttracker.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.faisal.shipmenttracker.POJO.Tracking;


@Entity(tableName = "Shipment")
public class ShipmentEntry {
    @PrimaryKey
    @NonNull
    private String id;
    private Tracking tracking;

    public ShipmentEntry(String id, Tracking tracking) {
        this.id = id;
        this.tracking = tracking;
    }

    public String getId() {
        return id;
    }

    public Tracking getTracking() {
        return tracking;
    }

    public void setId(String id) {
        this.id = id;
    }
}
