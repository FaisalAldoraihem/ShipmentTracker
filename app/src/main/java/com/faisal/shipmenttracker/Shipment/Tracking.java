package com.faisal.shipmenttracker.Shipment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Tracking {
    public Tracking() {
    }

    @SerializedName("tracking")
    @Expose
    public ShipmentInfo info;

    public Tracking(ShipmentInfo info) {
        this.info = info;
    }
}
