package com.faisal.shipmenttracker.POJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trackinfo {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("StatusDescription")
    @Expose
    private String statusDescription;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("checkpoint_status")
    @Expose
    private String checkpointStatus;
    @SerializedName("ItemNode")
    @Expose
    private String itemNode;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCheckpointStatus() {
        return checkpointStatus;
    }

    public void setCheckpointStatus(String checkpointStatus) {
        this.checkpointStatus = checkpointStatus;
    }

    public String getItemNode() {
        return itemNode;
    }

    public void setItemNode(String itemNode) {
        this.itemNode = itemNode;
    }

}
