package com.faisal.shipmenttracker.POJO;

public class ShipmentInfo {

    private String tracking_number;
    private String carrier_code;
    private String title;

    public ShipmentInfo(String tracking_number, String carrier_code) {
        this.tracking_number = tracking_number;
        this.carrier_code = carrier_code;
    }

    public ShipmentInfo(String tracking_number, String carrier_code, String title) {
        this.tracking_number = tracking_number;
        this.carrier_code = carrier_code;
        this.title = title;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getCarrier_code() {
        return carrier_code;
    }

    public void setCarrier_code(String carrier_code) {
        this.carrier_code = carrier_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
