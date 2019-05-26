package com.faisal.shipmenttracker.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("tracking_number")
    @Expose
    private String trackingNumber;
    @SerializedName("carrier_code")
    @Expose
    private String carrierCode;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("order_create_time")
    @Expose
    private Object orderCreateTime;
    @SerializedName("customer_email")
    @Expose
    private String customerEmail;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("order_id")
    @Expose
    private Object orderId;
    @SerializedName("comment")
    @Expose
    private Object comment;
    @SerializedName("customer_name")
    @Expose
    private Object customerName;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("original_country")
    @Expose
    private String originalCountry;
    @SerializedName("itemTimeLength")
    @Expose
    private Object itemTimeLength;
    @SerializedName("stayTimeLength")
    @Expose
    private Object stayTimeLength;
    @SerializedName("service_code")
    @Expose
    private Object serviceCode;
    @SerializedName("status_info")
    @Expose
    private Object statusInfo;
    @SerializedName("substatus")
    @Expose
    private String substatus;
    @SerializedName("origin_info")
    @Expose
    private OriginInfo originInfo;
    @SerializedName("lastEvent")
    @Expose
    private String lastEvent;
    @SerializedName("lastUpdateTime")
    @Expose
    private String lastUpdateTime;
    @SerializedName("ScheduledDeliveryDate")
    @Expose
    private String scheduledDeliveryDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Object orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public Object getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Object customerName) {
        this.customerName = customerName;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getOriginalCountry() {
        return originalCountry;
    }

    public void setOriginalCountry(String originalCountry) {
        this.originalCountry = originalCountry;
    }

    public Object getItemTimeLength() {
        return itemTimeLength;
    }

    public void setItemTimeLength(Object itemTimeLength) {
        this.itemTimeLength = itemTimeLength;
    }

    public Object getStayTimeLength() {
        return stayTimeLength;
    }

    public void setStayTimeLength(Object stayTimeLength) {
        this.stayTimeLength = stayTimeLength;
    }

    public Object getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(Object serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Object getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(Object statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getSubstatus() {
        return substatus;
    }

    public void setSubstatus(String substatus) {
        this.substatus = substatus;
    }

    public OriginInfo getOriginInfo() {
        return originInfo;
    }

    public void setOriginInfo(OriginInfo originInfo) {
        this.originInfo = originInfo;
    }

    public String getLastEvent() {
        return lastEvent;
    }

    public void setLastEvent(String lastEvent) {
        this.lastEvent = lastEvent;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getScheduledDeliveryDate() {
        return scheduledDeliveryDate;
    }

    public void setScheduledDeliveryDate(String scheduledDeliveryDate) {
        this.scheduledDeliveryDate = scheduledDeliveryDate;
    }

}