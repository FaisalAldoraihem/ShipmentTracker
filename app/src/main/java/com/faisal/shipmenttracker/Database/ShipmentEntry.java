package com.faisal.shipmenttracker.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.faisal.shipmenttracker.POJO.Tracking;

import org.jetbrains.annotations.NotNull;
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

    public ShipmentEntry(@NotNull String id, Tracking tracking) {
        this.id = id;
        this.tracking = tracking;
    }

    @NotNull
    public String getId() {
        return id;
    }

    public Tracking getTracking() {
        return tracking;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }
}
