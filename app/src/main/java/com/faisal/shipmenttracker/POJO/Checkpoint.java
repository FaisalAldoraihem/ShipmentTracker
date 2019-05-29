package com.faisal.shipmenttracker.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Checkpoint {

    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("country_name")
    @Expose
    public String countryName;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("country_iso3")
    @Expose
    public String countryIso3;
    @SerializedName("tag")
    @Expose
    public String tag;
    @SerializedName("subtag")
    @Expose
    public String subtag;
    @SerializedName("subtag_message")
    @Expose
    public String subtagMessage;
    @SerializedName("checkpoint_time")
    @Expose
    public String checkpointTime;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("zip")
    @Expose
    public String zip;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCity() {
        return city;
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


    public String getState() {
        return state;
    }


    public String getZip() {
        return zip;
    }


}