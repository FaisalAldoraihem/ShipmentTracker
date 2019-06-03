package com.faisal.shipmenttracker.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.faisal.shipmenttracker.POJO.Tracking;

import org.parceler.Parcel;


@Entity(tableName = "Shipment")
@Parcel
public class ShipmentEntry {
    @PrimaryKey
    @NonNull
    public String id;
    public Tracking tracking;

    @Ignore
    public ShipmentEntry() {
    }

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
