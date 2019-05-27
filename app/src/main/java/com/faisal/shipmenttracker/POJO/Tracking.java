package com.faisal.shipmenttracker.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tracking {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("last_updated_at")
    @Expose
    private String lastUpdatedAt;
    @SerializedName("tracking_number")
    @Expose
    private String trackingNumber;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("android")
    @Expose
    private List<Object> android = null;
    @SerializedName("custom_fields")
    @Expose
    private Object customFields;
    @SerializedName("customer_name")
    @Expose
    private Object customerName;
    @SerializedName("delivery_time")
    @Expose
    private Integer deliveryTime;
    @SerializedName("destination_country_iso3")
    @Expose
    private String destinationCountryIso3;
    @SerializedName("courier_destination_country_iso3")
    @Expose
    private String courierDestinationCountryIso3;
    @SerializedName("emails")
    @Expose
    private List<Object> emails = null;
    @SerializedName("expected_delivery")
    @Expose
    private Object expectedDelivery;
    @SerializedName("ios")
    @Expose
    private List<Object> ios = null;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("order_id")
    @Expose
    private Object orderId;
    @SerializedName("order_id_path")
    @Expose
    private Object orderIdPath;
    @SerializedName("origin_country_iso3")
    @Expose
    private String originCountryIso3;
    @SerializedName("shipment_package_count")
    @Expose
    private Integer shipmentPackageCount;
    @SerializedName("shipment_pickup_date")
    @Expose
    private String shipmentPickupDate;
    @SerializedName("shipment_delivery_date")
    @Expose
    private String shipmentDeliveryDate;
    @SerializedName("shipment_type")
    @Expose
    private String shipmentType;
    @SerializedName("shipment_weight")
    @Expose
    private Integer shipmentWeight;
    @SerializedName("shipment_weight_unit")
    @Expose
    private String shipmentWeightUnit;
    @SerializedName("signed_by")
    @Expose
    private String signedBy;
    @SerializedName("smses")
    @Expose
    private List<Object> smses = null;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("subtag")
    @Expose
    private String subtag;
    @SerializedName("subtag_message")
    @Expose
    private String subtagMessage;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("tracked_count")
    @Expose
    private Integer trackedCount;
    @SerializedName("last_mile_tracking_supported")
    @Expose
    private Object lastMileTrackingSupported;
    @SerializedName("language")
    @Expose
    private Object language;
    @SerializedName("unique_token")
    @Expose
    private String uniqueToken;
    @SerializedName("checkpoints")
    @Expose
    private List<Checkpoint> checkpoints = null;
    @SerializedName("subscribed_smses")
    @Expose
    private List<Object> subscribedSmses = null;
    @SerializedName("subscribed_emails")
    @Expose
    private List<Object> subscribedEmails = null;
    @SerializedName("return_to_sender")
    @Expose
    private Boolean returnToSender;
    @SerializedName("tracking_account_number")
    @Expose
    private Object trackingAccountNumber;
    @SerializedName("tracking_origin_country")
    @Expose
    private Object trackingOriginCountry;
    @SerializedName("tracking_destination_country")
    @Expose
    private Object trackingDestinationCountry;
    @SerializedName("tracking_key")
    @Expose
    private Object trackingKey;
    @SerializedName("tracking_postal_code")
    @Expose
    private Object trackingPostalCode;
    @SerializedName("tracking_ship_date")
    @Expose
    private Object trackingShipDate;
    @SerializedName("tracking_state")
    @Expose
    private Object trackingState;
    @SerializedName("order_promised_delivery_date")
    @Expose
    private String orderPromisedDeliveryDate;
    @SerializedName("delivery_type")
    @Expose
    private String deliveryType;
    @SerializedName("pickup_location")
    @Expose
    private String pickupLocation;
    @SerializedName("pickup_note")
    @Expose
    private Object pickupNote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Object> getAndroid() {
        return android;
    }

    public void setAndroid(List<Object> android) {
        this.android = android;
    }

    public Object getCustomFields() {
        return customFields;
    }

    public void setCustomFields(Object customFields) {
        this.customFields = customFields;
    }

    public Object getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Object customerName) {
        this.customerName = customerName;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDestinationCountryIso3() {
        return destinationCountryIso3;
    }

    public void setDestinationCountryIso3(String destinationCountryIso3) {
        this.destinationCountryIso3 = destinationCountryIso3;
    }

    public String getCourierDestinationCountryIso3() {
        return courierDestinationCountryIso3;
    }

    public void setCourierDestinationCountryIso3(String courierDestinationCountryIso3) {
        this.courierDestinationCountryIso3 = courierDestinationCountryIso3;
    }

    public List<Object> getEmails() {
        return emails;
    }

    public void setEmails(List<Object> emails) {
        this.emails = emails;
    }

    public Object getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Object expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public List<Object> getIos() {
        return ios;
    }

    public void setIos(List<Object> ios) {
        this.ios = ios;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Object getOrderIdPath() {
        return orderIdPath;
    }

    public void setOrderIdPath(Object orderIdPath) {
        this.orderIdPath = orderIdPath;
    }

    public String getOriginCountryIso3() {
        return originCountryIso3;
    }

    public void setOriginCountryIso3(String originCountryIso3) {
        this.originCountryIso3 = originCountryIso3;
    }

    public Integer getShipmentPackageCount() {
        return shipmentPackageCount;
    }

    public void setShipmentPackageCount(Integer shipmentPackageCount) {
        this.shipmentPackageCount = shipmentPackageCount;
    }

    public String getShipmentPickupDate() {
        return shipmentPickupDate;
    }

    public void setShipmentPickupDate(String shipmentPickupDate) {
        this.shipmentPickupDate = shipmentPickupDate;
    }

    public String getShipmentDeliveryDate() {
        return shipmentDeliveryDate;
    }

    public void setShipmentDeliveryDate(String shipmentDeliveryDate) {
        this.shipmentDeliveryDate = shipmentDeliveryDate;
    }

    public String getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(String shipmentType) {
        this.shipmentType = shipmentType;
    }

    public Integer getShipmentWeight() {
        return shipmentWeight;
    }

    public void setShipmentWeight(Integer shipmentWeight) {
        this.shipmentWeight = shipmentWeight;
    }

    public String getShipmentWeightUnit() {
        return shipmentWeightUnit;
    }

    public void setShipmentWeightUnit(String shipmentWeightUnit) {
        this.shipmentWeightUnit = shipmentWeightUnit;
    }

    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }

    public List<Object> getSmses() {
        return smses;
    }

    public void setSmses(List<Object> smses) {
        this.smses = smses;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSubtag() {
        return subtag;
    }

    public void setSubtag(String subtag) {
        this.subtag = subtag;
    }

    public String getSubtagMessage() {
        return subtagMessage;
    }

    public void setSubtagMessage(String subtagMessage) {
        this.subtagMessage = subtagMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTrackedCount() {
        return trackedCount;
    }

    public void setTrackedCount(Integer trackedCount) {
        this.trackedCount = trackedCount;
    }

    public Object getLastMileTrackingSupported() {
        return lastMileTrackingSupported;
    }

    public void setLastMileTrackingSupported(Object lastMileTrackingSupported) {
        this.lastMileTrackingSupported = lastMileTrackingSupported;
    }

    public Object getLanguage() {
        return language;
    }

    public void setLanguage(Object language) {
        this.language = language;
    }

    public String getUniqueToken() {
        return uniqueToken;
    }

    public void setUniqueToken(String uniqueToken) {
        this.uniqueToken = uniqueToken;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public List<Object> getSubscribedSmses() {
        return subscribedSmses;
    }

    public void setSubscribedSmses(List<Object> subscribedSmses) {
        this.subscribedSmses = subscribedSmses;
    }

    public List<Object> getSubscribedEmails() {
        return subscribedEmails;
    }

    public void setSubscribedEmails(List<Object> subscribedEmails) {
        this.subscribedEmails = subscribedEmails;
    }

    public Boolean getReturnToSender() {
        return returnToSender;
    }

    public void setReturnToSender(Boolean returnToSender) {
        this.returnToSender = returnToSender;
    }

    public Object getTrackingAccountNumber() {
        return trackingAccountNumber;
    }

    public void setTrackingAccountNumber(Object trackingAccountNumber) {
        this.trackingAccountNumber = trackingAccountNumber;
    }

    public Object getTrackingOriginCountry() {
        return trackingOriginCountry;
    }

    public void setTrackingOriginCountry(Object trackingOriginCountry) {
        this.trackingOriginCountry = trackingOriginCountry;
    }

    public Object getTrackingDestinationCountry() {
        return trackingDestinationCountry;
    }

    public void setTrackingDestinationCountry(Object trackingDestinationCountry) {
        this.trackingDestinationCountry = trackingDestinationCountry;
    }

    public Object getTrackingKey() {
        return trackingKey;
    }

    public void setTrackingKey(Object trackingKey) {
        this.trackingKey = trackingKey;
    }

    public Object getTrackingPostalCode() {
        return trackingPostalCode;
    }

    public void setTrackingPostalCode(Object trackingPostalCode) {
        this.trackingPostalCode = trackingPostalCode;
    }

    public Object getTrackingShipDate() {
        return trackingShipDate;
    }

    public void setTrackingShipDate(Object trackingShipDate) {
        this.trackingShipDate = trackingShipDate;
    }

    public Object getTrackingState() {
        return trackingState;
    }

    public void setTrackingState(Object trackingState) {
        this.trackingState = trackingState;
    }

    public String getOrderPromisedDeliveryDate() {
        return orderPromisedDeliveryDate;
    }

    public void setOrderPromisedDeliveryDate(String orderPromisedDeliveryDate) {
        this.orderPromisedDeliveryDate = orderPromisedDeliveryDate;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Object getPickupNote() {
        return pickupNote;
    }

    public void setPickupNote(Object pickupNote) {
        this.pickupNote = pickupNote;
    }

}
