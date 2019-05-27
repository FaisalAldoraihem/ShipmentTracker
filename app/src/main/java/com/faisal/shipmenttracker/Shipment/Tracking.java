package com.faisal.shipmenttracker.Shipment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tracking {
    @SerializedName("tracking")
    @Expose
    public ShipmentInfo info;

    public Tracking(ShipmentInfo info) {
        this.info = info;
    }
}
