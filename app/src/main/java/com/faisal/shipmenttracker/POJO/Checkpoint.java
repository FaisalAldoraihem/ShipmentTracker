package com.faisal.shipmenttracker.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Checkpoint {

    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("country_iso3")
    @Expose
    private String countryIso3;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("subtag")
    @Expose
    private String subtag;
    @SerializedName("subtag_message")
    @Expose
    private String subtagMessage;
    @SerializedName("checkpoint_time")
    @Expose
    private String checkpointTime;
    @SerializedName("coordinates")
    @Expose
    private List<Object> coordinates = null;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("zip")
    @Expose
    private Object zip;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCountryIso3() {
        return countryIso3;
    }

    public void setCountryIso3(String countryIso3) {
        this.countryIso3 = countryIso3;
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

    public String getCheckpointTime() {
        return checkpointTime;
    }

    public void setCheckpointTime(String checkpointTime) {
        this.checkpointTime = checkpointTime;
    }

    public List<Object> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Object> coordinates) {
        this.coordinates = coordinates;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getZip() {
        return zip;
    }

    public void setZip(Object zip) {
        this.zip = zip;
    }

}