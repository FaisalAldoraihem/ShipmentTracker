package com.faisal.shipmenttracker.POJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

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
    @SerializedName("destination_country")
    @Expose
    private Object destinationCountry;
    @SerializedName("itemTimeLength")
    @Expose
    private Integer itemTimeLength;
    @SerializedName("stayTimeLength")
    @Expose
    private Integer stayTimeLength;
    @SerializedName("origin_info")
    @Expose
    private OriginInfo originInfo;
    @SerializedName("service_code")
    @Expose
    private String serviceCode;
    @SerializedName("status_info")
    @Expose
    private String statusInfo;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("substatus")
    @Expose
    private Object substatus;
    @SerializedName("packageStatus")
    @Expose
    private String packageStatus;
    @SerializedName("lastEvent")
    @Expose
    private String lastEvent;
    @SerializedName("lastUpdateTime")
    @Expose
    private String lastUpdateTime;

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

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

    public Object getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(Object destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public Integer getItemTimeLength() {
        return itemTimeLength;
    }

    public void setItemTimeLength(Integer itemTimeLength) {
        this.itemTimeLength = itemTimeLength;
    }

    public Integer getStayTimeLength() {
        return stayTimeLength;
    }

    public void setStayTimeLength(Integer stayTimeLength) {
        this.stayTimeLength = stayTimeLength;
    }

    public OriginInfo getOriginInfo() {
        return originInfo;
    }

    public void setOriginInfo(OriginInfo originInfo) {
        this.originInfo = originInfo;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Object getSubstatus() {
        return substatus;
    }

    public void setSubstatus(Object substatus) {
        this.substatus = substatus;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
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

}
