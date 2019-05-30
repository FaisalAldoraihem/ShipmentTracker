package com.faisal.shipmenttracker.Database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.faisal.shipmenttracker.POJO.Tracking;


@Entity(tableName = "Shipment")
public class ShipmentEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Tracking tracking;

    public ShipmentEntry(int id, Tracking tracking) {
        this.id = id;
        this.tracking = tracking;
    }

    @Ignore
    public ShipmentEntry(Tracking tracking) {
        this.tracking = tracking;
    }

    public int getId() {
        return id;
    }

    public Tracking getTracking() {
        return tracking;
    }
}
