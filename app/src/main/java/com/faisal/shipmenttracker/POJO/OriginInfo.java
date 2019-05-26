package com.faisal.shipmenttracker.POJO;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginInfo {

    @SerializedName("ReferenceNumber")
    @Expose
    private Object referenceNumber;
    @SerializedName("ItemReceived")
    @Expose
    private String itemReceived;
    @SerializedName("ItemDispatched")
    @Expose
    private Object itemDispatched;
    @SerializedName("DepartfromAirport")
    @Expose
    private Object departfromAirport;
    @SerializedName("ArrivalfromAbroad")
    @Expose
    private Object arrivalfromAbroad;
    @SerializedName("CustomsClearance")
    @Expose
    private Object customsClearance;
    @SerializedName("DestinationArrived")
    @Expose
    private Object destinationArrived;
    @SerializedName("weblink")
    @Expose
    private String weblink;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("carrier_code")
    @Expose
    private String carrierCode;
    @SerializedName("trackinfo")
    @Expose
    private List<Trackinfo> trackinfo = null;

    public Object getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Object referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getItemReceived() {
        return itemReceived;
    }

    public void setItemReceived(String itemReceived) {
        this.itemReceived = itemReceived;
    }

    public Object getItemDispatched() {
        return itemDispatched;
    }

    public void setItemDispatched(Object itemDispatched) {
        this.itemDispatched = itemDispatched;
    }

    public Object getDepartfromAirport() {
        return departfromAirport;
    }

    public void setDepartfromAirport(Object departfromAirport) {
        this.departfromAirport = departfromAirport;
    }

    public Object getArrivalfromAbroad() {
        return arrivalfromAbroad;
    }

    public void setArrivalfromAbroad(Object arrivalfromAbroad) {
        this.arrivalfromAbroad = arrivalfromAbroad;
    }

    public Object getCustomsClearance() {
        return customsClearance;
    }

    public void setCustomsClearance(Object customsClearance) {
        this.customsClearance = customsClearance;
    }

    public Object getDestinationArrived() {
        return destinationArrived;
    }

    public void setDestinationArrived(Object destinationArrived) {
        this.destinationArrived = destinationArrived;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public List<Trackinfo> getTrackinfo() {
        return trackinfo;
    }

    public void setTrackinfo(List<Trackinfo> trackinfo) {
        this.trackinfo = trackinfo;
    }

}
