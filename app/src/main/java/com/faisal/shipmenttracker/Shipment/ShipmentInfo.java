package com.faisal.shipmenttracker.Shipment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ShipmentInfo {

    @SerializedName("tracking_number")
    @Expose
    private String tracking_number;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("customer_name")
    @Expose
    private String customer_name;

    public ShipmentInfo(String tracking_number, String customer_name) {
        this.tracking_number = tracking_number;
        this.customer_name = customer_name;
    }

    public ShipmentInfo(String tracking_number, String title, String customer_name) {
        this.tracking_number = tracking_number;
        this.title = title;
        this.customer_name = customer_name;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
}
