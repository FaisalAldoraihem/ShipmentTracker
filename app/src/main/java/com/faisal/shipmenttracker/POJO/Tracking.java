package com.faisal.shipmenttracker.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Tracking {

    public Tracking() {
    }

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("last_updated_at")
    @Expose
    public String lastUpdatedAt;
    @SerializedName("tracking_number")
    @Expose
    public String trackingNumber;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("customer_name")
    @Expose
    public String customerName;
    @SerializedName("delivery_time")
    @Expose
    public Integer deliveryTime;
    @SerializedName("destination_country_iso3")
    @Expose
    public String destinationCountryIso3;
    @SerializedName("courier_destination_country_iso3")
    @Expose
    public String courierDestinationCountryIso3;
    @SerializedName("expected_delivery")
    @Expose
    public String expectedDelivery;
    @SerializedName("order_id")
    @Expose
    public String orderId;
    @SerializedName("order_id_path")
    @Expose
    public String orderIdPath;
    @SerializedName("origin_country_iso3")
    @Expose
    public String originCountryIso3;
    @SerializedName("shipment_package_count")
    @Expose
    public Integer shipmentPackageCount;
    @SerializedName("shipment_pickup_date")
    @Expose
    public String shipmentPickupDate;
    @SerializedName("shipment_delivery_date")
    @Expose
    public String shipmentDeliveryDate;
    @SerializedName("shipment_type")
    @Expose
    public String shipmentType;
    @SerializedName("shipment_weight")
    @Expose
    public Integer shipmentWeight;
    @SerializedName("shipment_weight_unit")
    @Expose
    public String shipmentWeightUnit;
    @SerializedName("source")
    @Expose
    public String source;
    @SerializedName("tag")
    @Expose
    public String tag;
    @SerializedName("subtag")
    @Expose
    public String subtag;
    @SerializedName("subtag_message")
    @Expose
    public String subtagMessage;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("tracked_count")
    @Expose
    public Integer trackedCount;
    @SerializedName("unique_token")
    @Expose
    public String uniqueToken;
    @SerializedName("checkpoints")
    @Expose
    public List<Checkpoint> checkpoints = null;
    @SerializedName("return_to_sender")
    @Expose
    public Boolean returnToSender;
    @SerializedName("tracking_origin_country")
    @Expose
    public String trackingOriginCountry;
    @SerializedName("tracking_destination_country")
    @Expose
    public String trackingDestinationCountry;
    @SerializedName("tracking_key")
    @Expose
    public String trackingKey;
    @SerializedName("tracking_postal_code")
    @Expose
    public String trackingPostalCode;
    @SerializedName("tracking_ship_date")
    @Expose
    public String trackingShipDate;
    @SerializedName("tracking_state")
    @Expose
    public String trackingState;
    @SerializedName("order_promised_delivery_date")
    @Expose
    public String orderPromisedDeliveryDate;
    @SerializedName("pickup_location")
    @Expose
    public String pickupLocation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String
    getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String
                                        customerName) {
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

    public String
    getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(String
                                            expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public String
    getOrderId() {
        return orderId;
    }

    public void setOrderId(String
                                   orderId) {
        this.orderId = orderId;
    }

    public String
    getOrderIdPath() {
        return orderIdPath;
    }

    public void setOrderIdPath(String
                                       orderIdPath) {
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

    public Boolean getReturnToSender() {
        return returnToSender;
    }

    public void setReturnToSender(Boolean returnToSender) {
        this.returnToSender = returnToSender;
    }


    public String
    getTrackingOriginCountry() {
        return trackingOriginCountry;
    }

    public void setTrackingOriginCountry(String
                                                 trackingOriginCountry) {
        this.trackingOriginCountry = trackingOriginCountry;
    }

    public String
    getTrackingDestinationCountry() {
        return trackingDestinationCountry;
    }

    public void setTrackingDestinationCountry(String
                                                      trackingDestinationCountry) {
        this.trackingDestinationCountry = trackingDestinationCountry;
    }

    public String
    getTrackingKey() {
        return trackingKey;
    }

    public void setTrackingKey(String
                                       trackingKey) {
        this.trackingKey = trackingKey;
    }

    public String
    getTrackingPostalCode() {
        return trackingPostalCode;
    }

    public void setTrackingPostalCode(String
                                              trackingPostalCode) {
        this.trackingPostalCode = trackingPostalCode;
    }

    public String
    getTrackingShipDate() {
        return trackingShipDate;
    }

    public void setTrackingShipDate(String
                                            trackingShipDate) {
        this.trackingShipDate = trackingShipDate;
    }

    public String
    getTrackingState() {
        return trackingState;
    }

    public void setTrackingState(String
                                         trackingState) {
        this.trackingState = trackingState;
    }

    public String getOrderPromisedDeliveryDate() {
        return orderPromisedDeliveryDate;
    }

    public void setOrderPromisedDeliveryDate(String orderPromisedDeliveryDate) {
        this.orderPromisedDeliveryDate = orderPromisedDeliveryDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }


}
